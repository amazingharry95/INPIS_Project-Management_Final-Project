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
             String sql = "select * from istri where NRP='"+nrp+"'";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next()){
                 Istri.add(rs.getString("ID_ISTRI"));
                 Istri.add(rs.getString("NRP"));
                 Istri.add(rs.getString("NAMA_ISTRI"));
                 Istri.add(rs.getString("TEMPAT_LAHIR_ISTRI"));
                 Istri.add(rs.getString("TANGGAL_LAHIR_ISTRI"));
                 Istri.add(rs.getString("AGAMA_ISTRI"));
                 Istri.add(rs.getString("GOL_DARAH_ISTRI"));
                 Istri.add(rs.getString("KPI_ISTRI"));
                 Istri.add(rs.getString("KTA_JALASENASTRI"));
                 Istri.add(rs.getString("METODE_KB"));
                 Istri.add(rs.getString("PENDIDIKAN_TERAKHIR_ISTRI"));
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
            String sql = "select * from istri where NRP='"+nrp+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs; 
    }
    public ResultSet updateIstriData(String NRP, String agamaIstri, String golDarahIstri, String KPIIstri, 
            String KTAJalasenastri, String metodeKb, String penTerakhirIstri, String tmptLahirIstri, String tglLahirIstri, 
            String namaIstri, String hobi1, String hobi2) {
        try{
            String sql = "Insert into istri (NRP, AGAMA_ISTRI, GOL_DARAH_ISTRI,"
                    + "KPI_ISTRI, KTA_JALASENASTRI, METODE_KB, PENDIDIKAN_TERAKHIR_ISTRI,"
                    + "TTL_ISTRI, NAMA_ISTRI, HOBBY1, HOBBY2) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            
            String TTLIstri = tmptLahirIstri.concat(", ").concat(tglLahirIstri);
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, NRP);
            pst.setString(2, agamaIstri);
            pst.setString(3, golDarahIstri);
            pst.setString(4, KPIIstri);
            pst.setString(5, KTAJalasenastri);
            pst.setString(6, metodeKb);
            pst.setString(7, penTerakhirIstri);
            pst.setString(8, TTLIstri);
            pst.setString(9, namaIstri);
            pst.setString(10, hobi1);
            pst.setString(11, hobi2);
          
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Data Istri");
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
}
