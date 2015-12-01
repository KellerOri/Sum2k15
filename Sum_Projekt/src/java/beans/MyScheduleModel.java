/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import model.Aktivitet;
import model.PersonResource;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import service.Service;

/**
 *
 * @author Arthur
 */
public class MyScheduleModel extends DefaultScheduleModel{
    //extends LasyScheduleModel istedet -> implementer loadEvents(start, slut)
    Set<PersonResource> filters = new HashSet<PersonResource>();
    Set<Aktivitet> aktiviteter = new HashSet<Aktivitet>();
    Service service;

    public MyScheduleModel(Service service) {
        this.service = service;
    }
    
    public void addFilter(PersonResource filter){
        filters.add(filter);
        updateAllEvents();
    }
    
    public void deleteFilter(PersonResource filter){
        filters.remove(filter);
        updateAllEvents();
    }
    
    public void applyFilters(List<PersonResource> fs){
        filters.clear();
        filters.addAll(fs);
        updateAllEvents();
    }
    /**
     * Clearer eventmodel for aktiviteter, løber alle personresourcer igennem og matcher deres aktiviteter.
     *  O(n^2) + O(n)
     * ...Burde kunne laves bedre...
     * 
     */
    private void updateAllEvents(){
        System.out.println("myScheduleModel.updateAllEvents()");
        System.out.println(getEventCount());
        clear();
        System.out.println(getEventCount());
        System.out.println("filters: " + Arrays.toString(filters.toArray()));
//        for(PersonResource pr : filters){
//            for(Aktivitet a : pr.getAktiviteter()){
//                aktiviteter.add(a);
//            } FEEEJLL!!!
//        }
//        for(Aktivitet a : aktiviteter){
//            addEvent(a);
//        }
    }
    private void updateAddEvents(PersonResource pr){
        
    }
    private void updateDeleteEvents(PersonResource pr){
        
    }
    /**
     * Adder aktivitet til eventmodel som en DefaultScheduleEvent
     * @param a 
     */
    public void addEvent(Aktivitet a){
        addEvent(new DefaultScheduleEvent(a.toString(), 
                        Service.localDateTimetoDate(a.getStart()), Service.localDateTimetoDate(a.getSlut()), a));
    }
    
    public void test(){
        System.out.println("Testing myschedulemodel");
        loadEvents(Service.localDateTimetoDate(LocalDateTime.now()), Service.localDateTimetoDate(LocalDateTime.now().plusDays(1)));
    }
    /**
     * Skal tage højde for filtre og MyScheduleModel kan extende lazyScheduleModel istedet
     * @param start
     * @param end 
     */
    public void loadEvents(Date start, Date end){
        LocalDate ldStart = Service.dateToLocalDate(start).toLocalDate();
        LocalDate ldEnd = Service.dateToLocalDate(end).toLocalDate();
        while(ldStart.isBefore(ldEnd)){
            for (Aktivitet a : service.getAktiviterPaaDag(ldStart)) {
                if(aktiviteter.contains(a)){
                    addEvent(a);
                }
            }
            ldStart = ldStart.plusDays(1);
        }
    }
}
