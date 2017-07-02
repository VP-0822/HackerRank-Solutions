package com.hrsolutionbyviraj.impl;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ClimbingTheLeaderboard {
    public static int last_alice_rank_index = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        // your code goes here
        
        int rank = 1;
        int last_score = scores[0];
        int alice_level_high_low = m - 1;
        int[] aliceranks = new int[m];
        Arrays.fill(aliceranks, -1);
        
        for(int i = 0 ; i < scores.length && alice_level_high_low >=0 ; )
        {
        	int score = scores[i];
        	if(score < last_score)
        	{
        		rank++;
        		last_score = score;
        	}
        	if(alice[alice_level_high_low] >= score)
        	{
        		aliceranks[alice_level_high_low] = rank;
        		alice_level_high_low--;
                continue;
        	}
            i++;
        }
        
        for(int j = m-1 ; j >=0 ; j--)
        {            
        	if(aliceranks[j] == -1)
        	{
                aliceranks[j] = rank + 1;    
        	}
        }
        
        for(int i : aliceranks)
        {
        	System.out.println(i);
        }
        
        
    }
    
    static int rank_set(int input_score,LinkedHashSet<Integer> leaderboard)
    {
        int rank = 0;
        for(Integer score : leaderboard)
        {
            if(input_score >= score)
            {
                return ++rank;
            }
            rank++;
        }
        return ++rank;
    }
    
    static int rank(int input_score,int[] leaderboard)
    {
        int rank = 1;
        int last_score = leaderboard[0];
        for(int i = 0; i <= last_alice_rank_index ;i++)
        {
            int score = leaderboard[i];
            if(score < last_score)
            {
                rank++;
                last_score = score;
            }
            if(input_score >= score)
            {
                last_alice_rank_index = i;
                return rank;
            }
        }
        return ++rank;
    }
}
