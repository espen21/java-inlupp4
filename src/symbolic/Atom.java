package symbolic;

import java.util.*;

public abstract class Atom extends Sexpr {
    public String toString(){
        return this.getName();
    }
    public Sexpr eval(Map<String,Sexpr> variables){
        return this;
    }
}
