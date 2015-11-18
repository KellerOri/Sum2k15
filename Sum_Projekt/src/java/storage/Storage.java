/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.util.ArrayList;
import java.util.List;
import model.Aktivitet;
import model.Beboer;
import model.Medarbejder;
import model.PersonResource;
import model.Resource;

public class Storage {
    private List<Beboer> beboere;
    private List<Aktivitet> aktiviteter;
    private List<Medarbejder> medarbejdere;
    private List<Resource> resourcer;
    private static Storage instance;
    
    private Storage(){
        
    }
    
    public static Storage getInstance(){
        if (instance == null){
            instance = new Storage();
        }
        return instance;
    }

    public List<Beboer> getBeboere() {
        return new ArrayList<>(beboere);
    }

    public void setBeboerer(List<Beboer> beboerer) {
        this.beboere = beboerer;
    }

    public void addBeboer(Beboer beboer){
        beboere.add(beboer);
    }
    public List<Aktivitet> getAktiviteter() {
        return new ArrayList<>(aktiviteter);
    }

    public void setAktiviteter(List<Aktivitet> aktiviteter) {
        this.aktiviteter = aktiviteter;
    }

    public List<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public void setMedarbejdere(List<Medarbejder> medarbejdere) {
        this.medarbejdere = medarbejdere;
    }

    public void addMedarbejder(Medarbejder m){
        medarbejdere.add(m);
    }
    public List<Resource> getResourcer() {
        return new ArrayList<>(resourcer);
    }

    public void setRessourcer(List<Resource> ressourcer) {
        this.resourcer = ressourcer;
    }
    
   public List<PersonResource> getPersonResourcer(){
       List<PersonResource> temp = new ArrayList<PersonResource>();
       temp.addAll(getMedarbejdere());
       temp.addAll(getBeboere());
       temp.addAll(getResourcer());
       return temp;
   } 

}
