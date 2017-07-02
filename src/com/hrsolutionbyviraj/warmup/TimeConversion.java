package com.hrsolutionbyviraj.warmup;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TimeConversion {

    static String timeConversion(String s) {
        // Complete this function
        String[] arrs = s.split(":");
        String dayNight = arrs[2].substring(2, 4);
        String lSec = arrs[2].substring(0,2);
        long hr =0;
        String lstrHr = arrs[0];
            
        long linput = Long.parseLong(lstrHr);
        if(dayNight.equalsIgnoreCase("AM") == true)
        {
            if(linput == 12)
            {
                return "00" + ":" + arrs[1] + ":" + lSec;   
            }
            return s.substring(0, s.length() -2);
        }
        else
        {
            if(linput == 12)
            {
                return s.substring(0, s.length() -2);
            }
            
            hr = linput + 12;
            String lreturnHR = "";
            if(hr < 10 )
            {
                lreturnHR = "0" + hr;
            }
            else
            {
                lreturnHR = hr + "";
            }
            String lreturn = lreturnHR + ":" +arrs[1]+":" + lSec;
            return lreturn;
        }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}

