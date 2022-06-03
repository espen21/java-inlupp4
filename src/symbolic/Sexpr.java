package symbolic;

import java.util.*;

public abstract class Sexpr {
    protected int priority = 0;
    public abstract String getName();
    
    public int priority(){ return this.priority;}
    
    public double getValue(){
        return 0;
    }

    public boolean isConstant(){
        return false;
    }

    public abstract Sexpr eval(Map<String,Sexpr> variables);
    
}
