package beans;

import java.io.Serializable;

import javax.inject.Named;
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import model.Beboer;


   // or import javax.faces.bean.SessionScoped;
@Named // or @ManagedBean(name="user")
@SessionScoped
public class BeboerBean implements Serializable {
//    @Inject
//    private service.Service service;-- ved ikke om det skal bruges
    private Beboer beboer = new Beboer();
    
    public Beboer getBeboer(){
        return beboer;
    }

}
