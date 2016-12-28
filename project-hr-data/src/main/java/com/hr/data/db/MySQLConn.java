package com.hr.data.db;

import com.zaxxer.hikari.HikariDataSource;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MySQLConn implements Closeable {

    private Connection connection;

    public Connection getConnection() {
        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrdb_shared", "root", "root");
            HikariDataSource dataSource = MySQLDataSourceHikari.getDataSource();
            log.info("Getting conneciton from datasource..");
            connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace(); // for tutorial's sake ;)
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        try {
            log.info("Closing mysql connection...");
            connection.close();
        } catch (SQLException ex) {
            log.info("Error closing mysql conneciton. Refer to the stack trace.");
            ex.printStackTrace();
        }
    }
}
