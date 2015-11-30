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
public class Resource implements PersonResource{
    private boolean bil;
    private boolean mødelokale;
    
    public Resource(){
        
    }

    public boolean isBil() {
        return bil;
    }

    public void setBil(boolean bil) {
        this.bil = bil;
    }

    public boolean isMødelokale() {
        return mødelokale;
    }

    public void setMødelokale(boolean mødelokale) {
        this.mødelokale = mødelokale;
    }
    
   public String toString(){
       if (isBil()){
           return "Bil";
       } else if (isMødelokale()){
           return "Mødelokale";
       } else{
           return "Ingen Resource";
       }
   } 
}
