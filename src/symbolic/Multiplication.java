package symbolic;

public class Multiplication extends Binary{

    public Multiplication(Sexpr left, Sexpr right){
        super(left, right, 2);
    }
    
    protected String getOperator(){
        return "*";
    }
    public Sexpr newThis(Sexpr left, Sexpr right){
        return new Multiplication(left, right);
    }

    public Constant fullEval(Sexpr left, Sexpr right){
        return new Constant(left.getValue() * right.getValue());
    }
    

}
