import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sum_Even_Odd {
	public int[] sumEvenOdd(int[] array) {
    	int[] arr=new int[2];
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                arr[0]+=array[i];
            }else{
                arr[1]+=array[i];
            }
        
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String N = sc.nextLine().replaceAll("\\[|\\]","");
        String[] s=N.split(", ");
        int E,O;
        if(s.length==1&&s[0].isEmpty()){
             E=O=0;
        }else{
        int[] arr = new int[s.length];
            for(int i=0;i<s.length;i++){
                arr[i]=Integer.parseInt(s[i]);
            }
          int[] sum=new Sum_Even_Odd().sumEvenOdd(arr);
            E=sum[0];
            O=sum[1];
        }
        
        System.out.print("["+E+", "+O+"]");
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}