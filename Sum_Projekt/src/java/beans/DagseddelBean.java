/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Pawesome
 */
@Named
@SessionScoped
public class DagseddelBean implements Serializable {
    
    private Date aktuelDag;
    
    public Date localDatetoDate(LocalDateTime ldt){
        Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
        Date res = Date.from(instant);
        return res;
    }
    
    public DagseddelBean(){
        aktuelDag = localDatetoDate(LocalDateTime.now());
    }

    public Date getAktuelDag() {
        return aktuelDag;
    }
    

    public void setAktuelDag(Date aktuelDag) {
        this.aktuelDag = aktuelDag;
    }
    
    
    
    
    
}
