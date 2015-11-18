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
    private String indhold;

    public Note() {
    }

    public Note(Beboer beboer, LocalDate dag, String indhold) {
        this.dag = dag;
        this.beboer = beboer;
        tidspunkt = LocalTime.now();
        this.indhold = indhold;
    }

    public String getIndhold() {
        return indhold;
    }

    public void setIndhold(String indhold) {
        this.indhold = indhold;
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

    public void setTidspunkt(LocalTime tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

}
