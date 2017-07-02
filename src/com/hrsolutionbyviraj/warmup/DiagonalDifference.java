package com.hrsolutionbyviraj.warmup;

import java.io.*;
import java.util.*;

public class DiagonalDifference {

    public static int diagonalDiff (int size,int[][] inputMatrix)
    {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        int markerForSecondary = size-1;
        //i row, j=column
        for(int i=0,j=0;j<size && i<size;j++)
        {
            //if i and j are same then add in primary if i and j are 
            if(i == j)
            {
                primaryDiagonalSum += inputMatrix[i][j];
            }
            //if column is equal to marker for secondary, then sum in secondary.
            if(j == markerForSecondary)
            {
                secondaryDiagonalSum += inputMatrix[i][j];
                //decrement marker for secondary.
                markerForSecondary--;
            }
            
            if(j == size-1)
            {
                //increment row count
                i++;
                
                //reset column count
                j=-1;
            }
            
        }
        
        return Math.abs(primaryDiagonalSum-secondaryDiagonalSum);
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for(int ar_i = 0,j=0; ar_i < n && j< n; ar_i++){
            matrix[j][ar_i] = in.nextInt();
            if(ar_i == n-1)
            {
                //increment j
                j++;
                //set i,column to -1
                ar_i =-1;
            }
        }
        
        System.out.print(diagonalDiff(n,matrix));
        
        
    }
}