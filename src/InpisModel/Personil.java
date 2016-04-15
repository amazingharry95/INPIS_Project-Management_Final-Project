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
            String sql = "select NRP, NAMA_PERSONIL, JABATAN, KORPS from personil order by NRP";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
//            while(rs.next()) {
//                Object[] o = new Object[3];
//                o[0] = rs.getString("NRP");
//                o[1] = rs.getString("Nama_Personil");
//                o[2] = rs.getString("Agama_Personil");
//            } 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs; 
    }
    
    //    private void loadTabelPersonil() {
//        Connection connection = Database.getConnection();
//        String sql = "SELECT * from Personil";
//        try {
//            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
//            ResultSet result = statement.executeQuery();
//            while(result.next()) {
//                Object[] o = new Object[3];
//                o[0] = result.getString("NRP");
//                o[1] = result.getString("Nama_Personil");
//                o[2] = result.getString("Agama_Personil");
//                
//                tabelModel.addRow(o);
//            }
//        }catch(SQLException e) {
//            System.out.println(e);
//        }
//                
//    }
    
    public ResultSet cariPersonilByKeyword(String filter, String keyword) {
        try{
            String sql = "select NRP, NAMA_PERSONIL, JABATAN, KORPS from personil where " + filter + " LIKE '%"+ keyword +"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
    
    public ResultSet getPersonilbyID(String nrp){
        try{
             String sql = "select * from personil where NRP='"+nrp+"'";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
}
