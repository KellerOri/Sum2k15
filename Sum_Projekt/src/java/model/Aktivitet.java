/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Andromeda
 */
public class Aktivitet implements Serializable{

    private Set<PersonResource> personresourcer;
    private LocalDateTime start;
    private LocalDateTime slut;
    private String note;
    private String titel;
    private String sted;
    private int interval;
   
    public Aktivitet() {
        personresourcer = new HashSet<PersonResource>();
    }
    
    public Aktivitet(Set<PersonResource> personresourcer) {
        this();
        this.personresourcer = personresourcer;
    }

    public void addPersonRessource(PersonResource pr) {
        personresourcer.add(pr);
    }

//    public List<PersonResource> getPersonResourcer() {
//        return new ArrayList<PersonResource>(personresourcer);
//    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getSlut() {
        return slut;
    }
    
    public void setStartdato(LocalDateTime start) {
        this.start = start;
    }

    public void setSlutdato(LocalDateTime slut) {
        this.slut = slut;
    }

    public Set<PersonResource> getPersonresourcer() {
        return personresourcer;
    }

    public void setPersonresourcer(Set<PersonResource> personresourcer) {
        this.personresourcer = personresourcer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
  
    @Override
    public String toString(){
        return titel + ": " + note;
    }
    public void addPersonResourcer(List l) {
        for (int i = 0; i < l.size(); i++) {
            personresourcer.add((PersonResource)l.get(i));
        }
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }


    public boolean hasBil(){
        return findResource().isBil();
    }
    
    public boolean hasMødelokale(){
        return findResource().isMødelokale();  
    }

    private Resource findResource(){
        Resource temp = new Resource();
        for (PersonResource pr : personresourcer){
            if (pr.getClass() == Resource.class){
                temp = (Resource) pr;
            }
        }
        return temp;
    }
}
