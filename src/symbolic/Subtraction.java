package symbolic;

public class Subtraction extends Binary{

    public Subtraction(Sexpr left, Sexpr right){
        super(left, right, 3);
    }
    
    protected String getOperator(){
        return " - ";
    }

    public Sexpr newThis(Sexpr left, Sexpr right){
        return new Subtraction(left, right);
    }

    public Constant fullEval(Sexpr left, Sexpr right){
        return new Constant(left.getValue() - right.getValue());
    }
    
}
