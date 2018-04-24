package org.poem.lang.core.field;

import org.poem.lang.core.JavaClass;

/**
 * java 属性
 */
public class Field {

    /**
     * 属性的名称
     */
    private String name;

    /**
     * 熟悉的类型
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
