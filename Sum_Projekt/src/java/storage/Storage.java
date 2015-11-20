/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.Aktivitet;
import model.Beboer;
import model.Medarbejder;
import model.Note;
import model.PersonResource;
import model.Resource;

public class Storage {

    private List<Beboer> beboere;
    private List<Aktivitet> aktiviteter;
    private List<Medarbejder> medarbejdere;
    private List<Resource> resourcer;
    private List<Note> noter;
    private static Storage instance;

    private Storage() {
        beboere = new ArrayList<Beboer>();
        aktiviteter = new ArrayList<Aktivitet>();
        medarbejdere = new ArrayList<Medarbejder>();
        resourcer = new ArrayList<Resource>();
        noter = new ArrayList<Note>();
        initStorage();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public List<Beboer> getBeboere() {
        return new ArrayList<>(beboere);
    }

    public void setBeboerer(List<Beboer> beboerer) {
        this.beboere = beboerer;
    }

    public Beboer addBeboer(Beboer beboer) {
        beboere.add(beboer);
        return beboer;
    }

    public List<Aktivitet> getAktiviteter() {
        return new ArrayList<>(aktiviteter);
    }

    public void setAktiviteter(List<Aktivitet> aktiviteter) {
        this.aktiviteter = aktiviteter;
    }

    public Aktivitet addAktivitet(Aktivitet aktivitet) {
        aktiviteter.add(aktivitet);
        return aktivitet;
    }

    public List<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public void setMedarbejdere(List<Medarbejder> medarbejdere) {
        this.medarbejdere = medarbejdere;
    }

    public Medarbejder addMedarbejder(Medarbejder m) {
        medarbejdere.add(m);
        return m;
    }

    public List<Resource> getResourcer() {
        return new ArrayList<>(resourcer);
    }

    public void setRessourcer(List<Resource> ressourcer) {
        this.resourcer = ressourcer;
    }

    public void addNote(Note n) {
        noter.add(n);
    }
    
    public List<Note> getNoter(){
        return new ArrayList<>(noter);
    }

    public List<Aktivitet> getAktiviteterPaaDag(LocalDate ldt) {
        List<Aktivitet> result = new ArrayList<Aktivitet>();
        System.out.println("Storage " + aktiviteter.size());
        for (Aktivitet a : aktiviteter) {
            System.out.println(a);
            if (a.getStart() != null && a.getStart().toLocalDate().equals(ldt)) {
                result.add(a);
            }
        }
        return result;
    }

    public List<PersonResource> getPersonResourcer() {
        List<PersonResource> temp = new ArrayList<PersonResource>();
        temp.addAll(getMedarbejdere());
        temp.addAll(getBeboere());
        temp.addAll(getResourcer());
        return temp;
    }
    
    private void initStorage() {
        System.out.println("init()");
        
        Beboer b1 = addBeboer(new Beboer("Alice"));
        Beboer b2 = addBeboer(new Beboer("Bob"));

        Medarbejder m1 = addMedarbejder(new Medarbejder("Anette"));
        Medarbejder m2 = addMedarbejder(new Medarbejder("Louise"));

        Aktivitet a1 = new Aktivitet();
        a1.addPersonRessource(b1);
        a1.addPersonRessource(m1);
        a1.setStartdato(LocalDateTime.now());
        a1.setSlutdato(LocalDateTime.now().plusHours(4));
        a1.setTitel("Bjerge");
        a1.setBeskrivelse("Jaer. Og gud sagde Moses Moses!");
        addAktivitet(a1);

        Aktivitet a2 = new Aktivitet();
        a2.addPersonRessource(b2);
        a2.addPersonRessource(m2);
        a2.setStartdato(LocalDateTime.now().plusHours(2));
        a2.setSlutdato(LocalDateTime.now().plusHours(4));
        a2.setTitel("Bostøtte");
        a2.setBeskrivelse("Ugentlig");
        addAktivitet(a2);
        
        Aktivitet a3 = new Aktivitet();
        a3.addPersonRessource(b1);
        a3.addPersonRessource(m2);
        a3.setTitel("Ugesamtale");
        a3.setBeskrivelse("Emner: stemmehøring, familie");
        a3.setStartdato(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(12, 15)));
        a3.setSlutdato(a3.getStart().plusDays(1));
        addAktivitet(a3);
        
        Aktivitet a4 = new Aktivitet();
        a4.addPersonRessource(m1);
        a4.addPersonRessource(m2);
        a4.setTitel("Møde");
        a4.setBeskrivelse("Statusmøde Alice");
        a4.setStartdato(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(16, 30)));
        a4.setSlutdato(LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 30)));
        addAktivitet(a4);
        
        Note n = new Note(b1, LocalDate.of(2015, 11, 20), "Alice skal smides ud pga. af klager fra andre beboere");
        addNote(n);
    }
}
