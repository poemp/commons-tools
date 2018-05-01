package org.poem.lang.loader;

import org.poem.lang.core.JavaClass;
import org.poem.lang.stream.FieldFunction;
import org.poem.lang.stream.MethodFunction;
import org.poem.utils.JavaMachineUtils;
import org.poem.utils.collection.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java 分析
 */
public class JavaLoaderMachine {

    private Class clazz;


    public JavaLoaderMachine(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public JavaClass build() {
        JavaClass javaClass = new JavaClass();
        javaClass.setName(this.clazz.getName());
        javaClass.setPath(this.clazz.getPackage().getName());
        javaClass.setMethods(this.getMethod());
        javaClass.setFields(this.getField());
        javaClass.setAnnotations(JavaMachineUtils.annotationsType(clazz.getAnnotations()));
        javaClass.setaClass(this.clazz);
        javaClass.setSuperClass(new JavaLoaderMachine(this.clazz.getSuperclass()).build());
        return  javaClass;
    }



    /**
     * @return
     */
    private List<org.poem.lang.core.field.Field> getField() {
        Field[] fields = clazz.getFields();
        if (null != fields && fields.length > 0) {
            return Lists.asList(fields).stream().map(new FieldFunction()).collect(Collectors.toList());
        }
        return Lists.empty();
    }

    /**
     * 组装方法
     *
     * @return
     */
    private List<org.poem.lang.core.method.Method> getMethod() {
        List<org.poem.lang.core.method.Method> methodList = Lists.empty();
        Method[] methods = clazz.getMethods();
        if (null != methods && methods.length > 0) {
            return Lists.asList(methods).stream().map(new MethodFunction()).collect(Collectors.toList());
        }
        return methodList;
    }
}
