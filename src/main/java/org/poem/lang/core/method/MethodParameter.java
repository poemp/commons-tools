package org.poem.lang.core.method;

/**
 * 方法参数
 */
public class MethodParameter {

    /**
     * 参数类型
     */
    private Class clazz;

    /**
     * 参数名字
     */
    private String name;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
