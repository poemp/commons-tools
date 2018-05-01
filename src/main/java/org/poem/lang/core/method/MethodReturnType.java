package org.poem.lang.core.method;

import org.poem.lang.core.JavaClass;

/**
 * 方法
 */
public class MethodReturnType {

    /**
     * java 方法返回的类型
     */
    private String name;

    /**
     *  java 返回类型
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
