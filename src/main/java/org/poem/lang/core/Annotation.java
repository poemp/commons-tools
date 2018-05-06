package org.poem.lang.core;

/**
 * 注解
 * 可以来自方法
 * 可以来自类
 * 可以来自属性
 */
public class Annotation {

    /**
     * 注解的方法名
     */
    private String name;

    /**
     * 注解的类
     */
    private JavaClass javaClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JavaClass getJavaClass() {
        return javaClass;
    }

    public void setJavaClass(JavaClass javaClass) {
        this.javaClass = javaClass;
    }
}
