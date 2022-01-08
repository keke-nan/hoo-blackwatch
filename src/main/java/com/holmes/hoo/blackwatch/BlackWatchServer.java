package com.holmes.hoo.blackwatch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * @author A20019
 * @since 2022/1/6 20:07
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class }, scanBasePackages = {"com.holmes.hoo.blackwatch"})
@MapperScan("com.holmes.hoo.blackwatch.mapper")
public class BlackWatchServer {

    public static void main(String[] args) {
        SpringApplication.run(BlackWatchServer.class, args);
    }
}
