package org.poem.lang.core.method;

import java.util.List;

/**
 * java 方法
 */
public class Method {

    /**
     * 方法名称
     */
    private String name;

    /**
     * 只有一个参数参数
     * 方法返回数据类型
     */
    private ReturnPara returnPara;

    /**
     * 多个方法参数
     * 方法参数
     */
    private List<MethodParameter> methodParameters;


    /**
     * 方法异常
     * 方法所抛出的异常，和方法里面抛出异常
     */
    private List<MethodException> methodExceptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ReturnPara getReturnPara() {
        return returnPara;
    }

    public void setReturnPara(ReturnPara returnPara) {
        this.returnPara = returnPara;
    }

    public List<MethodParameter> getMethodParameters() {
        return methodParameters;
    }

    public void setMethodParameters(List<MethodParameter> methodParameters) {
        this.methodParameters = methodParameters;
    }

    public List<MethodException> getMethodExceptions() {
        return methodExceptions;
    }

    public void setMethodExceptions(List<MethodException> methodExceptions) {
        this.methodExceptions = methodExceptions;
    }
}
