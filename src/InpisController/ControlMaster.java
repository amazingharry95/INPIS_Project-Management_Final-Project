/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InpisController;

import InpisModel.*;
import java.util.Date;
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
    
//    // control untuk lihat detail personil yang dipilih
//    public ResultSet getPersonilData(String NRP) {
//        return personil.getPersonilbyID(NRP);
//    }

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
}