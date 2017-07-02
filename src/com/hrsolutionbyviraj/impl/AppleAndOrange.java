package com.hrsolutionbyviraj.impl;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AppleAndOrange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        int appleOnHouse = 0;
        int orangeOnHouse = 0;
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        
        //a + apple[m] and
        
        for(int apple_i=0; apple_i < m; apple_i++){
            int distance = a + apple[apple_i];
            if(distance >= s && distance <= t)
            {
                appleOnHouse++;
            }
        }
        
        for(int orange_i=0; orange_i < n; orange_i++){
            int distance = b + orange[orange_i];
            if(distance >= s && distance <= t)
            {
                orangeOnHouse++;
            }
        }
        System.out.println(appleOnHouse);
        System.out.println(orangeOnHouse);
    }
}

