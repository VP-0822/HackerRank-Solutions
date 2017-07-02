package com.hrsolutionbyviraj.impl;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BetweenTwoSets {

    static int getTotalX(int[] a, int[] b){
        // Complete this function
        int m  = a.length;
        int n = b.length;
        
        int totalX = 0;
        
        int largest_a = largestNumber(a);
        int smallest_b = smallestNumber(b);
        
        int Count = 0;
        for(int x = largest_a ; x<= smallest_b ; x++)
        {
            int count_a = 0;
            for(int a_num : a)
            {
                if(x % a_num ==0)
                {
                    count_a++;
                }
            }
            int count_b = 0;
            for(int b_num : b)
            {
                if(b_num % x== 0)
                {
                    count_b++;
                }
            }
            
            if(count_a == a.length && count_b == b.length)
            {
                totalX++;
                
            }
        }
        
        return totalX;
        
    }
    
    static int largestNumber(int[] a)
    {
        int max = 0;
        for(int m : a)
        {
            if(m > max)
            {
                max = m;
            }
        }
        return max;
    }

    static int smallestNumber(int[] a)
    {
        int min = 0;
        for(int m = 0; m<a.length; m++)
        {
            int num = a[m];
            if(m==0)
            {
                min = num;
            }
            if(num < min)
            {
                min = num;
            }
        }
        return min;
    }

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
    }
}

