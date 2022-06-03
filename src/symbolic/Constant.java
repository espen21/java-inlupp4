package symbolic;

public class Constant extends Atom {
    private double value;
    public Constant(double value){
        this.value = value;
    }
    
    public String getName(){
        return String.valueOf(this.getValue()); 
    }
    //Sexpr eval(map);
    public double getValue(){
        return value;
    }
    public boolean isConstant(){
        return true;
    }
}
