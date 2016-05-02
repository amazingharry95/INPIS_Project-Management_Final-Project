/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InpisModel;

import InpisView.UI_Utama_v2;
import java.sql.*;
import javax.swing.*;
import inpis.Database;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @autho5
 */
public class Admin {
    Connection conn = null;
    ResultSet rs = null;
    String id = null;
    String pass = null;
    List<String> hasil = new ArrayList<String>();
    public Admin(){
        conn = Database.getConnection();
    }
    
    public List<String> Login(String username, String password) {
        try{
            Statement st = conn.createStatement();
            String sql = "SELECT username, password FROM user WHERE username='"+username+"' AND password='"+password+"'";
            rs = st.executeQuery(sql);
            if(rs.next())
            {
                hasil.add(rs.getString("username"));
                hasil.add(rs.getString("password"));
                id = hasil.get(0);
                pass = hasil.get(1);
            }
            if(id != null && pass != null && username.equals(id) && password.equals(pass))
            {
                JOptionPane.showMessageDialog(null, "Berhasil Login");
                new UI_Utama_v2().setVisible(true);

                return hasil;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Username atau password salah");
        }
        return hasil;
    }
}
