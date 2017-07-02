package com.hrsolutionbyviraj.warmup;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinMaxSum {

    
    public static String minMaxOpt(int[] input)
    {
        int min = 0;
        int max = 0;
        
        long minSum = 0;
        long maxSum = 0;
        
        
        //Find min and max
        for(int i = 0 ; i < input.length ; i++)
        {
            int t = input[i];
            boolean minFound = false;
            boolean maxFound = false;
            minSum += t;
            maxSum += t;
            
            int lastMin = min;
            int lastMax = max;
            
            if(min == 0 || t < min)
            {
                min  = t;
                minFound = true;
            }
            if(max == 0 || t > max)
            {
                max = t;
                maxFound = true;
            }
            if(minFound == true)
            {
                maxSum = maxSum - t;
                maxSum = maxSum + lastMin;
            }
            
            if(maxFound == true)
            {
                minSum = minSum - t;
                minSum = minSum + lastMax;
            }
        }
        
        return minSum + " " +maxSum;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        System.out.println(minMaxOpt(arr));
    }
}

