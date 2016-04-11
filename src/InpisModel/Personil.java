/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InpisModel;

import java.sql.*;
import javax.swing.*;
import inpis.Database;
/**
 *
 * @author amazingharry95
 */
public class Personil {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Personil(){
        conn = Database.getConnection();
    }
    public ResultSet getAllData(){
        try{
            String sql = "select NRP, NAMA_PERSONIL, KORPS, PANGKAT from personil order by NRP";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs; 
    }
    
    public ResultSet getPersonilbyID(String nrp){
        try{
             String sql = "select * from personil where NRP='"+nrp+"'";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
//             if(rs.next()){
//                 
//             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
}
