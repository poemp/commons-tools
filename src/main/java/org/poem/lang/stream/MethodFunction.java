package org.poem.lang.stream;

import org.poem.lang.machine.ForAnnotations;
import org.poem.lang.machine.ForExceptionType;
import org.poem.lang.machine.ForParameter;
import org.poem.lang.machine.ForReturnType;

import java.lang.reflect.Method;
import java.util.function.Function;

/**
 * 方法
 */
public class MethodFunction implements Function<Method, org.poem.lang.core.method.Method> {

    /**
     *
     * @param m
     * @return
     */
    @Override
    public org.poem.lang.core.method.Method apply(Method m) {
        org.poem.lang.core.method.Method poemMethod = new org.poem.lang.core.method.Method();
        poemMethod.setName(m.getName());
        poemMethod.setMethodExceptions(new ForExceptionType(m.getExceptionTypes()).build());
        poemMethod.setReturnPara(new ForReturnType(m.getReturnType()).build());
        poemMethod.setMethodParameters(new ForParameter(m.getParameters()).build());
        poemMethod.setAnnotations(new ForAnnotations(m.getAnnotations()).build());
        return poemMethod;
    }
}
