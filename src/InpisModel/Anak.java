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
public class Anak {
    List<String> Anak = new ArrayList<String>();

    private static void add(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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
    public List<String> getAnakbyID(String nrp){
        try{
             String sql = "select * from anak where NRP='"+nrp+"'";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             if(rs.next()){
                 Anak.add(rs.getString("ID_ANAK"));
                 Anak.add(rs.getString("NRP"));
                 Anak.add(rs.getString("NAMA_ANAK"));
                 Anak.add(rs.getString("TEMPAT_LAHIR_ANAK"));
                 Anak.add(rs.getString("TANGGAL_LAHIR_ANAK"));
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return Anak;
    }
    
    public int updateDataAnak(String NRP, String NamaAnak,String IDAnak,String tglLahirAnak, String tmptlahiranak){
       int status = 0;
       try{
            String sql = "Update anak set NAMA_anak='"+NamaAnak+"', TEMPAT_LAHIR_ANAK='"+tmptlahiranak+"',TANGGAL_LAHIR_ANAK=DATE(STR_TO_DATE('"+tglLahirAnak+"', '%d-%m-%Y'))"+" where NRP='"+NRP+"'";
            pst = conn.prepareStatement(sql);
            status = pst.executeUpdate();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           status = 0;
       }
       
       return status;
    }
    
     public Boolean punyaAnak(String nrp){
        Boolean punya = false;
        
        try{
           // System.out.println("masuk pasnagan");
            //System.out.println("ini nrp:"+nrp);
            String sql = "SELECT COUNT(NAMA_ANAK) from anak WHERE NRP='"+nrp+"'";
            System.out.println("bawah sini");
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            int hasil;
            if(rs.next()){
                System.out.println("masuk sini");
                hasil = rs.getInt(1);
                System.out.println("hasil"+ hasil);
                  if(hasil==1){
                      punya=true;
                  }
                       
            }
            
          
            
            
        }catch(Exception e){
            
        }
        
        return punya;
    }
}
