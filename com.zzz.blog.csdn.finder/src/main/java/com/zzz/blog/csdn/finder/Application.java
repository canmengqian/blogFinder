package com.zzz.blog.csdn.finder;

import com.zzz.blog.csdn.finder.config.prop.CsdnBlogerInfoProp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties({CsdnBlogerInfoProp.class})
@EnableScheduling
@EnableAsync
@EnableTransactionManagement(proxyTargetClass=true)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run (Application.class, args);
    }

}
