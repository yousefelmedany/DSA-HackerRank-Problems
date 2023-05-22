import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Array_average_value {
    
	public double average(int[] array) {
        Double av=0.0;
        for(int i=0;i<array.length;i++){
            av+=array[i];
        }
        return av/array.length;
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
            String sin = sc.nextLine().replaceAll("\\[|\\]", "");
            String[] s = sin.split(", ");;
            if (s.length == 1 && s[0].isEmpty()){
             System.out.print(0.0);

            }else {
                int[] arr = new int[s.length];

                for(int i = 0; i < s.length; ++i){
                   arr[i] = Integer.parseInt(s[i]);
            }
                 Double average= new Array_average_value().average(arr);
                        System.out.print(average);

            }
       
           
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}