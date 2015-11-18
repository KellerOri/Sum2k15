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

    private DefaultScheduleEvent event;
    private Set<PersonResource> personresourcer;
    private LocalDateTime start;
    private LocalDateTime slut;

    public Aktivitet() {
        personresourcer = new HashSet<PersonResource>();
        this.event = new DefaultScheduleEvent();
    }
    
    public Aktivitet(DefaultScheduleEvent dse){
        this();
        this.event = dse;
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
        event.setStartDate(localDateTimetoDate(start));
    }

    public void setSlutdato(LocalDateTime slut) {
        this.slut = slut;
        event.setEndDate(localDateTimetoDate(slut));
    }

    public LocalDateTime dateToLocalDate(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return res;
    }
    public Date localDateTimetoDate(LocalDateTime ldt){
        Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
        Date res = Date.from(instant);
        return res;
    }
    
    public String toString(){
        String res = start + ", " + slut;
        return res;
    }
}
