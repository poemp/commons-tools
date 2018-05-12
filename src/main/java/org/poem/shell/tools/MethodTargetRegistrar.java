package org.poem.shell.tools;


import org.poem.shell.annotation.ShellComponent;
import org.poem.shell.annotation.ShellMethod;
import org.poem.shell.bean.MethodParameter;
import org.poem.shell.bean.MethodTarget;
import org.poem.utils.collection.Maps;
import org.poem.utils.string.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class MethodTargetRegistrar {


    private ApplicationContext applicationContext;

    /**
     * 全局的数据
     */
    private  static final Map<String, MethodTarget> commands = new HashMap<>();

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 注册方法
     */
    @PostConstruct
    public void register() {
        //获取全部的类的信息
        Map<String, Object> commandBeans = applicationContext.getBeansWithAnnotation(ShellComponent.class);
        for (Object bean : commandBeans.values()) {
            Class<?> clazz = bean.getClass();
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.err.println(bean.getClass().getName() + "  " + method.getName() + "  "+ method.getAnnotation(ShellMethod.class));
                if(method.getAnnotation(ShellMethod.class) != null){
                    ShellMethod shellMapping = method.getAnnotation(ShellMethod.class);
                    String name = shellMapping.name();
                    if(StringUtils.isEmpty(name)){
                        name = method.getName();
                    }
                    String discription = shellMapping.discription();
                    Map<String,MethodParameter> methodParameterMap = Maps.emptys();
                    TypeVariable<Method>[] typeVariables = method.getTypeParameters();
                    for (TypeVariable<Method> typeVariable : typeVariables) {
                        methodParameterMap.put(typeVariable.getName(),new MethodParameter(typeVariable.getName()));
                    }
                    MethodTarget target = new MethodTarget(method, bean, name,discription,methodParameterMap);
                    commands.put(name,target);
                }
            }
        }
    }
}
