package org.poem.lang.core.method;

import org.poem.lang.core.JavaClass;

/**
 * 方法异常
 */
public class MethodException {

    /**
     * 异常的名称
     */
    private String name;

    /**
     * 方法抛出的异常
     */
    private JavaClass exception;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JavaClass getException() {
        return exception;
    }

    public void setException(JavaClass exception) {
        this.exception = exception;
    }
}
