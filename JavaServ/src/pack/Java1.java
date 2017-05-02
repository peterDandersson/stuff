package pack;

import javax.faces.bean.ManagedBean;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Laptop on 2017-02-27.
 */

@ManagedBean
public class Java1 {
    private String name;
    private String error;

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage(){
        return "Hej " + name;
    }

    public String getError() {
        //return (null != error) ? error : "";
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String submitText(){
        List<String> names = Arrays.asList(new String[]{"olle", "lisa", "kalle"});
        if(!names.contains(getName().toLowerCase())){
            setError("Fel namn försök igen!");
            setName("");
            return "index";
        }

        return "name";
    }

}
