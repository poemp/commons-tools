package org.poem.lang.loader;

import org.poem.lang.core.JavaClass;

import java.util.List;

/**
 * Java Class 加载
 */
public class ClassLoader {

    /**
     * 需要加载的类
     */
    private List<String> classNames;

    /**
     * 类加载
     */
    private static ClassLoader classLoader;

    /**
     * constructor
     * @param classNames
     */
    private ClassLoader(List<String> classNames) {
        this.classNames = classNames;
    }

    public static ClassLoader build(List<String> classNames) {
        return new ClassLoader(classNames);
    }

    /**
     * 加载类
     * @return
     */
    public List<JavaClass> javaClass(){
        return null;
    }
}
