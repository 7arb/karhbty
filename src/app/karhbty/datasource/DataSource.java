/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.karhbty.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Houssem Eddine
 */
//Singleton
public class DataSource {

    String url = "jdbc:mysql://localhost:3306/karhbty";
    String username = "root";
    String password  = "";

    private Connection connection;
    private static DataSource instance;

    private DataSource() {
        try {
            connection = DriverManager
                    .getConnection(url, username, password);
            System.out.println("hello");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DataSource getInstance(){
        if(instance == null){
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
