package com.hrsolutionbyviraj.impl;

import java.io.*;
import java.util.*;

public class EmasSupercomputer {
    
    static int area(int n, int m, char[][] input,int method)
    {
        int[][] flag_arr = new int[n][m];
        for(int p = 0 ; p < n ; p++)
        {        	
        	Arrays.fill(flag_arr[p],0);
        }
        int iIndex = (n+1)/2 -1;
        int jIndex = (m+1)/2 -1;
		int sx =0;
		int sy =0;
		int dsx = 0;
		int dsy = 0;
		if(method == 1)
		{			
			dsy = 1;
		}
		else
		{
			dsy = -1;
		}
		int limit = n*m;
        ArrayList<Integer> return_val = new ArrayList<Integer>();
		for(int k = 0; k < limit ; k++)
		{
			if(((-n/2 <= sx)  && (sx <= n/2)) && ((-m/2 <= sy) && (sy <= m/2)))
			{
			    //do stuff
				int i_index = iIndex + sx;
                int j_index = jIndex + sy;
                
                char check =  input[i_index][j_index];
                
                if(check == 'B')
                {
                	if(method == 1)
                	{                		
                		if(sx== sy || (sx <0 && (sx == -sy)) ||(sx >0 && (sx == -sy)) || (sx>0 && (sx == 1-sy)))
                		{
                			int temp = dsx;
                			dsx = dsy;
                			dsy = -temp;
                		}
                	}
                	else
                	{
                		if(sx== sy || (sx <0 && (sx == -sy)) || (sx>0 && (sx == 1-sy)))
                		{
                			int temp = dsx;
                			dsx = -dsy;
                			dsy = temp;
                		}
                	}
        			sx = sx + dsx;
        			sy = sy + dsy;
        			
                    continue;
                }
                
                
                //edge element then continue
                if(i_index == 0 || i_index == n-1 || j_index == 0 || j_index == m-1)
                {
                	if(method == 1)
                	{                		
                		if(sx== sy || (sx <0 && (sx == -sy)) ||(sx >0 && (sx == -sy)) || (sx>0 && (sx == 1-sy)))
                		{
                			int temp = dsx;
                			dsx = dsy;
                			dsy = -temp;
                		}
                	}
                	else
                	{
                		if(sx== sy || (sx <0 && (sx == -sy)) || (sx>0 && (sx == 1-sy)))
                		{
                			int temp = dsx;
                			dsx = -dsy;
                			dsy = temp;
                		}
                	}
        			sx = sx + dsx;
        			sy = sy + dsy;
        			
                    continue;
                }
                boolean found = false;
                int iterator = 1;
                int temparea = 1;
                do
                {
                    if(i_index-iterator < 0 || i_index+iterator >= n || j_index-iterator <0 || j_index+iterator >=m)
                    {
                        break;
                    }
                    found = false;
                    //top 
                    if(input[i_index-iterator][j_index] == 'G' && flag_arr[i_index-iterator][j_index] == 0)
                    {
                        //bottom
                        if(input[i_index+iterator][j_index] == 'G' && flag_arr[i_index+iterator][j_index] == 0)
                        {
                            //left
                            if(input[i_index][j_index - iterator] == 'G' && flag_arr[i_index][j_index-iterator] == 0)
                            {
                                //right
                                if(input[i_index][j_index+iterator] == 'G' && flag_arr[i_index][j_index+iterator] == 0)
                                {
                                    
                                    flag_arr[i_index-iterator][j_index] = 1;
                                    flag_arr[i_index+iterator][j_index] = 1;
                                    flag_arr[i_index][j_index-iterator] = 1;
                                    flag_arr[i_index][j_index+iterator] = 1;
                                    flag_arr[i_index][j_index] = 1;
                                    temparea = 1 + (4 * iterator);
                                    found = true;
                                    iterator++;
                                }
                            }
                        }
                    }
                }
                while(found == true);
               
                return_val.add(temparea);
			}
			if(method == 1)
        	{                		
        		if(sx== sy || (sx <0 && (sx == -sy)) ||(sx >0 && (sx == -sy)) || (sx>0 && (sx == 1-sy)))
        		{
        			int temp = dsx;
        			dsx = dsy;
        			dsy = -temp;
        		}
        	}
        	else
        	{
        		if(sx== sy || (sx <0 && (sx == -sy)) || (sx>0 && (sx == 1-sy)))
        		{
        			int temp = dsx;
        			dsx = -dsy;
        			dsy = temp;
        		}
        	}
			sx = sx + dsx;
			sy = sy + dsy;
		}
        int max_area = 1;
        int max_area2 = 1;
        
        for(Integer area : return_val)
        {
            if(area >= max_area)
            {
                max_area2 = max_area;
                max_area = area;
            }
            else if(area >= max_area2)
            {
            	max_area2 = area;
            }
        }
        
        return max_area * max_area2;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] input = new char[n][m];
        for(int i_n =0;i_n < n;i_n++)
        {
            String str = sc.nextLine();
            char[] in_char = str.toCharArray();
            int i_m = 0;
            for(char c : in_char)
            {
                input[i_n][i_m] = c;
                i_m++;
            }
        }
        int max_area = area(n,m,input,1);
        if(area(n,m,input,2) > max_area)
        {
            max_area = area(n,m,input,2);
        }
        
        System.out.println(max_area);
    }
}