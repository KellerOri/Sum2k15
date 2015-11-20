/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.primefaces.model.DefaultScheduleEvent;

/**
 *
 * @author Andromeda
 */
public class Aktivitet {

    private Set<PersonResource> personresourcer;
    private LocalDateTime start;
    private LocalDateTime slut;
    private String beskrivelse;
    private String titel;
    
    public Aktivitet() {
        personresourcer = new HashSet<PersonResource>();
    }
    
    public Aktivitet(Set<PersonResource> personresourcer) {
        this();
        this.personresourcer = personresourcer;
    }

    public void addRessource(PersonResource pr) {
        personresourcer.add(pr);
    }

    public List<PersonResource> getPersonResourcer() {
        return new ArrayList<PersonResource>(personresourcer);
    }

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

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
  
    public String toString(){
        String res = start + ", " + slut;
        return res;
    }
}
