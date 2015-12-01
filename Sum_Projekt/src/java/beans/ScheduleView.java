/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.awt.Image;
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

    private DefaultScheduleEvent event;

    private List<String> selectedMedarbejdere;
    private List<String> selectedBeboere;
    private List<String> selectedResourcer;

    private List<String> opretaktivitetbeboere = new ArrayList<>();
    private List<String> opretaktivitetmedarbejdere = new ArrayList<>();
    private List<String> opretaktivitetressource = new ArrayList<>();
    private List<String> personeriaktivitet = new ArrayList<>();

    @PostConstruct
    public void init() {
        event = new DefaultScheduleEvent();
        eventModel = new MyScheduleModel(service);
        loadEvents();
    }

    public List<String> getSelectedMedarbejdere() {
        return selectedMedarbejdere;
    }

    public void setSelectedMedarbejdere(List<String> selectedMedarbejdere) {
        this.selectedMedarbejdere = selectedMedarbejdere;

    }

    public List<String> getSelectedBeboere() {
        return selectedBeboere;
    }

    public void setSelectedBeboere(List<String> selectedBeboere) {
        this.selectedBeboere = selectedBeboere;
    }

    public List<String> getSelectedResourcer() {
        return selectedResourcer;
    }

    public void setSelectedResourcer(List<String> selectedResourcer) {
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

    public DefaultScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(DefaultScheduleEvent event) {
        this.event = event;
    }

    public String addEvent(ActionEvent actionEvent) {
        List<String> prString = new ArrayList<String>();
        prString.addAll(opretaktivitetbeboere);
        prString.addAll(opretaktivitetmedarbejdere);
        prString.addAll(opretaktivitetressource);
        List<PersonResource> prNonString = service.getPersonResourcerMedId(prString);
        System.out.println("prs size " + prString.size());
        System.out.println(Arrays.toString(prString.toArray()));
//        if (event.getId() == null) {
            Aktivitet a = service.createAktivitet(event.getTitle(), event.getDescription(), event.getStartDate(), event.getEndDate(), prNonString);
            event.setData(a);
            eventModel.addEvent(event);
//        } else {
            eventModel.updateEvent(event);

//        }
        event = new DefaultScheduleEvent();

//        if(model !contains event)
        return "schedule.xhtml";
    }

    public void deleteEvent(ActionEvent actionEvent) {
        if (event.getId() != null) {
            eventModel.deleteEvent(event);
            service.sletAktivitet((Aktivitet) event.getData());
        }
    }
//    public void addEvent(ActionEvent actionEvent) {
////        if(model !contains event)
//        String title = event.getTitle();
//        String note = event.getDescription();
//        Date start = event.getStartDate();
//        Date slut = event.getEndDate();
//
////        Aktivitet a = (Aktivitet) event.getData();
//        String sted = "Ayy Lmao";
//        int interval = 99;
//
//        service.createAktivitet(title, note, interval, sted, start, slut);
//        eventModel.addEvent(event);
//        event = new DefaultScheduleEvent();
//        loadEvents();
//    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (DefaultScheduleEvent) selectEvent.getObject();
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
            DefaultScheduleEvent temp = new DefaultScheduleEvent(a.toString(), service.localDateTimetoDate(a.getStart()), service.localDateTimetoDate(a.getSlut()), a);
            if (a.hasBil()) {
                temp.setStyleClass("bilEvent");
            }
            eventModel.addEvent(temp);
        }

    }

    public void test() {
        System.out.println("Test() eventcount: " + eventModel.getEventCount());
        System.out.println("m: " + Arrays.toString(selectedMedarbejdere.toArray()));
        System.out.println("b: " + Arrays.toString(selectedBeboere.toArray()));

        applyFilter();
        System.out.println("Test() eventcount: " + eventModel.getEventCount());
    }

    public void applyFilter() {
        System.out.println("scheduleView.applyFilter()");
        ArrayList<String> list = new ArrayList<>();
        list.addAll(selectedMedarbejdere);
        list.addAll(selectedBeboere);
        list.addAll(selectedResourcer);
        System.out.println("ScheduleVies applyFilter() list: " + list.toString());
        eventModel.applyFilters(service.getPersonResourcerMedId(list));
    }

    public List<Beboer> getOpretaktivitetbeboere() {
        return new ArrayList(opretaktivitetbeboere);
    }

    public void setOpretaktivitetbeboere(List<String> opretaktivitetbeboere) {
        this.opretaktivitetbeboere = opretaktivitetbeboere;
    }

    public List<Medarbejder> getOpretaktivitetmedarbejdere() {
        return new ArrayList(opretaktivitetmedarbejdere);
    }

    public void setOpretaktivitetmedarbejdere(List<String> opretaktivitetmedarbejdere) {
        this.opretaktivitetmedarbejdere = opretaktivitetmedarbejdere;
    }

    public List<Resource> getOpretaktivitetressource() {
        return new ArrayList(opretaktivitetressource);
    }

    public void setOpretaktivitetressource(List<String> opretaktivitetressource) {
        this.opretaktivitetressource = opretaktivitetressource;
    }

    public List<String> getPersoneriaktivitet() {
        return new ArrayList(personeriaktivitet);
    }

    public void setPersoneriaktivitet(List<String> personeriaktivitet) {
        this.personeriaktivitet = personeriaktivitet;
    }

    public List allepersoneriaktivitet() {
        List<String> combined = new ArrayList<>();
        combined.addAll(opretaktivitetbeboere);
        combined.addAll(opretaktivitetmedarbejdere);
        combined.addAll(opretaktivitetressource);
        return combined;
    }
}
