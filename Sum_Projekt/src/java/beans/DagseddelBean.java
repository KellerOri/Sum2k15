/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.time.LocalDate;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Pawesome
 */
@Named
@SessionScoped
public class DagseddelBean implements Serializable {
    
    private LocalDate aktuelDag;

    public String getAktuelDag() {
        if(aktuelDag == null){
            aktuelDag = LocalDate.now();
        }
        return aktuelDag.toString();
    }
    

    public void setAktuelDag(LocalDate aktuelDag) {
        this.aktuelDag = aktuelDag;
    }
    
    
    
    
    
}
