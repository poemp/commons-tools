package org.poem.lang;

import org.apache.commons.io.IOUtils;
import org.poem.utils.collection.CollectionUtils;
import org.poem.utils.collection.Lists;
import org.poem.utils.file.FileUtils;
import org.poem.utils.logger.LoggerUtils;

import java.io.*;
import java.util.List;

/**
 * java 寻找类
 * <p>
 * 寻找java类
 */
public class SearchJava {

    /**
     * 默认路径
     */
    private final static String DEFAULT_PATH = "";


    /**
     * 放入的路径
     */
    private String path;


    private SearchJava(String path) {
        this.path = path;
    }

    /**
     * 默认工厂
     *
     * @return
     */
    public static SearchJava getInstance() {
        return new SearchJava(DEFAULT_PATH);
    }

    /**
     * 默认工厂
     *
     * @param path
     * @return
     */
    public static SearchJava getInstance(String path) {
        return new SearchJava(path);
    }

    /**
     * 返回文件的路径信息
     *
     * @return
     */
    public List<String> search() {
        List<String> packageName = Lists.empty();
        try {
            File file = new File(this.path);
            return this.scanFile(file.listFiles(new JavaFileNameFilter()), new JavaFileNameFilter());
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtils.error(e);
        }
        return packageName;
    }


    /**
     * 循环遍历整个文件
     *
     * @param files      文件
     * @param fileFilter 文件过滤
     * @return
     */
    private List<String> scanFile(File[] files, FileFilter fileFilter) {
        List<String> strings = Lists.empty();
        List<String> tempListFile;
        if (null == files || files.length == 0) {
            return Lists.empty();
        }
        for (File file : files) {
            if (file.isFile()) {
                strings.add(this.getFile(file));
            } else {
                tempListFile = this.scanFile(file.listFiles(fileFilter), fileFilter);
                if (CollectionUtils.isNotEmpty(tempListFile)) {
                    strings.addAll(tempListFile);
                }
            }
        }
        return strings;
    }

    /**
     * 返回文件的信息
     * @param file
     * @return
     */
    private String getFile(File file) {
        BufferedReader bufferedInputStream = null;
        String fileName = FileUtils.getFileExistName(file.getName());
        String packageName;
        try {
            bufferedInputStream = new BufferedReader(new FileReader(file));
            packageName = bufferedInputStream.readLine();
            packageName = packageName.substring(7);
            packageName = packageName.substring(0,packageName.length() - 1);
            return packageName.trim() + "." + fileName;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            LoggerUtils.error(e);
        } catch (IOException e) {
            e.printStackTrace();
            LoggerUtils.error(e);
        } finally {
            IOUtils.closeQuietly(bufferedInputStream);
        }
        return file.getPath();
    }
}
