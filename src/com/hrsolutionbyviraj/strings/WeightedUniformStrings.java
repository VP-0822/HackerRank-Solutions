package com.hrsolutionbyviraj.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Map.Entry;

public class WeightedUniformStrings {

    public static void main(String[] args) {
        int sub_value = 96;
        
        
        Scanner in = new Scanner(System.in);
        String s = in.next();
        ArrayList<Integer> allcombinations = new ArrayList<Integer>();
        
        //get weights
        char lastchar = '#';
        int last_char_count = 0;
        
        for(char c : s.toCharArray())
        {
        	int ascii2 = (int)c; 
            if(c != lastchar)
            {
                lastchar = c;
                last_char_count = 1;
                allcombinations.add(last_char_count*(ascii2-sub_value));
            }
            else
            {
                last_char_count++;
                allcombinations.add(last_char_count*(ascii2-sub_value));
            }
        }
        int lastcharascii = (int) lastchar;
        allcombinations.add(last_char_count*(lastcharascii-sub_value));
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            // your code goes here
            boolean returnval = allcombinations.contains(new Integer(x));
            if(returnval)
            {
                System.out.println("Yes");    
            }
            else
            {
                System.out.println("No");    
            }
            
        }
    }
}
