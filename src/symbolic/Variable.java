package symbolic;
import java.util.*;
public class Variable extends Atom{
    
    private String ident;

    public Variable(String name){
        this.ident = name;
    }
    public String getName(){
        return ident;
    }
    public Sexpr eval(Map<String,Sexpr> variables){
        Sexpr expr = variables.get(ident);
        if(expr != null){
            return expr.eval(variables);//.eval(Map<String,Sexpr> variables)
        }
        else{
            return this;
        }
    }

    
}
