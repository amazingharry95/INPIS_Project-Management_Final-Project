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
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rs; 
    }
    
    public ResultSet setPersonilData(String NRP, String agamaPersonil, String golDarahPersonil, String jabatan, 
            String korps, String namaPersonil, String noASABRI, String noBPJS, String noKTA, String noNPWP, 
            String noTelepon, String pangkat, String penMiliter, String penPengembang, String penUmum, 
            String statusKeluarga, String statusRumah, java.util.Date tamatJabatan, 
            java.util.Date tamatTNI, String tglLahirPersonil, String tmptLahirPersonil, 
            java.util.Date tmtPangkatPertama, java.util.Date tmtPangkatTerakhir, String alamatPersonil) {
        try{
            String sql = "Insert into personil (NRP, AGAMA_PERSONIL, GOL_DARAH_PERSONIL,"
                    + "JABATAN, KORPS, NAMA_PERSONIL, NO_ASABRI, NO_BPJS, NO_KTA, NO_NPWP,"
                    + "NO_TELPON, PANGKAT, PENDIDIKAN_MILITER, PENDIDIKAN_PENGEMBANG, PENDIDIKAN_UMUM,"
                    + "STATUS_KELUARGA, STATUS_RUMAH, TAMAT_JABATAN, TAMAT_TNI, TTL_PERSONIL,"
                    + "TMT_PANGKAT_PERTAMA, TMT_PANGKAT_TERAKHIR, ALAMAT_PERSONIL) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
 
            java.sql.Date TamatTNI, TamatJabatan, TmtPangkatPertama, TmtPangkatTerakhir;
            TamatJabatan = new java.sql.Date(tamatJabatan.getTime());
            TamatTNI = new java.sql.Date(tamatTNI.getTime());
            TmtPangkatPertama = new java.sql.Date(tmtPangkatPertama.getTime());
            TmtPangkatTerakhir = new java.sql.Date(tmtPangkatTerakhir.getTime());
            String TTLPersonil = tmptLahirPersonil.concat(", ").concat(tglLahirPersonil);
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, NRP);
            pst.setString(2, agamaPersonil);
            pst.setString(3, golDarahPersonil);
            pst.setString(4, jabatan);
            pst.setString(5, korps);
            pst.setString(6, namaPersonil);
            pst.setString(7, noASABRI);
            pst.setString(8, noBPJS);
            pst.setString(9, noKTA);
            pst.setString(10, noNPWP);
            pst.setString(11, noTelepon);
            pst.setString(12, pangkat);
            pst.setString(13, penMiliter);
            pst.setString(14, penPengembang);
            pst.setString(15, penUmum);
            pst.setString(16, statusKeluarga);
            pst.setString(17, statusRumah);
            pst.setDate(18, TamatJabatan);
            pst.setDate(19, TamatTNI);
            pst.setString(20, TTLPersonil);
            pst.setDate(21, TmtPangkatPertama);
            pst.setDate(22, TmtPangkatTerakhir);
            pst.setString(23, alamatPersonil);
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Data Personil");
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return getAllData();
    }

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

}
