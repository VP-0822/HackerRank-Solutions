package com.hrsolutionbyviraj.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        StringBuffer unique = new StringBuffer();
        
        for(char c : s.toCharArray())
        {
            if(unique.indexOf("" + c) != -1)
            {
                continue;
            }
            unique.append(c);
        }
        int maxLength = 0;
        for(char c : unique.toString().toCharArray())
        {
            for(char c2 : unique.toString().toCharArray())
            {
                if(c == c2)
                {
                    continue;
                }
                StringBuffer lNewString = new StringBuffer();
                char lastChar = '&';
                int count = 0;
                for(char t : s.toCharArray())
                {
                    if(t == c || t == c2)
                    {
                        lNewString.append(t);
                    }
                    else
                    {
                        continue;
                    }
                    if(t != lastChar)
                    {
                        lastChar = t;
                        count++;
                    }
                }
                
                if(count == lNewString.length() && lNewString.length() > maxLength)
                {
                    maxLength = lNewString.length();
                }
                
            }
        }
        System.out.println(maxLength);
    }
}
