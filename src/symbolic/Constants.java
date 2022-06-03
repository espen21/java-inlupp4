package symbolic;

import java.util.*;;    
public class Constants {
    public static final HashMap<String, Double> namedConstants = new HashMap<>();

    static {
        Constants.namedConstants.put("pi", Math.PI);
        Constants.namedConstants.put("e",  Math.E);
        Constants.namedConstants.put("Answer",42.0);
        Constants.namedConstants.put("L",6.022140857*(Math.pow(10, 23)));

        
    }
    public boolean  isAconstant(String var){
        for (String key : namedConstants.keySet()){
            if (key.equals(var)){
                
                return true;
            }
        }
        return false;
    }

    public Double getValue(String var){
        return namedConstants.get(var);
    }
}

