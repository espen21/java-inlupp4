package symbolic;
import java.lang.Math.*;
public class Negation  extends Unary{

    public Negation(Sexpr arg){
        super(arg);
    }
    
    public String getName(){
        return "-";
    }
    public Constant calculate(Sexpr arg){
        return new Constant(-1*arg.getValue());
    }
    public Sexpr newThis(Sexpr arg){
        return new Negation(arg);
    }
}

