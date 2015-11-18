/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Aktivitet;
import model.Beboer;
import model.Medarbejder;
import model.PersonResource;
import model.Resource;
import org.primefaces.model.DefaultScheduleEvent;
import storage.Storage;

@Named
@SessionScoped
public class Service implements Serializable{
    private Storage storage;
    
    public Service(){
        storage = Storage.getInstance();    
    }
    
    public List<Aktivitet> getAktiviteter(){
        return storage.getAktiviteter();
    }
    
    public void addAktivitet(DefaultScheduleEvent event){
    }
    
    public List<Beboer> getBeboere(){
        return storage.getBeboere();
    }
    
    public List<Medarbejder> getMedarbejdere(){
        return storage.getMedarbejdere();
    }
    
    public List<Resource> getResourcer(){
        return storage.getResourcer();
    }
    
    public List<PersonResource> getPersonResourcer(){
        return storage.getPersonResourcer();
    }
}
