package com.wzu.qunawan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;

@MapperScan(value = "com.wzu.qunawan.dao")
@SpringBootApplication
public class QunawanApplication {

    public static void main(String[] args) {
        SpringApplication.run(QunawanApplication.class, args);
    }


}
