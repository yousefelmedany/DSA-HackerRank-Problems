import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.Point;



interface IPlayersFinder {

    /**
     * Search for players locations at the given photo
     * @param photo
     *     Two dimension array of photo contents
     *     Will contain between 1 and 50 elements, inclusive
     * @param team
     *     Identifier of the team
     * @param threshold
     *     Minimum area for an element
     *     Will be between 1 and 10000, inclusive
     * @return
     *     Array of players locations of the given team
     */
    java.awt.Point[] findPlayers(String[] photo, int team, int threshold);
}


public class PlayersFinder implements IPlayersFinder{
    public static int x;
    public static int y;
    public static int X;
    public static int Y;
       public  Point[] findPlayers(String[] photo, int team, int threshold){
       Point[] back=new Point[100];
        int count1=0;
        int count2;
        char b = Integer.toString(team).charAt(0);
           int[] index=new int [5];
           char[][] arr=new char[photo.length][];
           for(int i=0;i<photo.length;i++){
               arr[i]=photo[i].toCharArray();
           }

           for(int i=0;i<arr.length;i++){
               for(int j=0;j<arr[0].length;j++){
                   if(arr[i][j]==b){
                       x=100;y=100;
                       X=0;Y=0;
                       count2= new PlayersFinder().findchain(arr, team, i, j);
                       if (count2*4>=threshold){
                           if(count2==1) {
                               back[count1]=new Point();
                               back[count1].y=2*x+1;
                               back[count1].x=2*y+1;
                               count1++;
                           }else {
                        	    back[count1]=new Point();
                               back[count1].y=x+X+1;
                               back[count1].x=y+Y+1;
                                  count1++;
                           }
                  
                       }
                       
                   }
                   
               }
           }
           return back;
       }
       
    public int findchain(char[][] grid,int team,int i,int j){
         char b = Integer.toString(team).charAt(0);
        try {
         if (i<0||i==grid.length||j<0||j==grid[0].length|| grid[i][j]!=b){
            return 0;
        }
        grid[i][j]='x';
        if(i<x) {
            x=i;
        }else if(i>X) {
            X=i;
        }
        if(j<y) {
            y=j;
        }else if(j>Y) {
            Y=j;
        } 
        return 1+findchain(grid,team,i+1,j)+findchain(grid,team,i-1,j)+findchain(grid,team,i,j+1)+findchain(grid,team,i,j-1);}
        catch(Exception e) {
        	return 0;}
        }

    /*
       Implement your class here
    */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         String N = sc.nextLine();
        String[] s=N.split(", ");    
        int[] arr=new int[s.length];
        if(s.length==1&&s[0].isEmpty()){
            System.out.print("[]");
        }
        else{
            for(int i=0;i<s.length;i++){
            arr[i]=Integer.parseInt(s[i]);}
        int n,m,team,min;
        n=arr[0];
        m=arr[1];
        String[] photo=new String[n];
        for(int i=0;i<n;i++){
            photo[i]=sc.next();
        }
        team=sc.nextInt(); 
        min=sc.nextInt();
       int l=0;
        Point[] result=new Point[100]; 
            result=    new PlayersFinder().findPlayers(photo,team,min);
        try{
           while(true){
                       result[l].equals(null);
                       l++;}
          
          }
    catch(NullPointerException e){
    }
               Point[] finaal=new Point[l];
            for(int i=0;i<l;i++){
                finaal[i]=result[i];
            }

                Arrays.sort(finaal,Comparator.comparing(Point::getX).thenComparing(Point::getY));
             System.out.print("[");
            for(int i=0;i<l;i++){
            System.out.print("("+(int)finaal[i].getX()+", "+(int)finaal[i].getY()+")");
            if(i!=l-1)
                System.out.print(", ");
            
            
        }
         System.out.println("]");

       
        
        }
        
}
}


