package com.wayzim;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.persistence.EntityManager;

/**
 * springboot 引导类
 *
 * @author LiliangSun
 */
@SpringBootApplication
public class DataAnalysisApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataAnalysisApplication.class, args);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }

}
