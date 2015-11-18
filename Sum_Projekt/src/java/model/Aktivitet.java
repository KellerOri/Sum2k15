/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.primefaces.model.DefaultScheduleEvent;

/**
 *
 * @author Andromeda
 */
public class Aktivitet{
    private DefaultScheduleEvent event;
    private Set<PersonResource> personresourcer;

    public Aktivitet(Set<PersonResource> personresourcer) {
        this.personresourcer = personresourcer;
        this.event = new DefaultScheduleEvent();
    }
    
    public void addRessource(PersonResource pr){
        personresourcer.add(pr);
    }
    public List<PersonResource> getPersonResourcer(){
        return new ArrayList<PersonResource>(personresourcer);
    }
    
    public void setStartdato(Date start){
        event.setStartDate(start);
    }
    public void setSlutdato(Date slut){
        event.setEndDate(slut);
        
    }
   
}
