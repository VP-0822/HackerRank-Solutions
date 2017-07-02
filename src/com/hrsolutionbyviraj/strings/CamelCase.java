package com.hrsolutionbyviraj.strings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int no_of_words = 1;
        
        for(char c : s.toCharArray())
        {
            int ascii = (int) c;
            if(c < 97)
            {
                no_of_words++;
            }
        }
        System.out.println(no_of_words);
        
    }
}
