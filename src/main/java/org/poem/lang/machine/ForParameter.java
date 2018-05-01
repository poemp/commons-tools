package org.poem.lang.machine;

import org.poem.lang.context.JavaContext;
import org.poem.lang.core.Annotation;
import org.poem.lang.core.method.MethodParameter;
import org.poem.utils.JavaMachineUtils;
import org.poem.utils.collection.Lists;

import java.lang.reflect.Parameter;
import java.util.List;

public class ForParameter {

    /**
     * 方法参数
     */
    private Parameter[] parameters;



    public ForParameter(Parameter[] parameters) {
        this.parameters = parameters;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    public void setParameters(Parameter[] parameters) {
        this.parameters = parameters;
    }

    public List<MethodParameter> build() {
        List<MethodParameter> methodParameters = Lists.empty();
        MethodParameter methodParameter;
        if(this.parameters != null && this.parameters.length > 0){
            for (Parameter parameter : parameters) {
                methodParameter = new MethodParameter();
                methodParameter = JavaContext.canPush(parameter.getType(),methodParameter);
                methodParameter.setName(parameter.getName());
                methodParameter.setClazz(JavaMachineUtils.buildClass(parameter.getType()));
                methodParameter.setAnnotations(JavaMachineUtils.annotationsType(parameter.getAnnotations()));
                methodParameters.add(methodParameter);
            }
            return methodParameters;
        }
        return null;
    }
}
