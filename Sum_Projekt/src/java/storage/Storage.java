/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Aktivitet;
import model.Beboer;
import model.Medarbejder;
import model.Note;
import model.PersonResource;
import model.Resource;

public class Storage implements Serializable{

    private Map<String, Beboer> beboere;
    private List<Aktivitet> aktiviteter;
    private Map<String, Medarbejder> medarbejdere;
    private Map<String, Resource> resourcer;
    private List<Note> noter;
    private static Storage instance;

    private Storage() {
        beboere = new HashMap<String, Beboer>();
        aktiviteter = new ArrayList<Aktivitet>();
        medarbejdere = new HashMap<String, Medarbejder>();
        resourcer = new HashMap<String, Resource>();
        noter = new ArrayList<Note>();
        initStorage();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public ArrayList<Beboer> getBeboere() {
        return new ArrayList<>(beboere.values());
    }

//    public void setBeboerer(List<Beboer> beboerer) {
//        this.beboere = beboerer;
//    }

    public Beboer addBeboer(Beboer beboer) {
        beboere.put(beboer.getId(), beboer);
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
    
    public Aktivitet addAktivitet(Aktivitet a, List<PersonResource> prs){
        for(PersonResource pr : prs){
            pr.addAktivitet(a);
            a.addPersonRessource(pr);
        }
        addAktivitet(a);
        return a;
    }

    public List<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere.values());
    }
//
//    public void setMedarbejdere(List<Medarbejder> medarbejdere) {
//        this.medarbejdere = medarbejdere;
//    }

    public Medarbejder addMedarbejder(Medarbejder m) {
        medarbejdere.put(m.getId(), m);
        return m;
    }

    public List<Resource> getResourcer() {
        return new ArrayList<>(resourcer.values());
    }

//    public void setRessourcer(List<Resource> ressourcer) {
//        this.resourcer = ressourcer;
//    }

    public void addNote(Note n) {
        noter.add(n);
    }
    
    public List<Note> getNoter(){
        return new ArrayList<>(noter);
    }

    public PersonResource getPersonResource(String id){
        if(id.matches("m.")){
            return medarbejdere.get(id);
        }else if(id.matches("b.")){
            return beboere.get(id);
        }else if(id.matches("r.")){
            return resourcer.get(id);
        }else{
            System.out.println("id ikke fundet " + id);
            return null;
        }
    }
    public List<Aktivitet> getAktiviteterPaaDag(LocalDate ldt) {
        List<Aktivitet> result = new ArrayList<Aktivitet>();
//        Systems.out.println("Storage " + aktiviteter.size());
        for (Aktivitet a : aktiviteter) {
//            System.out.println(a);
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
//        System.out.println("init()");
        List<PersonResource> temp = new ArrayList<PersonResource>();
        
        Beboer b1 = addBeboer(new Beboer("Alice"));
        Beboer b2 = addBeboer(new Beboer("Bob"));

        Beboer b3 = addBeboer(new Beboer("Merete"));
        Beboer b4 = addBeboer(new Beboer("Lis"));
        Beboer b5 = addBeboer(new Beboer("Ralf"));
        
        Resource r1 = new Resource();
        r1.setBil(true);

        Medarbejder m1 = addMedarbejder(new Medarbejder("Anette"));
        Medarbejder m2 = addMedarbejder(new Medarbejder("Louise"));

        Aktivitet a1 = new Aktivitet();
        a1.setStartdato(LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30)));
        a1.setSlutdato(LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0)));
        a1.setTitel("Bjerge");

        temp.clear();
        temp.add(b1);
        temp.add(m1);
        addAktivitet(a1, temp);

        a1.setNote("Jaer. Og gud sagde Moses Moses!");
        a1.addPersonRessource(r1);

        Aktivitet a2 = new Aktivitet();
        a2.setStartdato(LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)));
        a2.setSlutdato(LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 0)));
        a2.setTitel("Bostøtte");

        temp.clear(); 
        temp.add(b2);
        temp.add(m2);
        addAktivitet(a2, temp);

        a2.setNote("Ugentlig");

        
        Aktivitet a3 = new Aktivitet();
        a3.setTitel("Ugesamtale");
        a3.setNote("Emner: stemmehøring, familie");
        a3.setStartdato(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(12, 15)));
        a3.setSlutdato(a3.getStart().plusHours(1));
        temp.clear();
        temp.add(b1);
        temp.add(m2);
        addAktivitet(a3, temp);
        
        Aktivitet a4 = new Aktivitet();
        a4.setTitel("Møde");
        a4.setNote("Statusmøde Alice");
        a4.setStartdato(LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(16, 30)));
        a4.setSlutdato(a4.getStart().plusHours(2));
        temp.clear();
        temp.add(m1);
        temp.add(m2);
        addAktivitet(a4, temp);
        
        Aktivitet a5 = new Aktivitet();
        a5.setTitel("Sensorisk profil");
        a5.setNote("");
        a5.setStartdato(LocalDateTime.of(LocalDate.now().plusDays(2), LocalTime.of(11, 30)));
        a5.setSlutdato(a4.getStart().plusHours(2));
        temp.clear();
        temp.add(m1);
        temp.add(b5);
        addAktivitet(a5, temp);
        
        Aktivitet a6 = new Aktivitet();
        a6.setTitel("Ugesamtale");
        a6.setNote("Spørg ind til familie, tilbagefald");
        a6.setStartdato(LocalDateTime.of(LocalDate.now().plusDays(2), LocalTime.of(20, 30)));
        a6.setSlutdato(a4.getStart().plusMinutes(45));
        temp.clear();
        temp.add(m2);
        temp.add(b4);
        addAktivitet(a6, temp);     
        
        Aktivitet a7 = new Aktivitet();
        a7.setTitel("Uden Medarbjeder");
        a7.setStartdato(LocalDateTime.of(LocalDate.now(), LocalTime.of(20, 30)));
        a7.setSlutdato(a4.getStart().plusMinutes(55));
        a7.addPersonRessource((PersonResource)b1);
        
        //a7.addPersonRessource((PersonResource) m2);
        addAktivitet(a7);
        
      
        
        Note n = new Note(b1, LocalDate.now(), "Alice skal smides ud pga. af klager fra andre beboere");
        addNote(n);
        
        
    }
}
