package symbolic;
import java.lang.Math.*;

public class Sin  extends Unary{

    public Sin(Sexpr arg){
        super(arg);
    }
    
    public String getName(){
        return "Sin";
    }

    public Constant calculate(Sexpr arg){
        return new Constant(Math.sin(arg.getValue()));
    }
    public Sexpr newThis(Sexpr arg){
        return new Sin(arg);
    }
}

