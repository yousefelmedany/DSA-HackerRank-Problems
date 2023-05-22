import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Fibonnaci_Sequence {
	public int fibonacci(int n) {
        int fib1=1,fib2=1,fib=0;
        if(n==1){
            fib=0;
        }else if(n==2||n==3){
            fib=1;
        }else{
            for(int i=4;i<=n;i++){
                fib=fib1+fib2;
                fib1=fib2;
                fib2=fib;
                
            }
        }
        
        return fib;
        
        
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        
        System.out.print(new Fibonnaci_Sequence().fibonacci(n));
        
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}