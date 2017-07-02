package com.hrsolutionbyviraj.impl;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Kangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        
        int ahead = 0;
        int aheadv = 0;
        int behind = 0;
        int behindv = 0;
        if(x1 > x2)
        {
            ahead = x1;
            aheadv= v1;
            behind= x2;
            behindv = v2;
        }
        else if(x1 < x2)
        {
            ahead = x2;
            aheadv = v2;
            behind = x1;
            behindv = v1;
        }
        else if(v1 != v2)
        {
            return "NO";
        }
        else
        {
            return "YES";
        }
        
        if(aheadv > behindv)
        {
            return "NO";
        }
        
        int behindsum = behind + behindv;
        int aheadsum = ahead + aheadv;
        
        while(behindsum < aheadsum)
        {
            behindsum += behindv;
            aheadsum += aheadv;
        }
        
        if(behindsum == aheadsum)
        {
            return "YES";
        }
        return "NO";
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
