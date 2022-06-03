import java.io.StreamTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.StringReader;
import symbolic.*;
//package parser;

class Parser{
    StreamTokenizer st;
    Constants constants = new Constants();
    public Parser(){
        st = new StreamTokenizer(System.in);
        st.ordinaryChar('-');
        st.ordinaryChar('/');
        st.ordinaryChar('=');
        st.eolIsSignificant(true);
    }
    public Parser(String input){
        BufferedReader in = new BufferedReader(new StringReader(input));
        st = new StreamTokenizer(in);
        st.ordinaryChar('-');
        st.ordinaryChar('/');
        st.eolIsSignificant(true);
    }

    private Variable identifier() throws IOException{
        if(st.nextToken() != st.TT_WORD){
            throw new SyntaxErrorException("Expected identifier");
        }
        return new Variable(st.sval);
    }

    public Sexpr statement() throws IOException{
        if(st.nextToken() == st.TT_WORD){
            if(st.sval.equals("quit")){
                return new Quit();
            }
            else if(st.sval.equals("vars")){
                return new Vars();
            }
        }
        st.pushBack();
        return assignment();
               
    }
    
    private Sexpr assignment() throws IOException{
        Sexpr result = expression();
        st.nextToken();
        while (st.ttype == '='){
            Variable var = identifier();
            result = new Assignment(result, var);
            st.nextToken();
        }
        
        st.pushBack();
        return result;
    }
    
    private Sexpr expression() throws IOException{
        Sexpr result = term();
        st.nextToken();        
        while (st.ttype == '+' || st.ttype == '-'){
            if(st.ttype == '+'){
                result = new Addition(result, term());
            }else{
                result = new Subtraction(result, term());
            }
            st.nextToken();
        }
        st.pushBack();
        return result;
    }

    private Sexpr term() throws IOException{
        Sexpr result = factor();
        st.nextToken();
        while (st.ttype == '*' || st.ttype == '/'){
            System.out.println("Found a term");
            if(st.ttype == '*'){
                result = new Multiplication(result, factor());
                
            }
            else{
                result = new Division(result, factor());
            }
            st.nextToken();
        }
        st.pushBack();
        return result;
    }

    private Sexpr word() throws IOException{
        if(st.sval.equals("Sin")){
            return new Sin(factor()); 
        } else if(st.sval.equals("Cos")){
            return new Cos(factor()); 
        } else if(st.sval.equals("Exp")){
            return new Exp(factor()); 
        } else if(st.sval.equals("Log")){
            return new Log(factor()); 
        }
        else if(st.sval.equals("-")){
            return new Negation(factor());
        } 
        else{
            st.pushBack();
            return identifier();
        }
    }
    
    private Sexpr factor() throws IOException{
        Sexpr result;
        
        if(st.nextToken() != '('){
            
            st.pushBack();
            if(st.nextToken() != st.TT_WORD){
                if(st.ttype == '-'){
                    result = new Negation(factor());
                }
                else{
                    st.pushBack();
                    result = new Constant(number());
                }
            }else{
                
                result = word();
            }
        }else{
            result = assignment();
            if(st.nextToken() != ')'){
                throw new SyntaxErrorException("expected ')'");
            }
        }
        return result;
    }
    private double number() throws IOException{
        if(st.nextToken() != st.TT_NUMBER){
            throw new SyntaxErrorException("Expected number");
        }
        return st.nval;
    }


    
}

class SyntaxErrorException extends RuntimeException{
    public SyntaxErrorException(){
        super();
    }
    public SyntaxErrorException(String msg){
        super(msg);
    }
}
