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
public class Beboer implements PersonResource{
    
    private String navn;
    private String noter;
    
    public Beboer() {    
    }

    public Beboer(String navn) {
        this.navn = navn;
    }
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    } 
    
    public String getNoter() {
        return noter;
    }

    public void setNoter(String noter) {
        this.noter = noter;
    }
    
    
}
