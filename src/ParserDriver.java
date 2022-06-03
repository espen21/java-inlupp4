import java.io.IOException;
import symbolic.*;
import java.util.*;

//package parser;

class ParserDriver{
    public static void main(String[] args){

        
        
        Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
        Sexpr ans;
        
        while (true){
            try {
                Parser p = new Parser();
                System.out.print("? ");
                Sexpr e = p.statement();
                System.out.println("Inläst uttryck: " + e);  // För kontroll
                ans = e.eval(variables);
                if(ans.getName().equals("quit")){
                    System.out.println("Good bye");
                    break;
                }
                else if(ans.getName().equals("vars")){
                    printMap(variables);
                }
                variables.put("ans", ans);
                
                System.out.println(ans);
            }catch(SyntaxErrorException e){
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.err.println("IO Exception!");
            }
        }
    }

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
       
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

}
