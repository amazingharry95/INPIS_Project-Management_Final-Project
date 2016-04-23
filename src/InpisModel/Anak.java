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
public class Anak {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public Anak(){
        conn = Database.getConnection();
    }
    
    public ResultSet setAnakData(String NRP, java.util.Date tglLahirAnak, String tmptLahirAnak, 
            String namaAnak) {
        try{
            String sql = "Insert into anak (NRP, NAMA_ANAK, TEMPAT_LAHIR_ANAK, TANGGAL_LAHIR_ANAK) VALUES (?,?,?,?)";
            
//            String TTLAnak = tmptLahirAnak.concat(", ").concat(tglLahirAnak);
            java.sql.Date TglLahirAnak;
            TglLahirAnak = new java.sql.Date(tglLahirAnak.getTime());
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, NRP);
            pst.setString(2, namaAnak);
            pst.setString(3, tmptLahirAnak);
            pst.setDate(4, TglLahirAnak);
            
          
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Data Anak");
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }
}
