package org.poem.lang.loader;

import org.poem.lang.context.JavaContext;
import org.poem.lang.core.JavaClass;
import org.poem.lang.stream.FieldFunction;
import org.poem.lang.stream.MethodFunction;
import org.poem.utils.JavaMachineUtils;
import org.poem.utils.collection.CollectionUtils;
import org.poem.utils.collection.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
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

    /**
     * 加载
     *
     * @return
     */
    public JavaClass build() {
        JavaClass javaClass = new JavaClass();
        javaClass.setName(this.clazz.getName());
        if (null != this.clazz.getPackage()) {
            javaClass.setPath(this.clazz.getPackage().getName());
        }
        //方法
        List<org.poem.lang.core.method.Method> methods = this.getMethod();
        if (CollectionUtils.isNotEmpty(methods)) {
            javaClass.setMethods(methods);
        }
        //属性
        List<org.poem.lang.core.field.Field> fieldList = this.getField();
        if (CollectionUtils.isNotEmpty(fieldList)) {
            javaClass.setFields(fieldList);
        }
        //注释
        javaClass.setAnnotations(JavaMachineUtils.annotationsType(clazz.getAnnotations()));
        javaClass.setaClass(this.clazz);
        if (null != this.clazz.getSuperclass()) {
            JavaLoaderMachine javaLoaderMachine = new JavaLoaderMachine(this.clazz.getSuperclass());
            javaLoaderMachine = JavaContext.canPush(this.clazz.getSuperclass(), javaLoaderMachine);
            javaClass.setSuperClass(javaLoaderMachine.build());
        }
        return javaClass;
    }


    /**
     * @return
     */
    private List<org.poem.lang.core.field.Field> getField() {
        Field[] fields = clazz.getFields();
        if (null != fields && fields.length > 0) {
            return Lists.asList(fields).stream()
                    .map(new FieldFunction())
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
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
        Method[] methods = this.clazz.getMethods();
        if (null != methods && methods.length > 0) {
            return Lists.asList(methods)
                    .stream()
                    .map(new MethodFunction())
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return methodList;
    }
}
