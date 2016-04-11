/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inpis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Goronald
 */
public class Database {
    
    private static Connection connection;
    
    public static Connection getConnection() {
        
        if(connection == null) {
            try {
                String url = "jdbc:mysql://localhost/inpis";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, "root", "");
                //JOptionPane.showMessageDialog(null, "Connection Established");
                System.out.println("koneksi berhasil");
            }catch(SQLException e){
                System.out.println("koneksi gagal\n" + e);
            }
        }
        return connection;
    }
    
    public static void main(String[] args) {
        getConnection();
    }
}
