/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import service.Service;

/**
 *
 * @author Andromeda
 */
public class Resource implements PersonResource{

    private ArrayList<Aktivitet> aktiviteter;
    private String id;
    private String navn;
    public Resource() {
        aktiviteter = new ArrayList<>();
        id="r" + Service.getnewId();
        navn = "random";
    }
    
    @Override
    public Aktivitet addAktivitet(Aktivitet a) {
        aktiviteter.add(a);
        return a;
    }

    @Override
    public List<Aktivitet> getAktiviteter() {
        return new ArrayList<Aktivitet>(aktiviteter);
    }
   
    private boolean bil;
    private boolean mødelokale;
    
    public boolean isBil() {
        return bil;
    }

    public void setBil(boolean bil) {
        this.bil = bil;
    }

    public boolean isMødelokale() {
        return mødelokale;
    }

    public void setMødelokale(boolean mødelokale) {
        this.mødelokale = mødelokale;
    }
    
    @Override
   public String toString(){
       if (isBil()){
           return "Bil";
       } else if (isMødelokale()){
           return "Mødelokale";
       } else{
           return "Ingen Resource";
       }
   } 

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNavn() {
        return navn;
    }
}
