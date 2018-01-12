package com.alipay.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GsonConfig created with IntelliJ IDEA.
 * User: PengFei
 * Date: 2018-01-12
 * Time: 10:54
 */
@Configuration
public class GsonConfig {

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
