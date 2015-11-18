package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.inject.Named;
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import model.*;

   // or import javax.faces.bean.SessionScoped;
@Named // or @ManagedBean(name="user")
@SessionScoped
public class NoteBean implements Serializable {

    private Note note = new Note();

    public Note getNote() {
        return note;
    }

    public void setIndhold(String tekst) {
        note.setIndhold(tekst);
    }

    public String getIndhold() {
        return note.getIndhold();
    }
    
    public void setBeboer(Beboer beboer){
        note.setBeboer(beboer);
    }
    
    public Beboer getBeboer(){
        return note.getBeboer();
    }
    
    public void setDag(LocalDate dag){
        note.setDag(dag);
    }
    
    public LocalDate getDag(){
        return note.getDag();
    }
    
    public void setTidspunkt(LocalTime tidspunkt){
        note.setTidspunkt(tidspunkt);
    }
    
    public LocalTime getTidspunkt(){
        return note.getTidspunkt();
    }

}
