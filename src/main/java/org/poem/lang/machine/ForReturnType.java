package org.poem.lang.machine;

import org.poem.lang.core.method.MethodReturnType;
import org.poem.utils.JavaMachineUtils;

public class ForReturnType {

    private  Class aClass ;

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public ForReturnType(Class aClass) {
        this.aClass = aClass;
    }


    public MethodReturnType build(){
        MethodReturnType returnType = new MethodReturnType();
        returnType.setName(this.aClass.getName());
        returnType.setJavaClass(JavaMachineUtils.buildClass(this.aClass));
        return  returnType;
    }
}
