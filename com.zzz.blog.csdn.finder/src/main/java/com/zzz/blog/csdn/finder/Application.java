package com.zzz.blog.csdn.finder;

import com.zzz.blog.csdn.finder.config.prop.CsdnBlogerInfoProp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({CsdnBlogerInfoProp.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run (Application.class, args);
    }

}
