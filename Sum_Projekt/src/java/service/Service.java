/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.*;
import org.primefaces.model.DefaultScheduleEvent;
import storage.Storage;

@Named
@SessionScoped
public class Service implements Serializable {

    private final Storage storage;
    private static int idcounter;
    public Service() {
        storage = Storage.getInstance();
        idcounter = 0;
    }

    public List<Aktivitet> getAktiviteter() {
        return storage.getAktiviteter();
    }

    public void addAktivitet(Aktivitet aktivitet) {
        storage.addAktivitet(aktivitet);
    }
    
    public static int getnewId(){
        return idcounter++;
    }
    
    public Aktivitet createAktivitet(String title, String note, int interval, String sted, Date start, Date slut){
        Aktivitet a = new Aktivitet();
        a.setTitel(title);
        a.setNote(note);
        a.setStartdato(dateToLocalDate(start));
        a.setSlutdato(dateToLocalDate(slut));
        a.setInterval(interval);
        a.setSted(sted);
        addAktivitet(a);
        return a;
    }
    
    public Aktivitet createAktivitet(String title, String beskrivelse, Date start, Date slut, List<PersonResource> resourcer){
        Aktivitet a = new Aktivitet();
        a.setTitel(title);
        a.setNote(beskrivelse);
        a.setStartdato(dateToLocalDate(start));
        a.setSlutdato(dateToLocalDate(slut));
        
        for(PersonResource pr : resourcer){
            pr.addAktivitet(a);
            a.addPersonRessource(pr);
        }
        addAktivitet(a);
        return a;
    }
    
    public Beboer addBeboer(String navn) {
        Beboer b = new Beboer();
        b.setNavn(navn);
        storage.addBeboer(b);
        return b;
    }

    public List<Beboer> getBeboere() {
        return storage.getBeboere();
    }

    public List<Medarbejder> getMedarbejdere() {
        return storage.getMedarbejdere();
    }

    public Medarbejder addMedarbejder(String navn) {
        Medarbejder m = new Medarbejder();
        m.setNavn(navn);
        storage.addMedarbejder(m);
        return m;
    }

    public List<Resource> getResourcer() {
        return storage.getResourcer();
    }

    public List<PersonResource> getPersonResourcer() {
        return storage.getPersonResourcer();
    }

    public List<Aktivitet> getAktiviterPaaDag(LocalDate ldt) {
        return storage.getAktiviteterPaaDag(ldt);
    }

    public static final LocalDateTime dateToLocalDate(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return res;
    }

    public static final Date localDateTimetoDate(LocalDateTime ldt) {
        Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
        Date res = Date.from(instant);
        return res;
    }
    

    public Note addNote(Beboer beboer, LocalDate dag, String indhold) {
        Note n = new Note(beboer, dag, indhold);
        storage.addNote(n);
        return n;
    }

    public String getNoteBeboerDag(Beboer beboer, Date dag) {

        String toReturn = "Nothing!";
        List<Note> ner = storage.getNoter();

        for (Note n : ner) {
            LocalDateTime d = dateToLocalDate(dag);
            LocalDate datedag = LocalDate.of(d.getYear(), d.getMonth(), d.getDayOfMonth());
            if (n.getBeboer().equals(beboer) && datedag.equals(n.getDag())) {
                toReturn = n.getIndhold();
            }

        }
        return toReturn;
    }

    // midlertidig løsning
    public String getToday() {
        return LocalDate.now().toString();
    }
}
