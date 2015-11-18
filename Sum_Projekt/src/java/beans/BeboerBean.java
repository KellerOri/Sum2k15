package beans;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.inject.Named;
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Beboer;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;


   // or import javax.faces.bean.SessionScoped;
@Named // or @ManagedBean(name="user")
@SessionScoped
public class BeboerBean implements Serializable {
//    @Inject
//    private service.Service service;-- ved ikke om det skal bruges
    private Beboer beboer = new Beboer();
    private List<Beboer> alleBeboer;
    
    public Beboer getBeboer(){
        return beboer;
    }
    
    @PostConstruct 
    public void init() {
        alleBeboer = new ArrayList<Beboer>();
        alleBeboer.add(new Beboer("Anne"));
        alleBeboer.add(new Beboer("Bjørn"));
        alleBeboer.add(new Beboer("Niels"));
        alleBeboer.add(new Beboer("Rikke"));
        
    }
    
    public List<Beboer> getAlleBeboer() {
        return alleBeboer;
    }
    
     public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
