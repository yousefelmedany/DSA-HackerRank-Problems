import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Transpose_2d_array {
    public int[][] transpose(int[][] array) {
        int temp=0;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                temp=array[i][j];
                array[i][j]=array[j][i];
                array[j][i]=temp;
            }            
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String N= sc.nextLine().replaceAll("\\[|\\]","");
        String[] s=N.split(", ");
        if(s.length==1&&s[0].isEmpty()){
             System.out.print("[[]]");
        }else{
            
            
            int z=(int)Math.sqrt(s.length);
            int h=0;
        int[][] arr = new int[z][z];
            for(int i=0;i<z;i++){
                for(int j=0; j<z;j++){
                    arr[i][j]=Integer.parseInt(s[h]);
                        h++;
                }
            }
         new Transpose_2d_array().transpose(arr);
         int y=0; 
         System.out.print("[");
         for(int[] back:arr) {
             System.out.print(Arrays.toString(back));
             y++;
             if (y<arr.length) {
             System.out.print(", ");
             }
             
             
         }
         System.out.print("]");
        }
          /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}