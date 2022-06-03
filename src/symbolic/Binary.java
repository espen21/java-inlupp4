package symbolic;

import java.util.*;

public abstract class Binary extends Sexpr{
    
    protected Sexpr left;
    protected Sexpr right;
    public Binary(Sexpr left, Sexpr right, int priority){
        this.left = left;
        this.right = right;
        this.priority = priority;
        
    }
    protected abstract String getOperator();
    
    public String toString(){
        return this.getName();
    }
    
    public String getName(){
        String leftName = left.toString();
        String rightName = right.toString();
        if(this.priority() < left.priority()){
            leftName = "(" + leftName + ")";
        }

        if(this.priority() < right.priority()){
            rightName = "(" + rightName + ")";
        }
        return leftName + this.getOperator() + rightName;
     }

    public Sexpr eval(Map<String,Sexpr> variables){
        Sexpr left = this.left.eval(variables);
        Sexpr right = this.right.eval(variables);
        if(left.isConstant() && right.isConstant()){
            return this.fullEval(left, right);
        }
        else{
            return this.newThis(left, right);
        }
    }

    public abstract Constant fullEval(Sexpr left, Sexpr right);
    public abstract Sexpr newThis(Sexpr left, Sexpr right);
}
