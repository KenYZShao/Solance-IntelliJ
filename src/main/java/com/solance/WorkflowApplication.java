package com.solance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class WorkflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowApplication.class, args);
    }

    @Bean
    public CommandLineRunner checkConnectionPool(DataSource dataSource) {
        return args -> {
            System.out.println("=== Database connection pool configuration verification ===");
            try (Connection conn = dataSource.getConnection()) {
                // 获取 HikariCP 特定信息
                if (dataSource instanceof com.zaxxer.hikari.HikariDataSource) {
                    com.zaxxer.hikari.HikariDataSource hikari = //
                            (com.zaxxer.hikari.HikariDataSource) dataSource;

                    System.out.println("Connection pool name: " + hikari.getPoolName());
                    System.out.println("Maximum number of connections:" + hikari.getMaximumPoolSize());
                    System.out.println("Minimum idle connection:" + hikari.getMinimumIdle());
                    System.out.println("Active connections:" + hikari.getHikariPoolMXBean().getActiveConnections());
                }

                System.out.println("Connection test successful! Database:" + conn.getMetaData().getDatabaseProductName());
            }
        };


    }
}