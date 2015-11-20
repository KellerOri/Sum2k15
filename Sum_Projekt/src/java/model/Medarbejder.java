/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Andromeda
 */
public class Medarbejder implements PersonResource{
    private String navn;

    public Medarbejder() {
    }

    public Medarbejder(String navn) {
        this.navn = navn;
    }

    
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    
}
