/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InpisModel;

import java.sql.*;
import javax.swing.*;
import inpis.Database;
import java.awt.HeadlessException;

/**
 *
 * @autho5
 */
public class Admin {
    Connection conn = null;
    ResultSet rs = null;
    String id = null;
    String pass = null;
    public Admin(){
        conn = Database.getConnection();
    }
    
    public ResultSet Login(String username, String password) {
        try{
            Statement st = conn.createStatement();
            String sql = "SELECT username, password FROM admin WHERE username='"+username+"' AND password='"+password+"'";
            
            rs = st.executeQuery(sql);
            if(rs.next())
            {
                id = rs.getString("username");
                pass = rs.getString("password");
            }
            if(id != null && pass != null && username.equals(id) && password.equals(pass))
            {
                JOptionPane.showMessageDialog(null, "Berhasil Login");
                return rs;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Username atau password salah");
        }
        return rs;
    }
}
