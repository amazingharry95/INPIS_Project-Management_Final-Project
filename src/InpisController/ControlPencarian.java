/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InpisController;

import InpisModel.*;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author amazingharry95
 */
public class ControlPencarian {
    Personil personil = new Personil();
    
    public ResultSet ambilDataPersonil(String filter, String keyword) {
        return personil.cariPersonilByKeyword(filter, keyword);
    }
    
    public List<String> ambilDataPersonilbyID(String nrp){
        return personil.getPersonilbyID(nrp);
    }
}
