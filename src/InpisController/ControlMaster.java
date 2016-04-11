/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InpisController;

import InpisModel.*;
import java.sql.ResultSet;

/**
 *
 * @author amazingharry95
 */
public class ControlMaster {
    Personil personil = new Personil();
    
    public ResultSet getPersonilData(){
        return personil.getAllData();
    }
}
