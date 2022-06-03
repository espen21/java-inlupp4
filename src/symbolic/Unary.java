package symbolic;

import java.util.*;

public abstract class Unary extends Sexpr {
    protected Sexpr argument;

    public Unary(Sexpr arg){
        argument = arg;
    }

    
    public int priority(){
        return 1;
    }
    public String toString(){
        return this.getName() + "(" + this.argument.toString() + ")";
    }

    public abstract Constant calculate(Sexpr arg);
    public abstract Sexpr newThis(Sexpr arg);
    
    public Sexpr eval(Map<String,Sexpr> variables){
        Sexpr expr = argument.eval(variables);
        if(expr.isConstant()){
            return this.calculate(expr);
        }else{
            return newThis(expr);
        }
    }
}
