package org.poem.shell.bean;

import java.lang.reflect.Method;
import java.util.Map;

public class MethodTarget {

    private final Method method;

    private final Object bean;

    private final String name;

    private final String discript;

    private final Map<String ,MethodParameter> methodParameterMap;



    public MethodTarget(Method method, Object bean, String name, String discript, Map<String, MethodParameter> methodParameterMap) {
        this.method = method;
        this.bean = bean;
        this.name = name;
        this.discript = discript;
        this.methodParameterMap = methodParameterMap;
    }

    public Map<String, MethodParameter> getMethodParameterMap() {
        return methodParameterMap;
    }

    public Method getMethod() {
        return method;
    }

    public Object getBean() {
        return bean;
    }

    public String getName() {
        return name;
    }

    public String getDiscript() {
        return discript;
    }
}
