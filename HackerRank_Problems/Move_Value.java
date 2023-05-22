import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Move_Value {
    public int[] moveValue(int[] array, int value) {
        int[] rev=new int[array.length];
        int j=0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=value){
                rev[j]=array[i];
                j++;
            }
        }
        for(int h=j;h<array.length;h++){
            rev[h]=value;
        }
            
            
        return rev;
    }
    public static void main(String[] args) {
 Scanner sc =new Scanner(System.in);
        String N = sc.nextLine().replaceAll("\\[|\\]","");
        int n=sc.nextInt();
        String[] s=N.split(", ");    
        int[] arr=new int[s.length];
        if(s.length==1&&s[0].isEmpty()){
            System.out.print("[]");
        }
        else{
            for(int i=0;i<s.length;i++){
            arr[i]=Integer.parseInt(s[i]);}
        System.out.println(Arrays.toString(new Move_Value().moveValue(arr,n)));
            }
    }}