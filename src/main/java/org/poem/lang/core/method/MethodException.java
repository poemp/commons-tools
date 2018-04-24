package org.poem.lang.core.method;

/**
 * 方法异常
 */
public class MethodException {

    /**
     * 方法抛出的异常
     */
    private Class exception;

    public Class getException() {
        return exception;
    }

    public void setException(Class exception) {
        this.exception = exception;
    }
}
