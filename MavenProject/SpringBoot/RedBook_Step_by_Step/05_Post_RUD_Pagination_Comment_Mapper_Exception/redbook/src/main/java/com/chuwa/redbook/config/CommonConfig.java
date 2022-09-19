package com.chuwa.redbook.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CommonConfig {
    /**
     * 当需要把第三方lib放入到IOC容器的时候，会用@Bean
     * @return
     */

    // "modelmapper" -> new ModelMapper();
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
