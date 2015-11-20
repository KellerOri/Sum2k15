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
import service.Service;

/**
 *
 * @author Pawesome
 */
@Named
@SessionScoped
public class DagseddelBean implements Serializable {
    
    private Date aktuelDag;
    private Service service;
    
    
    public DagseddelBean(){
        service = new Service();
        aktuelDag = service.localDateTimetoDate(LocalDateTime.now());
    }

    public Date getAktuelDag() {
        return aktuelDag;
    }
    

    public void setAktuelDag(Date aktuelDag) {
        this.aktuelDag = aktuelDag;
    }
    
    
    
    
    
}
