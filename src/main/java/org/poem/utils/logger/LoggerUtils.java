package org.poem.utils.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*  日志打印
* 规范的打印方式，后期会添加用户的信息，用户的ip，还有方法等等信息都会放在这儿
* 后期的展望
*/
public final class LoggerUtils  {

    private static Logger logger;


    static {
        logger = LoggerFactory.getLogger(LoggerUtils.class);
    }

    /**
     * 获得当前的调用栈中类
     *
     * @return
     */
    private static StackTraceElement getStackTrace() {
        return Thread.currentThread().getStackTrace()[4];
    }

    /**
     * 获取当前执行的类的名字
     *
     * @return 类，全名
     */
    private static String getClassName() {
        StackTraceElement stackTraceElement = getStackTrace();
        return stackTraceElement.getClassName();
    }

    /**
     * 获取当前调用的方法
     *
     * @return 当前调用的方法
     */
    private static String getMethod() {
        StackTraceElement stackTraceElement = getStackTrace();
        return stackTraceElement.getMethodName();
    }

    /**
     * 获取当前使用的列
     *
     * @return 当前调用的类
     */
    private static int getLineNumber() {
        StackTraceElement stackTraceElement = getStackTrace();
        return stackTraceElement.getLineNumber();
    }

    /**
     * 定义info日志
     * @param info 打印信息
     */
    public static void info(String info){
        if(logger.isInfoEnabled()){
            logger.info(String.format("%s|%s|%d|info:%s",getClassName(),getMethod(),getLineNumber(),info));
        }
    }


    /**
     * 定义error日志级别
     * @param error 打印信息
     */
    public static void error(String error){
        if(logger.isErrorEnabled()){
            logger.info(String.format("%s|%s|%d|error:%s",getClassName(),getMethod(),getLineNumber(),error));
        }
    }
    /**
     * 定义error日志级别
     * @param error 打印信息
     */
    public static void error(Exception error){
        if(logger.isErrorEnabled()){
            logger.info(String.format("%s|%s|%d|error:%s",getClassName(),getMethod(),getLineNumber(),error.toString()));
        }
    }
    /**
     * debug
     * @param debug 打印信息
     */
    public static void debug(String debug){
        if(logger.isDebugEnabled()){
            logger.info(String.format("%s|%s|%d|debug:%s",getClassName(),getMethod(),getLineNumber(),debug));
        }
    }

    /**
     * 定义error日志级别
     * @param warn 打印信息
     */
    public static void warn(String warn){
        if(logger.isErrorEnabled()){
            logger.warn(String.format("%s|%s|%d|warn:%s",getClassName(),getMethod(),getLineNumber(),warn));
        }
    }
}
