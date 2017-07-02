package com.hrsolutionbyviraj.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.Map.Entry;
import java.util.regex.*;

public class SherlockValidString {

    static String isValid(String s){
        // Complete this function
        HashMap<Character,Integer> allFrequencies = new HashMap<Character,Integer>();
        
        char lastchar = '$';
        int last_char_count = 0;
        for(char c : s.toCharArray())
        {
            if(c != lastchar)
            {
                Integer last_val = allFrequencies.get(new Character(lastchar));
            	if(last_val != null)
    			{
            		allFrequencies.put(lastchar, last_char_count+last_val);
    			}
            	else
            	{
            		allFrequencies.put(lastchar, last_char_count);
            	}
                lastchar = c;
                last_char_count = 1;
            }
            else
            {
                last_char_count++;
            }
        }
        Integer last_val = allFrequencies.get(new Character(lastchar));
        if(last_val != null)
        {
            allFrequencies.put(lastchar, last_char_count+last_val);
        }
        else
        {
            allFrequencies.put(lastchar, last_char_count);
        }

        allFrequencies.remove('$');
        int first_no = -1;
        int first_no_count = 0;
        int second_no = -1;
        int second_no_count = 0;
        Set<Entry<Character,Integer>> literator = allFrequencies.entrySet(); 
        for(Entry<Character,Integer> lEntry : literator)
        {
            Integer i = lEntry.getValue();
            if(first_no == -1)
            {
                first_no = i;
            }
            
            if(i != first_no && second_no == -1)
            {
                second_no = i;
            }
            
            if(i == first_no)
            {
                first_no_count++;
            }
            else if(i == second_no)
            {
                second_no_count++;
            }
            else
            {
                return "NO";
            }
            
        }
        if(second_no == -1)
        {
        	return "YES";
        }
        
        if(first_no_count > second_no_count)
        {
            if(second_no_count != 1)
            {
                return "NO";
            }
            else if(Math.abs(first_no - second_no) == 1)
            {
                return "YES";
            }
            else
            {
                return "YES";
            }
        }
        else if(first_no_count == second_no_count && first_no_count == 1)
        {
            return "YES";
        }
        else
        {
            if(first_no_count != 1)
            {
                return "NO";
            }
            else if(Math.abs(first_no - second_no) == 1)
            {
                return "YES";
            }
            else
            {
                return "YES";
            }
        }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}

