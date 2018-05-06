package org.poem.lang.core.field;

import org.poem.lang.core.Annotation;
import org.poem.lang.core.JavaClass;

import java.util.List;

/**
 * java 属性
 */
public class Field {

    /**
     * 属性的名称
     */
    private String name;

    /**
     * 属性的注解
     */
    private List<Annotation> annotations;
    /**
     * 熟悉的类型
     */
    private JavaClass javaClass;


    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

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
