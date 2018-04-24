package org.poem.lang.core;

import org.poem.lang.core.field.Field;
import org.poem.lang.core.method.Method;

import java.util.List;

/**
 * java 文件信息
 */
public class JavaClass {

    /**
     * 当前类所依赖的其他类
     */
    private List<JavaClass> javaClasses;

    /**
     * java 类的信息
     */
    private Class aClass;

    /**
     * 文件的class名称
     */
    private String name;

    /**
     * java类的方法
     */
    private String path;

    /**
     * Java 方法
     */
    private List<Field> fields;

    /**
     * java 方法
     */
    private List<Method> methods;

    public List<JavaClass> getJavaClasses() {
        return javaClasses;
    }

    public void setJavaClasses(List<JavaClass> javaClasses) {
        this.javaClasses = javaClasses;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }
}
