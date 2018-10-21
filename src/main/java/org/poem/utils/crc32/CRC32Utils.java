package org.poem.utils.crc32;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.CRC32;

/**
 * @author poem
 */
public class CRC32Utils {

    /**
     * crc32
     * @param file 文件
     * @return
     */
    public static String getCRC32(File file) {
        CRC32 crc32 = new CRC32();
        byte[] buffer = new byte[8192];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                crc32.update(buffer, 0, length);
            }
            return crc32.getValue() + "";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
