package org.poem.lang.exception;

/**
 * 参数异常错误
 */
public class ParameterException extends Exception{

    /**
     * 参数异常错误
     * @param parameter
     */
    public ParameterException(String parameter){
        super(parameter);
    }
}
