package org.poem.utils.excel;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.poem.utils.collection.Lists;
import org.poem.utils.string.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    /**
     * 读取文件
     * @param file
     * @return
     * @throws IOException
     */
    public static List<JSONObject> readExcel(File file) throws IOException {
        Workbook workbook;
        if (file.getName().endsWith("xlsx")) {
            workbook = new XSSFWorkbook(new FileInputStream(file));
        } else {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        }
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        Iterator<Cell> cellIterator;
        Iterator<Row> rowIterator;
        Sheet sheet;
        Row row;
        Cell cell;
        List<JSONObject> jsonObjects = Lists.empty();
        JSONObject jsonObject;
        while (sheetIterator.hasNext()) {
            sheet = sheetIterator.next();
            rowIterator = sheet.rowIterator();
            int rowIndex = -1, dataStartRowIndex = 0;
            List<String> header = Lists.empty();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                cellIterator = row.cellIterator();
                rowIndex++;
                jsonObject = new JSONObject();
                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();
                    if (rowIndex == 0 && cell.getColumnIndex() == 1) {
                        cell.setCellType(CellType.STRING);//无条件转为文本，迫不得已
                        if (StringUtils.isBlank(cell.getStringCellValue())) {
                            dataStartRowIndex = 1;
                            if (header.size() > 0) {
                                String data = header.get(0);
                                header.remove(data);
                            }
                            break;
                        }
                    }
                    if (rowIndex == dataStartRowIndex) {
                        cell.setCellType(CellType.STRING);//无条件转为文本，迫不得已
                        if (!header.contains(cell.getStringCellValue().trim())) {
                            header.add(cell.getStringCellValue().trim());
                        }
                    } else {
                        String vcalue;
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                vcalue = cell.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                Boolean val1 = cell.getBooleanCellValue();
                                vcalue = val1.toString();
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                                    Date theDate = cell.getDateCellValue();
                                    SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
                                    vcalue = dff.format(theDate);
                                } else {
                                    DecimalFormat df = new DecimalFormat("0");
                                    vcalue = df.format(cell.getNumericCellValue());
                                }
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                vcalue = "";
                                break;
                            default:
                                cell.setCellType(HSSFCell.CELL_TYPE_STRING);//无条件转为文本，迫不得已
                                vcalue = cell.getStringCellValue();
                        }
                        if (cell.getColumnIndex() < header.size()) {
                            jsonObject.put(header.get(cell.getColumnIndex()), vcalue);
                        }
                    }
                }
                if (jsonObject.size() > 0) {
                    jsonObjects.add(jsonObject);
                }
            }
        }
        return jsonObjects;
    }
}
