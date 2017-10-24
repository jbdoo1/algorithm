package com.doo.boj;

import java.util.Scanner;

public class N2879_PrettyCoding {

	static int N;
	static int[] wrong = new int[1001];
	static int[] good = new int[1001];
	static int[][] result = new int[10001][1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			wrong[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			good[i] = sc.nextInt();
		}
	}
	
	
}
