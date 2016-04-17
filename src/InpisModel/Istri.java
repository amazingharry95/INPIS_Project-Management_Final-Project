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
 * @author amazingharry95
 */
public class Istri {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Istri(){
        conn = Database.getConnection();
    }
    
    public ResultSet setIstriData(String NRP, String agamaIstri, String golDarahIstri, String KPIIstri, 
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
