package symbolic;
import java.util.*;

public class Vars extends Command{
    public Sexpr eval(Map<String,Sexpr> variables){
        return this;
    }

    public String toString(){
        return "vars";
    }
}
