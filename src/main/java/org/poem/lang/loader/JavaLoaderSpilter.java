package org.poem.lang.loader;

import org.poem.lang.core.JavaClass;
import org.poem.utils.collection.Lists;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * java 分析
 */
public class JavaLoaderSpilter {

    private Class clazz;


    public JavaLoaderSpilter(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public JavaClass build(){
        JavaClass javaClass = new JavaClass();
        javaClass.setName(this.clazz.getName());
        javaClass.setPath(this.clazz.getPackage().getName());

        Field[] fields = clazz.getFields();
        Package packag = clazz.getPackage();
        Annotation[] annotations = clazz.getAnnotations();
    }

    /**
     * 组装方法
     * @return
     */
    private List<org.poem.lang.core.method.Method> getMethod(){
        List<org.poem.lang.core.method.Method> methodList = Lists.empty();
        Method[] methods = clazz.getMethods();
        org.poem.lang.core.method.Method method;
        if(null != methods && methods.length > 0 ){
            for (Method m : methods) {
                method  = new org.poem.lang.core.method.Method();
                method.setName(m.getName());
                method.setMethodExceptions(m.getExceptionTypes());
                method.setReturnPara(m.getReturnType());
                method.setMethodParameters(m.getParameters());
                method.setAnnotations(m.getAnnotations());
                methodList.add(method);
            }
        }
        return methodList;
    }
}
