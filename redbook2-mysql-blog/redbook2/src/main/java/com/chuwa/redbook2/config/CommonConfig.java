package com.chuwa.redbook2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class CommonConfig {

    /**
     * 当需要将第三方lib放入IOC容器时，则会用@Bean
     * @return* *
     */

    //"modelmapper" -> new ModelMapper();

    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();} //after adding POM, need to reload maven changes

}
