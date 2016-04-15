/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InpisController;

import java.sql.*;
import InpisModel.*;
import java.sql.ResultSet;
/**
 *
 * @author amazingharry95
 */
public class ControlMaster {
    Personil personil = new Personil();
    
    //control untuk mengambil seluruh data personil
    public ResultSet getPersonilData(){
        return personil.getAllData();
    }
    
    // control untuk lihat detail personil yang dipilih
    public ResultSet getPersonilData(String NRP) {
        return personil.getPersonilbyID(NRP);
    }
    
    public ResultSet InsertPersonilData(String NRP, String agamaPersonil, String golDarahPersonil, String jabatan, 
            String korps, String namaPersonil, String noASABRI, String noBPJS, String noKTA, String noNPWP, 
            String noTelepon, String pangkat, String penMiliter, String penPengembang, String penUmum, 
            String statusKeluarga, String statusRumah, Date tamatJabatan, Date tamatTNI, Date tglLahirPersonil, 
            String tmptLahirPersonil, Date tmtPangkatPertama, Date tmtPangkatTerakhir, String alamatPersonil) 
    {
        return personil.setPersonilData(NRP, agamaPersonil, golDarahPersonil, jabatan, korps, namaPersonil, noASABRI, noBPJS, 
                noKTA, noNPWP, noTelepon, pangkat, penMiliter, penPengembang, penUmum, statusKeluarga, statusRumah,
                tamatJabatan, tamatTNI, tglLahirPersonil, tmptLahirPersonil, tmtPangkatPertama, tmtPangkatTerakhir,
                alamatPersonil);
    }

    public void InsertPersonilData(String NRP, String agamaPersonil, String golDarahPersonil, String jabatan, String korps, String namaPersonil, String noASABRI, String noBPJS, String noKTA, String noNPWP, String noTelepon, String pangkat, String penMiliter, String penPengembang, String penUmum, String statusKeluarga, String statusRumah, java.util.Date tamatJabatan, java.util.Date tamatTNI, java.util.Date tglLahirPersonil, String tmptLahirPersonil, java.util.Date tmtPangkatPertama, java.util.Date tmtPangkatTerakhir, String alamatPersonil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}