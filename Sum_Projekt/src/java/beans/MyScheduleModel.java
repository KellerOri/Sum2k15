/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Aktivitet;
import model.PersonResource;
import org.primefaces.model.LazyScheduleModel;

/**
 *
 * @author Arthur
 */
public class MyScheduleModel extends LazyScheduleModel{
    
    List<PersonResource> filters = new ArrayList<PersonResource>();
    Set<Aktivitet> events = new HashSet<Aktivitet>();
    
    public void addFilter(PersonResource filter){
        filters.add(filter);
        updateEvents();
    }
    
    public void deleteFilter(PersonResource filter){
        filters.remove(filter);
        updateEvents();
    }
    
    private void updateEvents(){
        clear();
        
    }
    
}
