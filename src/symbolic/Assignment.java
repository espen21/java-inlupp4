package symbolic;
import java.util.*;


public class Assignment extends Binary{

    public Assignment(Sexpr expr, Variable var){
        super(expr, var, 10);
    }
    
    protected String getOperator(){
        return " = ";
    }

    public Sexpr newThis(Sexpr expr, Sexpr var){
        return expr;
    }

    public Sexpr eval(Map<String,Sexpr> variables){
        Sexpr left = this.left.eval(variables);
        variables.put(right.getName(), left);
        return left;
    }

    public Constant fullEval(Sexpr left, Sexpr right){
        return new Constant(left.getValue());
    }
    
}
