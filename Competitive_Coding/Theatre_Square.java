package Competitive_Coding;
import java.util.Scanner;

public class Theatre_Square
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        long n = reader.nextInt();
        long m = reader.nextInt();
        long a = reader.nextInt();
        
        long countn=n/a;
	    long countm=m/a;
        
        if(n%a != 0)
            ++countn;
            
        if(m%a != 0)
            ++countm;
            
        System.out.println(countn*countm);
    }
}
