package org.poem.lang;

import java.io.File;
import java.io.FileFilter;

public class JavaFileNameFilter implements FileFilter {


    /**
     * 数据
     * @param file
     * @return
     */
    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getName().endsWith(".java");
    }
}
