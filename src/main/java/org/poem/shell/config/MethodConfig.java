package org.poem.shell.config;

import org.poem.shell.tools.MethodTargetRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MethodConfig {

    /**
     * init all
     * @return
     */
    @Bean
    public MethodTargetRegistrar methodTargetRegistrar(){
        return new MethodTargetRegistrar();
    }
}
