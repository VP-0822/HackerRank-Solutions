package com.hrsolutionbyviraj.impl;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GradingStudents {

	static int[] solve(int[] grades) {
		int[] result = new int[grades.length];
		for (int i = 0; i < grades.length; i++) {
			int num = grades[i];
			if (num < 38)
				result[i] = num;
			else if (num % 5 >= 3)
				result[i] = num + (5 - (num % 5));
			else
				result[i] = num;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i < n; grades_i++) {
			grades[grades_i] = in.nextInt();
		}
		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
	}
}