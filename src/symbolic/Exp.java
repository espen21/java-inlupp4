package symbolic;
import java.lang.Math.*;
public class Exp extends Unary{

    public Exp(Sexpr arg){
        super(arg);
    }
    
    public String getName(){
        return "Exp";
    }
   public Constant calculate(Sexpr arg){
        return new Constant(Math.exp(arg.getValue()));
    }
    public Sexpr newThis(Sexpr arg){
        return new Exp(arg);
    }
}

