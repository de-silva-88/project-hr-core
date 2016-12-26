package com.hr.data.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

public class MySQLDataSourceHikari {

    public static HikariDataSource getDataSource() {
        return ApplicationDataSource.ds;
    }

    @Slf4j
    private static class ApplicationDataSource {

        private static HikariDataSource ds;

        static {
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("com.mysql.jdbc.Driver");
            config.setJdbcUrl("jdbc:mysql://localhost:3306/hrdb_shared");
            config.setUsername("root");
            config.setPassword("root");
            config.setMinimumIdle(4);
            config.setMaximumPoolSize(20);
            config.setMaxLifetime(20000);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            ds = new HikariDataSource(config);
            log.info("Singleton datasource created...");
        }
    }
}
