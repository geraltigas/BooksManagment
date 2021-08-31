package com.geraltigas;

import com.geraltigas.pojo.Book;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Book.class)
@MapperScan("com.geraltigas.mapper")
@SpringBootApplication
public class SpringbootLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLearningApplication.class, args);
    }

}
