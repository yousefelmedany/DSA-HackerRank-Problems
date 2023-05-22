package evaluator;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {
  
  /*** Removes the element at the top of stack and returnsthat element.
  * @return top of stack element, or through exception if empty
  */
  
  public Object pop();
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public Object peek();
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(Object element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty();
  
  public int size();
}


public class MyStack implements IStack {
       public class node{ 
    Object value; 
    node next; 
    public node(Object value,node newnode ) { 
        this.next=newnode; 
        this.value=value; }}
    
    node top;
    int size;
    public MyStack(){
        top=null;
        size=0;
    }
  public Object pop(){
     Object temp;
     temp=top.value;
      top=top.next;
      size--;
      return temp;
  }
  public Object peek(){
      
      return top.value;
  }
      
  
  public void push(Object element){
      node newnode = new node(element,null);
      if (size==0){
          top=newnode;
          size++;
      }
      else{
          newnode.next=top;
          top=newnode;
          size++;
      }
      
  }
  
  public boolean isEmpty(){
      return (size==0);
  }
  
  public int size(){
      
      return size;
  }    

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input =sc.nextLine().replaceAll("\\[|\\]","");
        String[] s= input.split(", ");
        int[] arr;
       if (s.length == 1 && s[0].isEmpty()) 
            arr = new int[]{}; 
        else { 
            arr=new int[s.length];
            for(int i = 0; i < s.length; ++i) 
             arr[i] = Integer.parseInt(s[i]); 
        } 
        
        MyStack newstack=new MyStack();
        for(int i=0;i<arr.length;i++){
          newstack.push(arr[arr.length-1-i]);
        }
    String key=sc.nextLine();
        
        switch(key){
            case "push": int elem=sc.nextInt(); newstack.push(elem);node l=newstack.top;System.out.print("["); 
                 while(l!=null) { 
                    System.out.print(l.value); 
                    if(l.next!=null) { 
                      System.out.print(", "); 
                        } 
                    l=l.next; 
                    } 
                 System.out.print("]"); break; 
            case "pop": if (newstack.size==0){
                            System.out.print("Error");
                        }else{newstack.pop(); node n=newstack.top;System.out.print("["); 
                          while(n!=null) { 
                            System.out.print(n.value); 
                            if(n.next!=null) { 
                             System.out.print(", "); 
                            } 
                            n=n.next; 
                            } 
                        System.out.print("]");} break;
            case "peek": if(newstack.size==0){System.out.print("Error");}else{System.out.print(newstack.peek());}break;
            case "isEmpty": if(newstack.size==0){System.out.print("True");}else{System.out.print("False");}break;
            case "size": System.out.print(newstack.size());break;
    
        }
        
        
        
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}