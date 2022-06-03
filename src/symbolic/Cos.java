package symbolic;
import java.lang.Math.*;
public class Cos extends Unary{

    public Cos(Sexpr arg){
        super(arg);
    }
    
    public String getName(){
        return "Cos";
    }
   public Constant calculate(Sexpr arg){
        return new Constant(Math.cos(arg.getValue()));
    }
    public Sexpr newThis(Sexpr arg){
        return new Cos(arg);
    }
}

