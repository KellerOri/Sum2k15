/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import service.Service;

/**
 *
 * @author Andromeda
 */

public class Medarbejder implements PersonResource, Serializable{

    private String navn;
    private List<Aktivitet> aktiviteter;
    private String id;
    public Medarbejder() {
        aktiviteter = new ArrayList<Aktivitet>();
        this.id = "m" + Service.getnewId();
    }

    public Medarbejder(String navn) {
        this();
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    
    public String getType(){
        return "Medarbejder";
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
    
 
    @Override
    public String toString(){
        return id + " " + navn + " " + aktiviteter.size();
    }

    @Override
    public String getId() {
        return id;
    }
}
