package com.hrsolutionbyviraj.impl;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MigratoryBirds {

    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        int type1 = 0;
        int type2 = 0;
        int type3 = 0;
        int type4 = 0;
        int type5 = 0;
        
        for(int num : ar)
        {
            if(num == 1)
            {
                type1++;
            }
            else if(num == 2)
            {
                type2++;
            }
            else if(num == 3)
            {
                type3++;
            }
            else if(num == 4)
            {
                type4++;
            }
            else
            {
                type5++;
            }
        }
        int num[] = new int[5];
        num[0] = type1;
        num[1] = type2;
        num[2] = type3;
        num[3] = type4;
        num[4] = type5;
        int maxIndex = 0;
        int maxNumber = 0;
        for(int num_max = 0; num_max < num.length; num_max++)
        {
            if(num[num_max] > maxNumber)
            {
                maxIndex = num_max +1;
                maxNumber = num[num_max];
            }
        }
        
        return maxIndex;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}

