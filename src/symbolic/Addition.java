package symbolic;

public class Addition extends Binary{

    public Addition(Sexpr left, Sexpr right){
        super(left, right, 3);
    }
    
    protected String getOperator(){
        return " + ";
    }

    public Sexpr newThis(Sexpr left, Sexpr right){
        return new Addition(left, right);
    }

    public Constant fullEval(Sexpr left, Sexpr right){
        return new Constant(left.getValue() + right.getValue());
    }
    
}
