package com.hrsolutionbyviraj.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RichieRich {

    static String richieRich(String s, int n, int k){
        // Complete this function
        
        int[] mismatchIndex = new int[n];
        Arrays.fill(mismatchIndex,-1);
        int countMismatch = 0;
        for(int i =0,j=s.length()-1 ; i < j ;  i++,j-- )
        {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if(start == end)
            {
                continue;
            }
            
            if(k <= 0)
            {
                return "-1";
            }
            
            //else compare and change numbers
            
            int istart = Integer.parseInt(start + "");
            int iend = Integer.parseInt(end+"");
            
            if(istart > iend)
            {
                char[] charArrayOfString = s.toCharArray();
                charArrayOfString[j] = start;
                s = new String(charArrayOfString);
                k--;
                mismatchIndex[countMismatch++] = i;
            }
            else
            {
                char[] charArrayOfString = s.toCharArray();
                charArrayOfString[i] = end;
                s = new String(charArrayOfString);
                k--;
                mismatchIndex[countMismatch++] = i;
            }
           
        }
        if(k == 0)
        {
            return s;
        }
        char[] charArrayOfString = s.toCharArray();
        for(int mismatch : mismatchIndex)
        {
        	if(mismatch == -1)
        	{
        		continue;
        	}
            int startIndex = mismatch;
            int endIndex = s.length()-mismatch-1;
            
            if(startIndex < 0 || endIndex <= 0)
            {
            	break;
            }
            
            if(charArrayOfString[startIndex] == '9')
            {
            	continue;
            }
            
            charArrayOfString[startIndex] = '9';
            charArrayOfString[endIndex] = '9';
            s = new String(charArrayOfString);
            k--;
            
            if(k <= 0)
            {
                break;
            }
            
        }
        
        if(n == 1 && k >=1)
        {
        	return "9";
        }
        
        if(k > 1)
        {        	
        	for(int y = 0 ; y < s.length() ; y ++)
        	{
        		char targetChar = s.charAt(y);
        		if(targetChar == '9')
        		{
        			continue;
        		}
        		
        		int startIndex = y;
                int endIndex = s.length()-y-1;
                
                if(startIndex < 0 || endIndex <= 0)
                {
                	break;
                }
                if(charArrayOfString[startIndex] != '9')
                {                	
                	charArrayOfString[startIndex] = '9';
                	k--;
                }
                
                if(charArrayOfString[endIndex] != '9')
                {                	
                	charArrayOfString[endIndex] = '9';
                	k--;
                }
                s = new String(charArrayOfString);
                if(k <= 1)
                {
                    break;
                }
        	}
        }

        if(n % 2 != 0 && k == 1)
        {
        	int index = (n /2);
        	
        	charArrayOfString[index] = '9';
            s = new String(charArrayOfString);
            k--;
        }
        
        return s;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
    }
}

