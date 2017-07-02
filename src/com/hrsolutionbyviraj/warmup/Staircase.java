package com.hrsolutionbyviraj.warmup;

import java.io.*;
import java.util.*;

public class Staircase {

    public static void printStairCase(int size)
    {
        for(int i=0;i < size;i++)
        {
            int spaceCount = i +1;
            while(size-spaceCount > 0)
            {   
                spaceCount++;
                System.out.print(' ');
            }
            int count = 0;
            while(count < i+1)
            {
                System.out.print('#'); 
                count++;
            }
            System.out.println();
        }
        
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        printStairCase(n);
    }
}
