package evaluator;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * this interface conatains methods declerations 
 * so it can be then implemented in evaluator class
 * @author yousef mohamed
 *
 */
interface IExpressionEvaluator {
  
/**
* Takes a symbolic/numeric infix expression as input and converts it to
* postfix notation. There is no assumption on spaces between terms or the
* length of the term (e.g., two digits symbolic or numeric term)
*
* @param expression infix expression
* @return postfix expression
*/
  
public String infixToPostfix(String expression);
  
  
/**
* Evaluate a postfix numeric expression, with a single space separator
* @param expression postfix expression
* @return the expression evaluated value
*/
  
public int evaluate(String expression);

}

public class Evaluator implements IExpressionEvaluator {
   /**
    * 
    * this methods takes the expression in its infix form and returns its 
    * postfix form
    * @return String
    * @param String
    *
    */
    public String infixToPostfix(String expression){
        String[] word= expression.split("");
        String s="";
        MyStack stack=new MyStack();
        int l=0,i=0,d=0;
        int k,h=0;
        if(word[0].equals("^")||word[0].equals(")")||word[0].equals("*")||word[0].equals("/")){return "Error";}
        if(word[0].equals("-")){
            l+=1;
            i+=1;
            if(word[1].equals("+")) {return "Error";}
            while(word[i].equals("-")){
                l+=1;
                i+=1;
            }
           if(l%2==1){
              stack.push("-");
          }    
            
        }
        if(word[0].equals("+")){
            i+=1;
            if(word[1].equals("-")) {
                h=0;
                while(word[i].equals("-")&&i<word.length) {i+=1;h+=1;}
                if(d==word.length) {return "Error";}
                if(word[d].equals("*")||word[d].equals("/")||word[d].equals("^")
                    ||word[d].equals("(")||word[d].equals(")")) {return "Error";}
                if(h%2==1) {return "Error";}
            }
            else{while(word[i].equals("+")){
                i+=1;
            }}
            
        }
        for (int z=i;z<word.length;z++){
            if(word[z].equals("a")||word[z].equals("b")||word[z].equals("c")){
                s+=word[z];
                k=z;
                if(k!=word.length-1) {
                    k+=1;
                    if(word[k].equals("(")) {return "Error";}
                }
            }
            else if(word[z].equals("+")){
               h=0;
               k=z;
                if(k==word.length-1){return "Error";}else{k+=1;}
                if(word[k].equals("+")||word[k].equals("-")) {
                    while(k<word.length&&(word[k].equals("+")||word[k].equals("-"))){
                        if(word[k].equals("+")){
                        k+=1;
                        }else if(word[k].equals("-")){
                            h+=1;
                            k+=1;
                        }
                }
                if(k==word.length) {return "Error";}
                if(word[k].equals("*")||word[k].equals("/")||
                        word[k].equals(")")||word[k].equals("^")) {return "Error";}
                if(h%2==0) {
                    if(stack.size()==0){stack.push("+");}
                    else{
                        while (!stack.isEmpty()&&!stack.peek().equals("(")){
                            s+=String.valueOf(stack.peek()); stack.pop();
                        }
                        stack.push("+");
                        
                    } 
                
                }
                else{
                    if(stack.size()==0){stack.push("-");}
                    else{
                        while (!stack.isEmpty()&&!stack.peek().equals("(")){
                            s+=String.valueOf(stack.peek()); stack.pop();
                        }
                        stack.push("-");
                    }
                }}
                else if(word[k].equals("a")||word[k].equals("b")||
                        word[k].equals("c")||word[k].equals("(")){
                    if(h%2==0) {
                        
                        while(!stack.isEmpty()&&!stack.peek().equals("(")) 
                        {s+=String.valueOf(stack.peek()); stack.pop();}
                        stack.push("+");}
                    else{
                        while(!stack.isEmpty()&&!stack.peek().equals("(")) 
                        {s+=String.valueOf(stack.peek()); stack.pop();}
                        stack.push("-");}}
                else {return "Error";}
                h=0;
                z=k-1;
            }
            else if(word[z].equals("-")){
                 h=1;
                 k=z;
                  if(k==word.length-1){return "Error";}else{k+=1;}
                  if(word[k].equals("+")||word[k].equals("-")) {
                      while(k<word.length&&(word[k].equals("+")||word[k].equals("-"))){
                          if(word[k].equals("+")){
                          k+=1;
                          }else if(word[k].equals("-")){
                              h+=1;
                              k+=1;
                          }
                  }
                  if(k==word.length) {return "Error";}
                  if(word[k].equals("*")||word[k].equals("/")||
                          word[k].equals(")")||word[k].equals("^")) {return "Error";}
                  if(h%2==0) {
                      if(stack.size()==0){stack.push("+");}
                      else{
                          while (!stack.isEmpty()&&!stack.peek().equals("(")){
                              s+=String.valueOf(stack.peek()); stack.pop();
                          }
                          stack.push("+");
                          
                      } 
                  
                  }
                  else{
                      if(stack.size()==0){stack.push("-");}
                      else{
                          while (!stack.isEmpty()&&!stack.peek().equals("(")){
                              s+=String.valueOf(stack.peek()); stack.pop();
                          }
                          stack.push("-");
                      }
                  }}
                  else if(word[k].equals("a")||word[k].equals("b")||
                          word[k].equals("c")||word[k].equals("(")){
                        if(h%2==0) {
                            while(!stack.isEmpty()&&!stack.peek().equals("(")) 
                            {s+=String.valueOf(stack.peek()); stack.pop();}
                            stack.push("+");}
                        else{
                            while(!stack.isEmpty()&&!stack.peek().equals("(")) 
                            {s+=String.valueOf(stack.peek()); stack.pop();}
                            stack.push("-");}}
                  else {return "Error";}
                  h=0;
                  z=k-1;
            }
            else if(word[z].equals("*")){
                k=z;
                if(k==word.length-1){return "Error";}else{k+=1;}
                if(word[k].equals("*")||word[k].equals("/")||word[k].equals("^")||
                    word[k].equals(")")){return "Error";}
                if(stack.size()==0){stack.push("*");}
                else if(stack.peek().equals("/")||stack.peek().equals("*")||stack.peek().equals("^"))
                {s+=String.valueOf(stack.peek());stack.pop();
                    while(!stack.isEmpty()&&(stack.peek().equals("/")||stack.peek().equals("*")
                                             ||stack.peek().equals("^"))){
                        s+=String.valueOf(stack.peek()); stack.pop();
                       }                                                                                
                    stack.push("*");}
                    else{ stack.push("*");}
                if(word[k].equals("+")){
                    while(word[k].equals("+")&&k<word.length){
                        k+=1;
                    }
                    if(k==word.length){return "Error";}
                    else if(!word[k].equals("a")&&
                            !word[k].equals("b")&&!word[k].equals("c")) {return "Error";}
                    else{z=k-1;}

                }
                else if(word[k].equals("-")){
                    h=0;
                    while(word[k].equals("-")&&k<word.length) {k+=1;h+=1;}
                    if(k==word.length) {return "Error";}
                    if(word[k].equals("*")||word[k].equals("/")||word[k].equals("^")||
                            word[k].equals("(")||word[k].equals("+")||word[k].equals(")")) {return "Error";}
                    else {
                        if(h%2==0) {z=k-1;}else {return "Error";}
                    }
                    
            }}
                 else if(word[z].equals("/")){
                k=z;
                if(k==word.length-1){return "Error";}else{k+=1;}
                if(word[k].equals("*")||word[k].equals("/")||word[k].equals("^")||
                    word[k].equals(")"))
                                    {return "Error";}
                if(stack.size()==0){stack.push("/");}
                else if(stack.peek().equals("/")||stack.peek().equals("*")||stack.peek().equals("^"))
                {s+=String.valueOf(stack.peek());stack.pop();
                    while(!stack.isEmpty()&&(stack.peek().equals("/")||stack.peek().equals("*")
                                             ||stack.peek().equals("^"))){
                        s+=String.valueOf(stack.peek()); stack.pop();
                       }                                                                                
                    stack.push("/");}
                    else{ stack.push("/");}
                if(word[k].equals("+")){
                    while(word[k].equals("+")&&k<word.length){
                        k+=1;
                    }
                    if(k==word.length){return "Error";}
                    else if(!word[k].equals("a")&&
                            !word[k].equals("b")&&!word[k].equals("c")) {return "Error";}
                    else{z=k-1;}

                }
                else if(word[k].equals("-")){
                    h=0;
                    while(word[k].equals("-")&&k<word.length) {k+=1;h+=1;}
                    if(k==word.length) {return "Error";}
                    if(word[k].equals("*")||word[k].equals("/")||word[k].equals("^")||
                            word[k].equals("(")||word[k].equals("+")||word[k].equals(")")) {return "Error";}
                    else {
                        if(h%2==0) {z=k-1;}else {return "Error";}
                    }
                    
            }
                         z=k-1;
                
            }
            else if(word[z].equals("^")){
                k=z;
                 if(k==word.length-1){return "Error";}else{k+=1;}
              if(word[k].equals("*")||word[k].equals("/")
                      ||word[k].equals("^")||word[k].equals(")")){return "Error";}
               stack.push("^");
               if(word[k].equals("+")){
                   while(word[k].equals("+")&&k<word.length){
                       k+=1;
                   }
                   if(k==word.length){return "Error";}
                   else if(!word[k].equals("a")&&
                           !word[k].equals("b")&&!word[k].equals("c")) {return "Error";}
                       else{z=k-1;}

               }
               else if(word[k].equals("-")){
                   h=0;
                   while(word[k].equals("-")&&k<word.length) {k+=1;h+=1;}
                   if(k==word.length) {return "Error";}
                   if(word[k].equals("*")||word[k].equals("/")||word[k].equals("^")||
                           word[k].equals("(")||word[k].equals("+")||word[k].equals(")")) {return "Error";}
                   else {
                       if(h%2==0) {z=k-1;}else {return "Error";}
                   }
                   
           }
                z=k-1;
            }
            else if(word[z].equals("(")){
                stack.push("(");
                k=z;
                if(k==word.length-1){return "Error";}else{k+=1;}
                if(word[k].equals("*")||word[k].equals("/")||
                   word[k].equals("^")||word[k].equals(")")){return "Error";}
                if(word[k].equals("+")){
                    while (word[k].equals("+")&&k<word.length){k+=1;}
                    if(k==word.length){return "Error";}
                    if(word[k].equals("*")||word[k].equals("/")||
                      word[k].equals("^")||word[k].equals(")")||word[k].equals("-")){return "Error";}
                      z=k-1;
                }
                
            }
            else if(word[z].equals(")")){
                if(z!=word.length-1){
                  if(word[z+1].equals("(")||word[z+1].equals("a")
                     ||word[z+1].equals("c")||word[z+1].equals("b")){return "Error";}
                  }
            while(!stack.isEmpty()&&!stack.peek().equals("(")) {
                s+=String.valueOf(stack.peek());stack.pop();
            }
            if(stack.size()==0){return "Error";}
            if(stack.peek().equals("(")){
                stack.pop();
            }else{return "Error";}
           }
           
            
            else{return "Error";}
            
          
        }
        while(!stack.isEmpty()){
            if(stack.peek().equals("(")){return "Error";}
            else{s+=String.valueOf(stack.peek());stack.pop();}
        }
        return s;
        
        
    }
    /**
     * those are the variable used to store values of a, b and c
     */
     static String a,b,c;
     /**
      * this method takes the postfix expression as a parameter
      * and returns the final result of the expression
      * @return int
      * @param String 
      */
    public int evaluate(String expression){
        MyStack rstack =new MyStack();
        String[] word= expression.split("");
        for(int i=0;i<word.length;i++){
            switch(word[i]){
                case "a" : rstack.push(a.replace("a=",""));break;
                case "b" : rstack.push(b.replace("b=",""));break;
                case "c" : rstack.push(c.replace("c=",""));break;
                case "*" : if (rstack.size()==1) {int t=0*Integer.parseInt(String.valueOf(rstack.peek()));
                                                  rstack.push(t);}
                else{int t2=Integer.parseInt(String.valueOf(rstack.peek()));rstack.pop();
                int t1=Integer.parseInt(String.valueOf(rstack.peek())); rstack.pop(); int t=t1*t2;rstack.push(t);} 
                break;
                
                case "/" : if (rstack.size()==1) {int s=0/Integer.parseInt(String.valueOf(rstack.peek()));
                                                  rstack.push(s);}
                else{int s2=Integer.parseInt(String.valueOf(rstack.peek()));rstack.pop();
                int s1=Integer.parseInt(String.valueOf(rstack.peek())); rstack.pop(); int s=s1/s2;rstack.push(s);} 
                break;
                
                case "+" : if (rstack.size()==1) {int h=0+Integer.parseInt(String.valueOf(rstack.peek()));
                                                  rstack.push(h);}
                else{int h2=Integer.parseInt(String.valueOf(rstack.peek()));rstack.pop();
                int h1=Integer.parseInt(String.valueOf(rstack.peek())); rstack.pop(); int h=h1+h2;rstack.push(h);} 
                break;
                case "-" : if (rstack.size()==1) {int c=0-Integer.parseInt(String.valueOf(rstack.peek()));
                                                  rstack.push(c);}
                else{int c2=Integer.parseInt(String.valueOf(rstack.peek()));rstack.pop();
                int c1=Integer.parseInt(String.valueOf(rstack.peek())); rstack.pop(); int c=c1-c2;rstack.push(c);} 
                break;
                
                case "^" : if (rstack.size()==1) {
                    int q=(int)Math.pow(0, Double.valueOf(String.valueOf(rstack.peek())).doubleValue());
                                                  rstack.push(q);}
                else{int q2=Integer.parseInt(String.valueOf(rstack.peek()));rstack.pop();
                int q1=Integer.parseInt(String.valueOf(rstack.peek())); rstack.pop(); 
                     int q=(int)Math.pow(Double.valueOf(q1),Double.valueOf(q2));rstack.push(q);}
                break;
                default : rstack.push(word[i]);
                
            }
            
        }   
             return Integer.parseInt(String.valueOf(rstack.peek()));
        
    }
   
    
  
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String expression= sc.nextLine();
         a= sc.nextLine();
         b= sc.nextLine();
         c= sc.nextLine();
        Evaluator eva = new Evaluator();
        String postifix = eva.infixToPostfix(expression);
        if(postifix=="Error"||postifix.length()==0){  
            System.out.println("Error");}
       else{ int result =eva.evaluate(postifix);
         System.out.println(postifix);
         System.out.println(result);
           }
                
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    }
}
