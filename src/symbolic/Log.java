package symbolic;
import java.lang.Math.*;
public class Log extends Unary{

    public Log(Sexpr arg){
        super(arg);
    }
    
    public String getName(){
        return "Log";
    }
   public Constant calculate(Sexpr arg){
        return new Constant(Math.log(arg.getValue()));
    }
    public Sexpr newThis(Sexpr arg){
        return new Log(arg);
    }
}

