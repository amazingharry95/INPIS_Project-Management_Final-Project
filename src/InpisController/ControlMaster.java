/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InpisController;

import InpisModel.*;
import java.util.Date;
import java.sql.ResultSet;
import java.util.List;
/**
 *
 * @author amazingharry95
 */
public class ControlMaster {
    Personil personil = new Personil();
    Pasangan istri = new Pasangan();
    Anak anak = new Anak();
    Admin admin = new Admin();
    
    //control untuk mengambil seluruh data personil
    public ResultSet getPersonilData(){
        return personil.getAllData();
    }
    public ResultSet getIstriData(String nrp){
        return istri.getDataIstri(nrp);
    }
    public List<String> ambilDataIstrilbyID(String nrp){
        return istri.getIstribyID(nrp);
    }
    public List<String> ambilDataAnaklbyID(String nrp){
        return anak.getAnakbyID(nrp);
    }
    
    //control untuk insert data Personil
    public ResultSet InsertPersonilData(String NRP, String agamaPersonil, String golDarahPersonil, String jabatan, String korps, 
            String namaPersonil, String noASABRI, String noBPJS, String noKTA, String noNPWP, String noTelepon, String pangkat, 
            String penMiliter, String penPengembang, String penUmum, String statusKeluarga, String statusRumah, Date tamatJabatan, 
            Date tamatTNI, Date tglLahirPersonil, String tmptLahirPersonil, Date tmtPangkatPertama, Date tmtPangkatTerakhir, 
            String alamatPersonil) {
        return personil.setPersonilData(NRP, agamaPersonil, golDarahPersonil, jabatan, korps, namaPersonil, noASABRI, noBPJS, 
                noKTA, noNPWP, noTelepon, pangkat, penMiliter, penPengembang, penUmum, statusKeluarga, statusRumah,
                tamatJabatan, tamatTNI, tglLahirPersonil, tmptLahirPersonil, tmtPangkatPertama, tmtPangkatTerakhir,
                alamatPersonil);
    }
    
    //control untuk insert data Pasangan
    public ResultSet InsertIstriData(String NRP, String agamaIstri, String golDarahIstri, String KPIIstri, 
            String KTAJalasenastri, String metodeKb, String penTerakhirIstri, String tmptLahirIstri, String namaIstri,
            Date tglLahirIstri, String hobi1, String hobi2) {
        return istri.setIstriData(NRP, agamaIstri, golDarahIstri, KPIIstri, KTAJalasenastri, metodeKb, penTerakhirIstri, 
                tmptLahirIstri, tglLahirIstri, namaIstri, hobi1, hobi2);
    }
    
    public int EditIstriData(String NRP, String agamaIstri, String golDarahIstri, String KPIIstri, 
            String KTAJalasenastri, String metodeKb, String penTerakhirIstri, String tmptLahirIstri, String namaIstri,
            String tglLahirIstri, String hobi1, String hobi2) {
        return istri.updateDataIstri(NRP, namaIstri, tmptLahirIstri, tglLahirIstri, agamaIstri, golDarahIstri, KPIIstri, 
                KTAJalasenastri, metodeKb, penTerakhirIstri, hobi1, hobi2);
    }
    
    public int EditAnakData(String NRP, String NamaAnak,String IDAnak,String tglLahirAnak, String tmptlahiranak) {
        return anak.updateDataAnak(NRP, NamaAnak,IDAnak,tglLahirAnak,tmptlahiranak);
    }
            
    //control untuk insert data Anak
    public ResultSet InsertAnakData(String NRP, Date tglLahirAnak, String tmptLahirAnak, 
            String namaAnak) {
        return anak.setAnakData(NRP, tglLahirAnak, tmptLahirAnak, namaAnak);
    }
    
    //control untuk login
    public List<String> Login(String username, String password) {
        return admin.Login(username, password);
    }
    
    public Boolean deletePersonil(String nrp){
        return personil.deletePersonil(nrp);
    }
    
    public int updatePersonil(String NRP, String agamaPersonil, String golDarahPersonil, String jabatan, 
            String korps, String namaPersonil, String noASABRI, String noBPJS, String noKTA, String noNPWP, 
            String noTelepon, String pangkat, String penMiliter, String penPengembang, String penUmum, 
            String statusKeluarga, String statusRumah, String tamatJabatan, 
            String tamatTNI, String tglLahirPersonil, String tmptLahirPersonil, 
            String tmtPangkatPertama, String tmtPangkatTerakhir, String alamatPersonil){
        return personil.updatePersonil(NRP, agamaPersonil, golDarahPersonil, jabatan, korps, namaPersonil, noASABRI, noBPJS, noKTA, noNPWP, noTelepon, pangkat, penMiliter, penPengembang, penUmum, statusKeluarga, statusRumah, tamatJabatan, tamatTNI, tglLahirPersonil, tmptLahirPersonil, tmtPangkatPertama, tmtPangkatTerakhir, alamatPersonil);
    }
    
    public Boolean punyaIstri(String nrp){
        System.out.println("masuk master");
        return istri.punyaPasangan(nrp);
    }
    
    public Boolean punyaAnak(String nrp){
        return anak.punyaAnak(nrp);
    }
    
    public ResultSet getAllAnak(String nrp){
        return anak.getAllAnak(nrp);
    }
    
    public List<String> getAnakbyID(String ID){
        return anak.getAnakbyID(ID);
    }
    
    public Boolean deleteAnak(String id){
        return anak.deleteAnak(id);
    }
    
    public Boolean deleteIstri(String nrp){
        return istri.deleteIstri(nrp);
    }
//    // control untuk lihat detail personil yang dipilih
//    public ResultSet getPersonilData(String NRP) {
//        return personil.getPersonilbyID(NRP);
//    }

}