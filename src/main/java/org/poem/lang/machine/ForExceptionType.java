package org.poem.lang.machine;

import org.poem.lang.core.method.MethodException;
import org.poem.utils.JavaMachineUtils;
import org.poem.utils.collection.Lists;

import java.util.List;

public class ForExceptionType {

    /**
     * 方法类型
     */
    private Class[] classes;

    public Class[] getClasses() {
        return classes;
    }

    public void setClasses(Class[] classes) {
        this.classes = classes;
    }

    public ForExceptionType(Class[] classes) {
        this.classes = classes;
    }

    /**
     * 创建异常方法JavaClass
     * @return
     */
    public List<MethodException> build(){
        List<MethodException> methodExceptions = Lists.empty();
        MethodException methodException;
        if(this.classes != null && this.classes.length > 0 ){
            for (Class aClass : this.classes) {
                methodException = new MethodException();
                methodException.setName(aClass.getName());
                System.err.println(aClass.getName());
                methodException.setException(JavaMachineUtils.buildClass(aClass));
                methodExceptions.add(methodException);
            }
            return methodExceptions;
        }
        return null;
    }
}
