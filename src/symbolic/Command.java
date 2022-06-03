package symbolic;

public abstract class Command extends Sexpr{
    public String getName(){
        return this.toString();
    }
}
