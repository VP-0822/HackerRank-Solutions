package com.hrsolutionbyviraj.warmup;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int n, int[] ar) {
        int max =0;
        int count = 0;
        
        for(int i : ar)
        {
            if(i > max)
            {
                count = 0;
                max = i;
                count ++;
            }
            else if(i == max)
            {
                count++;
            }
        }
        return count;
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}

