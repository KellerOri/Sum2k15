/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Christian
 */
public class Note {
    private Beboer beboer;
    private LocalDate dag;
    private LocalTime tidspunkt;

    public Note(Beboer beboer, LocalDate dag) {
        this.dag = dag;
        this.beboer = beboer;
        tidspunkt = LocalTime.now();
    }
    

    public Beboer getBeboer() {
        return beboer;
    }

    public void setBeboer(Beboer beboer) {
        this.beboer = beboer;
    }

    public LocalDate getDag() {
        return dag;
    }

    public void setDag(LocalDate dag) {
        this.dag = dag;
    }

    public LocalTime getTidspunkt() {
        return tidspunkt;
    }
    
    
    
    
}
