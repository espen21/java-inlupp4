import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.io.StringReader;
import symbolic.*;
import java.util.*;
public class ParserTests{

    Parser p;
    double x = 1;
    double y = 2;
    Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
    
    //@Before
    void init(){
        x = 1;
        y = 2;
        
    }
    
    @Test
    public void testBinaryString() {
        try{
            p = new Parser("1+2");
            Sexpr parsedExpression = p.statement();
            Sexpr newExpression = new Addition(new Constant(x), new Constant(2));
            assertEquals(parsedExpression.toString(), newExpression.toString());
            
            p = new Parser("1-2");
            parsedExpression = p.statement();
            newExpression = new Subtraction(new Constant(x), new Constant(2));
            assertEquals(parsedExpression.toString(), newExpression.toString());

            p = new Parser("1*2");
            parsedExpression = p.statement();
            newExpression = new Multiplication(new Constant(x), new Constant(2));
            assertEquals(parsedExpression.toString(), newExpression.toString());

            p = new Parser("1/2");
            parsedExpression = p.statement();
            newExpression = new Division(new Constant(x), new Constant(2));
            assertEquals(parsedExpression.toString(), newExpression.toString());

            
            //System.out.println("compared " + x + " and  " + expr );
        }
        catch(IOException e){
            //  System.out.println("Oh uh!!!");
        }
        catch(SyntaxErrorException e){
            
        }
    }

    @Test
    public void testUnaryString(){
        x = 3.14;
        try{
            p = new Parser("Sin(3.14)");
            Sexpr parsedExpression = p.statement();
            Sexpr newExpression = new Sin(new Constant(x));
            //System.out.println()
            assertEquals(parsedExpression.toString(), newExpression.toString());

            p = new Parser("Cos(3.14)");
            parsedExpression = p.statement();
            newExpression = new Cos(new Constant(x));
            //System.out.println()
            assertEquals(parsedExpression.toString(), newExpression.toString());
            
            p = new Parser("Exp(3.14)");
            parsedExpression = p.statement();
            newExpression = new Exp(new Constant(x));
            //System.out.println()
            assertEquals(parsedExpression.toString(), newExpression.toString());
            
            p = new Parser("Log(3.14)");
            parsedExpression = p.statement();
            newExpression = new Log(new Constant(x));
            //System.out.println()
            assertEquals(parsedExpression.toString(), newExpression.toString());
        }catch(IOException e){
            //  System.out.println("Oh uh!!!");
        }
        catch(SyntaxErrorException e){
            
        }
    }

    @Test
    public void testBigExpressionString(){
        
        try{
            p = new Parser("Sin(1)+Cos(2)*(2-1)/Exp(2)");
            Sexpr parsedExpression = p.statement();

            assertEquals(parsedExpression.toString(), "Sin(1.0) + Cos(2.0)*(2.0 - 1.0)/Exp(2.0)");
        }catch(IOException e){
            //  System.out.println("Oh uh!!!");
        }
        catch(SyntaxErrorException e){
            
        }
    }
    
    @Test
    public void testBinaryEval() {
         try{
            p = new Parser("1+2");
            Sexpr parsedExpression = p.statement().eval(variables);
            Sexpr newExpression = new Constant(x+y);
            assertEquals(parsedExpression.toString(), newExpression.toString());

            p = new Parser("1-2");
            parsedExpression = p.statement().eval(variables);
            newExpression = new Constant(x-y);
            assertEquals(parsedExpression.toString(), newExpression.toString());

            p = new Parser("1*2");
            parsedExpression = p.statement().eval(variables);
            newExpression = new Constant(x*y);
            assertEquals(parsedExpression.toString(), newExpression.toString());
            
            p = new Parser("1/2");
            parsedExpression = p.statement().eval(variables);
            newExpression = new Constant(x/y);
            assertEquals(parsedExpression.toString(), newExpression.toString());

            
            //System.out.println("compared " + x + " and  " + expr );
        }
        catch(IOException e){
            //  System.out.println("Oh uh!!!");
        }
        catch(SyntaxErrorException e){
            
        }
    }
    @Test
    public void testAtomString(){
        x = 3.14;
        try{
            p = new Parser("3.14");
            Sexpr parsedExpression = p.statement();
            Sexpr newExpression = (new Constant(x));
            //System.out.println()
            assertEquals(parsedExpression.toString(), newExpression.toString());

            p = new Parser("a");
            parsedExpression = p.statement();
            newExpression = new Cos(new Constant(x));
            //System.out.println()
            assertEquals(parsedExpression.toString(), newExpression.toString());
            
            p = new Parser("Exp(3.14)");
            parsedExpression = p.statement();
            newExpression = new Exp(new Constant(x));
            //System.out.println()
            assertEquals(parsedExpression.toString(), newExpression.toString());
            
            p = new Parser("Log(3.14)");
            parsedExpression = p.statement();
            newExpression = new Log(new Constant(x));
            //System.out.println()
            assertEquals(parsedExpression.toString(), newExpression.toString());
        }catch(IOException e){
            //  System.out.println("Oh uh!!!");
        }
        catch(SyntaxErrorException e){
            
        }
    }

}
