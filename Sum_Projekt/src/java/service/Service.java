/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private final Storage storage;
    
    public Service(){
        storage = Storage.getInstance();    
        initStorage();
    }
    
    public List<Aktivitet> getAktiviteter(){
        return storage.getAktiviteter();
    }
    
    public void addAktivitet(DefaultScheduleEvent event){
        Aktivitet a = new Aktivitet(event);
        storage.addAktivitet(a);
    }
    
    public void addAktivitet(Aktivitet aktivitet){
        storage.addAktivitet(aktivitet);
    }
    
    public Beboer addBeboer(String navn){
        Beboer b = new Beboer();
        b.setNavn(navn);
        storage.addBeboer(b);
        return b;
    }
    
    public List<Beboer> getBeboere(){
        return storage.getBeboere();
    }
    
    public List<Medarbejder> getMedarbejdere(){
        return storage.getMedarbejdere();
    }
    
    public Medarbejder addMedarbejder(String navn){
        Medarbejder m = new Medarbejder();
        m.setNavn(navn);
        storage.addMedarbejder(m);
        return m;
    }
    public List<Resource> getResourcer(){
        return storage.getResourcer();
    }
    
    public List<PersonResource> getPersonResourcer(){
        return storage.getPersonResourcer();
    }
    
    public List<Aktivitet> getAktiviterPaaDag(LocalDate ldt){
        return storage.getAktiviteterPaaDag(ldt);
    }
            
    private void initStorage(){
        Beboer b1 = addBeboer("Alice");
        Beboer b2 = addBeboer("Bob");
        
        Medarbejder m1 = addMedarbejder("Anette");
        Medarbejder m2 = addMedarbejder("Louise");
        
        Aktivitet a1 = new Aktivitet();
        a1.addRessource(b1);
        a1.addRessource(m1);
        a1.setStartdato(LocalDateTime.now());
        a1.setSlutdato(LocalDateTime.now().plusHours(4));
        addAktivitet(a1);
        
        Aktivitet a2 = new Aktivitet();
        a2.addRessource(b2);
        a2.addRessource(m2);
        a2.setStartdato(LocalDateTime.now().plusHours(2));
        a2.setSlutdato(LocalDateTime.now().plusHours(4));
    }
}
