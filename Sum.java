import java.io.*;
import java.util.*;

class Sum{
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter lower value:");
        int lower= sc.nextInt();
        System.out.println("Enter upper value:");
        int upper= sc.nextInt();
 
        while(lower>upper){
            System.out.println("Wrong Input Enter the value again:");
            System.out.println("Enter lower value:");
            lower=sc.nextInt();
            System.out.println("Enter upper value:");
            upper=sc.nextInt();
        }
        
        System.out.println("The sum b/w the range is : " + calculateTheSum(lower, upper));
    }
    
    public static int calculateTheSum(int lower, int higher){
       
        int sum = 0;
        
        for(int i = lower; i <=higher; i++)
            sum += i;
        return sum;
    }
}