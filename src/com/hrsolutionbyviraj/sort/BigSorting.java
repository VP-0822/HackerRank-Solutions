package com.hrsolutionbyviraj.sort;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Uncomment quicksort method for using quicksort.

public class BigSorting {
    static BigInteger[] unsortedlong = null;
    static BigInteger[] tempunsortedlong = null;
//    static void quicksort(int lowerindex, int higherindex)
//    {
//    	if (unsortedlong == null || unsortedlong.length == 0)
//			return;
// 
//		if (lowerindex >= higherindex)
//			return;
//    	
//        int i = lowerindex;
//        int j = higherindex;
//        //find middle index
//        int middle = lowerindex + (higherindex - lowerindex)/2;
//        //take middle element as pivot
//        BigInteger pivot = unsortedlong[middle];
//        //First sort elements around pivot,element less than pivot on left and element higher than pivot on right 
//        while(i <= j)
//        {
//            //get element more than pivot element
//            while(unsortedlong[i].compareTo(pivot) == -1)
//            {
//                i++;
//            }
//            //get element less than pivot element
//            while(unsortedlong[j].compareTo(pivot) == 1)
//            {
//                j--;
//            }
//            
//            //swap both numbers
//            if(i <=j)
//            {
//                BigInteger temp = unsortedlong[i];
//                unsortedlong[i] = unsortedlong[j];
//                unsortedlong[j] = temp;
//                //move to next element from left and right.
//                i++;
//                j--;
//            }
//            
//            //If still j is greater than lowerindex, then apply quicksort on array on left of pivot element
//            if(lowerindex < j)
//            {
//                quicksort(lowerindex,j);
//            }
//            
//            //If still i is less than higherindex, then apply quicksort on array on right of pivot element
//            if(i < higherindex)
//            {
//                quicksort(i, higherindex);
//            }
//        }
//            
//    }
    
    public static void sort() {
    	tempunsortedlong = new BigInteger[unsortedlong.length];
        doMergeSort(0, unsortedlong.length - 1);
    }
 
    private static void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private static void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
        	tempunsortedlong[i] = unsortedlong[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
        	if(tempunsortedlong[i].compareTo(tempunsortedlong[j]) == -1 || tempunsortedlong[i].compareTo(tempunsortedlong[j]) == 0 )
            {
            	unsortedlong[k] = tempunsortedlong[i];
                i++;
            } else {
            	unsortedlong[k] = tempunsortedlong[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
        	unsortedlong[k] = tempunsortedlong[i];
            k++;
            i++;
        }
 
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        
        unsortedlong = new BigInteger[n];
        
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsortedlong[unsorted_i] = new BigInteger(unsorted[unsorted_i]);
        }
        
//        quicksort(0,n-1);
        sort();
        
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            System.out.println(unsortedlong[unsorted_i]);
        }
    }
}

