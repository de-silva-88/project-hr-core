package com.hr.service.dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConn implements Closeable {

    public Connection getConnection(){
        try {
            Class.forName(
                    System.getProperty("jdbc.driver")
            ).newInstance();
            return DriverManager.getConnection(
                    System.getProperty("jdbc.url"),
                    System.getProperty("jdbc.user"),
                    System.getProperty("jdbc.password"));
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // for tutorial's sake ;)
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
