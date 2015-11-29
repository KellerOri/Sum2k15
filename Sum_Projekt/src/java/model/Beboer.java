/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andromeda
 */
public class Beboer implements PersonResource, Serializable{
    
    private String navn;
    private String noter;
    private List<Aktivitet> aktiviteter;
    
    public Beboer() {    
        aktiviteter = new ArrayList<Aktivitet>();
    }

    public Beboer(String navn) {
        this();
        this.navn = navn;
    }
    
    @Override
    public Aktivitet addAktivitet(Aktivitet a){
        aktiviteter.add(a);
        return a;
    }

    @Override
    public List<Aktivitet> getAktiviteter() {
        return new ArrayList<Aktivitet>(aktiviteter);
    }
    
    
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    } 
    
    public String getNoter() {
        return noter;
    }

    public void setNoter(String noter) {
        this.noter = noter;
    }
    
    @Override
    public String toString(){
        return navn + ", " + aktiviteter.size();
    }
    
}
