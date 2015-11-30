/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.javafx.scene.control.SelectedCellsMap;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import model.Aktivitet;
import model.Beboer;
import model.PersonResource;

import java.util.ArrayList;
import model.Medarbejder;
import model.PersonResource;

import model.Resource;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import service.Service;

@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {

    @Inject
    Service service;
    private MyScheduleModel eventModel;
    private ScheduleModel lazyEventModel;
    
    private ScheduleEvent event;
    
    private List<Medarbejder> selectedMedarbejdere;
    private List<Beboer> selectedBeboere;
    private List<Resource> selectedResourcer;

    private List<Beboer> opretaktivitetbeboere = new ArrayList<>();
    private List<Medarbejder> opretaktivitetmedarbejdere = new ArrayList<>();
    private List<Resource> opretaktivitetressource = new ArrayList<>();
    private List<String> personeriaktivitet = new ArrayList<>();

    @PostConstruct
    public void init() {
        event = new DefaultScheduleEvent();
        eventModel = new MyScheduleModel(service);  
        loadEvents();
    }

    public List<Medarbejder> getSelectedMedarbejdere() {
        return selectedMedarbejdere;
    }

    public void setSelectedMedarbejdere(List<Medarbejder> selectedMedarbejdere) {
        
        this.selectedMedarbejdere = selectedMedarbejdere;
 
    }

    public List<Beboer> getSelectedBeboere() {
        return selectedBeboere;
    }

    public void setSelectedBeboere(List<Beboer> selectedBeboere) {
        this.selectedBeboere = selectedBeboere;
    }

    public List<Resource> getSelectedResourcer() {
        return selectedResourcer;
    }

    public void setSelectedResourcer(List<Resource> selectedResourcer) {
        this.selectedResourcer = selectedResourcer;
    }

    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1);    //set random day of month

        return date.getTime();
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

//    public void addEvent(ActionEvent actionEvent) {
//        if(event.getId() == null)
//            eventModel.addEvent(event);
//        else
//            eventModel.updateEvent(event);
//         
//        event = new DefaultScheduleEvent();
//    }
    public void addEvent(ActionEvent actionEvent) {
//        if(model !contains event)
        String title = event.getTitle();
        String note = event.getDescription();
        Date start = event.getStartDate();
        Date slut = event.getEndDate();

        
        Aktivitet a = (Aktivitet) event.getData();
        String sted = a.getSted();
        int interval = a.getInterval();
        

    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
//    private void hasBil(){     
//        for (ScheduleEvent event : eventModel.getEvents()){
//            event.getData()          
//            
//        }
//    }


    private void loadEvents() {
        eventModel.clear();
        List<Aktivitet> aktiviteter = service.getAktiviteter();
        for (Aktivitet a : aktiviteter) {

            eventModel.addEvent(new DefaultScheduleEvent(a.toString(),
                    Service.localDateTimetoDate(a.getStart()), Service.localDateTimetoDate(a.getSlut()), a));

//            eventModel.addEvent(new DefaultScheduleEvent("Champions League Match", previousDay8Pm(), previousDay11Pm()));

            eventModel.addEvent(new DefaultScheduleEvent(a.toString(), 
                    service.localDateTimetoDate(a.getStart()), service.localDateTimetoDate(a.getSlut()), a));


            eventModel.addEvent(new DefaultScheduleEvent(a.toString(),
                    service.localDateTimetoDate(a.getStart()), service.localDateTimetoDate(a.getSlut()),a));


        }

    }

    
    public void test(){
        System.out.println("Test() eventcount: " + eventModel.getEventCount());
        System.out.println("m: " + Arrays.toString(selectedMedarbejdere.toArray()));
        System.out.println("b: " + Arrays.toString(selectedBeboere.toArray()));
        applyFilter();
        System.out.println("Test() eventcount: " + eventModel.getEventCount());
    }
 
    public void applyFilter(){
        System.out.println("scheduleView.applyFilter()");
        ArrayList<PersonResource> list = new ArrayList<>();
        System.out.println("list.addAll(ms)");
        list.addAll(selectedMedarbejdere);
        System.out.println("list.addAll(bs)");
        list.addAll(selectedBeboere);
        System.out.println("list.addAll(rs)");
        list.addAll(selectedResourcer);
        System.out.println("list: " + list.toString());
        eventModel.applyFilters(list);
    }
	

    public List<Beboer> getOpretaktivitetbeboere() {
        return new ArrayList(opretaktivitetbeboere);
    }

    public void setOpretaktivitetbeboere(List<Beboer> opretaktivitetbeboere) {
        this.opretaktivitetbeboere = opretaktivitetbeboere;
    }

    public List<Medarbejder> getOpretaktivitetmedarbejdere() {
        return new ArrayList(opretaktivitetmedarbejdere);
    }

    public void setOpretaktivitetmedarbejdere(List<Medarbejder> opretaktivitetmedarbejdere) {
        this.opretaktivitetmedarbejdere = opretaktivitetmedarbejdere;
    }

    public List<Resource> getOpretaktivitetressource() {
        return new ArrayList(opretaktivitetressource);
    }

    public void setOpretaktivitetressource(List<Resource> opretaktivitetressource) {
        this.opretaktivitetressource = opretaktivitetressource;
    }

    public List<String> getPersoneriaktivitet() {
        return new ArrayList(personeriaktivitet);
    }

    public void setPersoneriaktivitet(List<String> personeriaktivitet) {
        this.personeriaktivitet = personeriaktivitet;
    }

    public List allepersoneriaktivitet() {
        List<PersonResource> combined = new ArrayList<>();
        combined.addAll(opretaktivitetbeboere);
        combined.addAll(opretaktivitetmedarbejdere);
        combined.addAll(opretaktivitetressource);
        return combined;
    }
}
