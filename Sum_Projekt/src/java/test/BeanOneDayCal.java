package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Arthur
 */
@Named("oneCal")
@RequestScoped
public class BeanOneDayCal {
    ArrayList<String> activities = new ArrayList<String>();
    
    public List<String> getActivities(){
        return new ArrayList<String>(activities);
    }
    
    public List<String> getTimes(){
        String[] timearr = new String[]{"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00",
            "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00",
            "19:00", "20:00", "21:00", "22:00", "23:00"};
        ArrayList<String> times = new ArrayList<String>(Arrays.asList(timearr));
        return times;
    }
}