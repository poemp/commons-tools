package org.poem.lang.core.method;

import org.poem.lang.core.Annotation;
import org.poem.lang.core.JavaClass;

import java.util.List;

/**
 * 方法参数
 */
public class MethodParameter {

    /**
     * 参数类型
     */
    private JavaClass clazz;

    /**
     * 参数名字
     */
    private String name;

    /**
     * 类的注解
     */
    private List<Annotation> annotations;


    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public JavaClass getClazz() {
        return clazz;
    }

    public void setClazz(JavaClass clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
