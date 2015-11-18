package beans;

import java.io.Serializable;

import javax.inject.Named;
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;

   // or import javax.faces.bean.SessionScoped;
@Named // or @ManagedBean(name="user")
@SessionScoped
public class BeboerBean implements Serializable {

}
