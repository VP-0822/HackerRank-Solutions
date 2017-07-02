package com.hrsolutionbyviraj.dp;

import java.io.*;
import java.util.*;

/**
 * Longest Increasing Subsequence Problem
 *
 */
public class LIS {
    
    public static int longestSeq2(int length,int[] inputArr)
	{
		int[] result = new int[length];
		int max = 0;
		for(int i =0 ;i<length;i++)
		{
			result[i] = 1;
			for(int j =0 ; j<i;j++)
			{
				if(inputArr[i] > inputArr[j])
				{
					result[i] = Math.max(result[i], result[j]+1);
				}
			}
			if(result[i] > max)
			{
				max= result[i];
			}
			
		}
		
		return max;
	}
    
    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
 
    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
 
        return len;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int arr[] = new int[length];
        for(int i = 0 ; i < length ; i++)
        {
            arr[i] = sc.nextInt();
        }
        
        //System.out.print(longestSeq2(length,arr));
        System.out.print(LongestIncreasingSubsequenceLength(arr,length));
    }
}