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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amazingharry95
 */
public class Pasangan {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List<String> Istri = new ArrayList<String>();
    
    public Pasangan(){
        conn = Database.getConnection();
    }
    
    public ResultSet setIstriData(String NRP, String agamaIstri, String golDarahIstri, String KPIIstri, 
            String KTAJalasenastri, String metodeKb, String penTerakhirIstri, String tmptLahirIstri, java.util.Date tglLahirIstri, 
            String namaIstri, String hobi1, String hobi2) {
        try{
            String sql = "Insert into pasangan (NRP, AGAMA, GOL_DARAH,"
                    + "KPI, KTA_JALASENASTRI, METODE_KB, PENDIDIKAN_TERAKHIR,"
                    + "TEMPAT_LAHIR, TANGGAL_LAHIR, NAMA, HOBBY1, HOBBY2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            
            java.sql.Date TglLahirIstri;
            TglLahirIstri = new java.sql.Date(tglLahirIstri.getTime());
            
//            String TTLIstri = tmptLahirIstri.concat(", ").concat(tglLahirIstri);
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, NRP);
            pst.setString(2, agamaIstri);
            pst.setString(3, golDarahIstri);
            pst.setString(4, KPIIstri);
            pst.setString(5, KTAJalasenastri);
            pst.setString(6, metodeKb);
            pst.setString(7, penTerakhirIstri);
            pst.setString(8, tmptLahirIstri);
            pst.setDate(9, TglLahirIstri);
            pst.setString(10, namaIstri);
            pst.setString(11, hobi1);
            pst.setString(12, hobi2);
          
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Data Istri");
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
    public List<String> getIstribyID(String nrp){
        try{
             String sql = "select * from pasangan where NRP='"+nrp+"'";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next()){
                 Istri.add(rs.getString("ID_PASANGAN"));
                 Istri.add(rs.getString("NRP"));
                 Istri.add(rs.getString("NAMA"));
                 Istri.add(rs.getString("TEMPAT_LAHIR"));
                 Istri.add(rs.getString("TANGGAL_LAHIR"));
                 Istri.add(rs.getString("AGAMA"));
                 Istri.add(rs.getString("GOL_DARAH"));
                 Istri.add(rs.getString("KPI"));
                 Istri.add(rs.getString("KTA_JALASENASTRI"));
                 Istri.add(rs.getString("METODE_KB"));
                 Istri.add(rs.getString("PENDIDIKAN_TERAKHIR"));
                 Istri.add(rs.getString("HOBBY1"));
                 Istri.add(rs.getString("HOBBY2"));
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return Istri;
    }
    public ResultSet getDataIstri(String nrp){
        try{
            String sql = "select * from pasangan where NRP='"+nrp+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs; 
    }
    public ResultSet updateIstriData(String NRP, String agamaIstri, String golDarahIstri, String KPIIstri, 
            String KTAJalasenastri, String metodeKb, String penTerakhirIstri, String tmptLahirIstri, Date tglLahirIstri, 
            String namaIstri, String hobi1, String hobi2) {
        try{
            String sql = "Insert into pasangan (NRP, AGAMA, GOL_DARAH,"
                    + "KPI, KTA_JALASENASTRI, METODE_KB, PENDIDIKAN_TERAKHIR,"
                    + "TEMPAT_LAHIR, TANGGAL_LAHIR, NAMA, HOBBY1, HOBBY2) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            
            //String TTLIstri = tmptLahirIstri.concat(", ").concat(tglLahirIstri);
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, NRP);
            pst.setString(2, agamaIstri);
            pst.setString(3, golDarahIstri);
            pst.setString(4, KPIIstri);
            pst.setString(5, KTAJalasenastri);
            pst.setString(6, metodeKb);
            pst.setString(7, penTerakhirIstri);
            pst.setString(8, tmptLahirIstri);
            pst.setDate(9, tglLahirIstri);
            pst.setString(10, namaIstri);
            pst.setString(11, hobi1);
            pst.setString(12, hobi2);
          
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Data Istri");
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
    
    public int updateDataIstri(String nrp, String nama, String tmptLahir, 
            String tanggalLahir, String agama, String golDarah, String KPI, String KTA, String metodeKB, String pendidikanTerakhir, String hobby1, String hobby2){
       int status = 0;
       try{
            String sql = "Update pasangan set NAMA='"+nama+"', TEMPAT_LAHIR='"+tmptLahir+"', TANGGAL_LAHIR=DATE(STR_TO_DATE('"+tanggalLahir+"', '%d-%m-%Y'))', AGAMA='"+agama+"', GOL_DARAH='"+golDarah
                          +"', KPI='"+KPI+"', KTA_JALASENASTRI='"+KTA+"', METODE_KB='"+metodeKB+"', PENDIDIKAN_TERAKHIR='"+pendidikanTerakhir+"', HOBBY1='"+hobby1
                          +"', HOBBY2='"+hobby2+"' where NRP='"+nrp+"'";
            pst = conn.prepareStatement(sql);
            status = pst.executeUpdate();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           status = 0;
       }
       
       return status;
    }
}
