package symbolic;

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
        String leftName = left.getName();
        String rightName = right.getName();
        if(this.priority() < left.priority()){
            leftName = "(" + left.getName() + ")";
        }

        if(this.priority() < right.priority()){
            rightName = "(" + right.getName() + ")";
        }
        return leftName + this.getOperator() + rightName;
    }
}
