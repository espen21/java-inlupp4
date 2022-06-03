
import symbolic.*;

public class Calculator{
    public static void main(String args[]){
        Constant k = new Constant(3.0);
        Variable test = new Variable("a");
        Addition testAdd = new Addition(k,k);
        System.out.println(testAdd);
    }
}
