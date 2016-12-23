package com.hr.service.dao;

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

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hrdb_shared", "root", "root");
        } catch (SQLException | InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace(); // for tutorial's sake ;)
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        log.warn("CLOSE FOR THE MYSQL GET CONNECTION IS NOT YET IMPLEMENTED..");
    }
}
