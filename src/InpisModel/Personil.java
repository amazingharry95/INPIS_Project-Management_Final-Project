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
public class Personil {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    List<String> Personil = new ArrayList<String>();
    
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
            java.util.Date tamatTNI, java.util.Date tglLahirPersonil, String tmptLahirPersonil, 
            java.util.Date tmtPangkatPertama, java.util.Date tmtPangkatTerakhir, String alamatPersonil) {
        try{
            String sql = "Insert into personil (NRP, AGAMA_PERSONIL, GOL_DARAH_PERSONIL,"
                    + "JABATAN, KORPS, NAMA_PERSONIL, NO_ASABRI, NO_BPJS, NO_KTA, NO_NPWP,"
                    + "NO_TELPON, PANGKAT, PENDIDIKAN_MILITER, PENDIDIKAN_PENGEMBANG, PENDIDIKAN_UMUM,"
                    + "STATUS_KELUARGA, STATUS_RUMAH, TMT_JABATAN, TMT_TNI, TEMPAT_LAHIR_PERSONIL,"
                    + "TANGGAL_LAHIR_PERSONIL, TMT_PANGKAT_PERTAMA, TMT_PANGKAT_TERAKHIR, ALAMAT_PERSONIL) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
 
            java.sql.Date TamatTNI, TamatJabatan, TmtPangkatPertama, TmtPangkatTerakhir, TglLahirPersonil;
            TamatJabatan = new java.sql.Date(tamatJabatan.getTime());
            TamatTNI = new java.sql.Date(tamatTNI.getTime());
            TmtPangkatPertama = new java.sql.Date(tmtPangkatPertama.getTime());
            TmtPangkatTerakhir = new java.sql.Date(tmtPangkatTerakhir.getTime());
            TglLahirPersonil = new java.sql.Date(tglLahirPersonil.getTime());
//            String TTLPersonil = tmptLahirPersonil.concat(", ").concat(tglLahirPersonil);
            
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
            pst.setString(20, tmptLahirPersonil);
            pst.setDate(21, TglLahirPersonil);
            pst.setDate(22, TmtPangkatPertama);
            pst.setDate(23, TmtPangkatTerakhir);
            pst.setString(24, alamatPersonil);
           
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
    
    public List<String> getPersonilbyID(String nrp){
        try{
             String sql = "select * from personil where NRP='"+nrp+"'";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next()){
                 Personil.add(rs.getString("NAMA_PERSONIL"));
                 Personil.add(rs.getString("PANGKAT"));
                 Personil.add(rs.getString("KORPS"));
                 Personil.add(rs.getString("NRP"));
                 Personil.add(rs.getString("JABATAN"));
                 Personil.add(rs.getString("TMT_JABATAN"));
                 Personil.add(rs.getString("TMT_TNI"));
                 Personil.add(rs.getString("TMT_PANGKAT_PERTAMA"));
                 Personil.add(rs.getString("TMT_PANGKAT_TERAKHIR"));
                 Personil.add(rs.getString("TEMPAT_LAHIR_PERSONIL"));
                 Personil.add(rs.getString("TANGGAL_LAHIR_PERSONIL"));
                 Personil.add(rs.getString("PENDIDIKAN_UMUM"));
                 Personil.add(rs.getString("PENDIDIKAN_MILITER"));
                 Personil.add(rs.getString("PENDIDIKAN_PENGEMBANG"));
                 Personil.add(rs.getString("AGAMA_PERSONIL"));
                 Personil.add(rs.getString("GOL_DARAH_PERSONIL"));
                 Personil.add(rs.getString("NO_KTA"));
                 Personil.add(rs.getString("NO_ASABRI"));
                 Personil.add(rs.getString("NO_BPJS"));
                 Personil.add(rs.getString("NO_NPWP"));
                 Personil.add(rs.getString("ALAMAT_PERSONIL"));
                 Personil.add(rs.getString("STATUS_RUMAH"));
                 Personil.add(rs.getString("NO_TELPON"));
                 Personil.add(rs.getString("STATUS_KELUARGA"));
             }
             this.getPersonilIstriNama(nrp);
             this.getPersonilAnakNama(nrp);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return Personil;
    }
    
    public void getPersonilIstriNama(String nrp){
        try{
            String sql = "select NAMA from pasangan WHERE NRP='"+nrp+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                Personil.add(rs.getString("NAMA"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void getPersonilAnakNama(String nrp){
        try{
            String sql = "select NAMA_ANAK from anak WHERE NRP='"+nrp+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                Personil.add(rs.getString("NAMA_ANAK"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public Boolean deletePersonil(String nrp){
        String sql = "delete from personil where NRP=?";
        Boolean status = false;
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, nrp);
            pst.execute();
           JOptionPane.showMessageDialog(null, "Terhapus");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return status;
    }
    
    public int updatePersonil(String NRP, String agamaPersonil, String golDarahPersonil, String jabatan, 
            String korps, String namaPersonil, String noASABRI, String noBPJS, String noKTA, String noNPWP, 
            String noTelepon, String pangkat, String penMiliter, String penPengembang, String penUmum, 
            String statusKeluarga, String statusRumah, String tamatJabatan, 
            String tamatTNI, String tglLahirPersonil, String tmptLahirPersonil, 
            String tmtPangkatPertama, String tmtPangkatTerakhir, String alamatPersonil)
    {
        int status = 0;
        try{
            String sql = "Update personil set AGAMA_PERSONIL='"+agamaPersonil+"', GOL_DARAH_PERSONIL='"+golDarahPersonil+"', JABATAN='"
                    +jabatan+"', KORPS='"+korps+"', NAMA_PERSONIL='"+namaPersonil+"', NO_ASABRI='"+noASABRI+"', NO_BPJS='"+noBPJS+"', NO_KTA='"
                    +noKTA+"', NO_NPWP='"+noNPWP+"', NO_TELPON='"+noTelepon+"', PANGKAT='"+pangkat+"', PENDIDIKAN_MILITER='"+penMiliter+"', PENDIDIKAN_PENGEMBANG='"
                    +penPengembang+"', PENDIDIKAN_UMUM='"+penUmum+"', STATUS_KELUARGA='"+statusKeluarga+"', STATUS_RUMAH='"+statusRumah+"', TMT_JABATAN=DATE(STR_TO_DATE('"+tamatJabatan+"', '%d-%m-%Y'))"+
                    ", TMT_TNI=DATE(STR_TO_DATE('"+tamatTNI+"', '%d-%m-%Y'))"+",TANGGAL_LAHIR_PERSONIL=DATE(STR_TO_DATE('"+tglLahirPersonil+"', '%d-%m-%Y'))"+",TEMPAT_LAHIR_PERSONIL='"+tmptLahirPersonil+"', TMT_PANGKAT_PERTAMA=DATE(STR_TO_DATE('"+tmtPangkatPertama+"', '%d-%m-%Y'))"+
                    ", TMT_PANGKAT_TERAKHIR=DATE(STR_TO_DATE('"+tamatTNI+"', '%d-%m-%Y'))"+", ALAMAT_PERSONIL='"+alamatPersonil+"' where NRP='"+NRP+"'";
            pst = conn.prepareStatement(sql);
            status = pst.executeUpdate();
            //JOptionPane.showMessageDialog(null, "EDIT BERHASIL");
           // status= true;
                    
                 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return status;
    }


}
