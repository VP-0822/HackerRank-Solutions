package com.hrsolutionbyviraj.warmup;
import java.io.*;
import java.util.*;

public class PlusMinus {

    public static double[] fraction(int size, int[] ar)
    {
        
        int countPositive = 0;
        int countNegative = 0;
        int countZero = 0;
        
        for(int i : ar)
        {
            if( i > 0)
            {
                countPositive++;
            }
            else if(i < 0)
            {
                countNegative++;
            }
            else
            {
                countZero++;
            }
        }
        
        return new double[] {new Float(countPositive)/size,new Float(countNegative)/size,new Float(countZero)/size};
        
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        double[] results = fraction(n,ar);
        
        for (double d : results)
        {
            System.out.println(d);
        }
    }
}
