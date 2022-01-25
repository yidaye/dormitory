package com.yidaye.domitory;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages= {"com.yidaye.domitory.dao"})
@SpringBootApplication
public class DomitoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomitoryApplication.class, args);
    }

}
