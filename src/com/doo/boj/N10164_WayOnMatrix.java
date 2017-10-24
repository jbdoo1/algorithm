package com.doo.boj;

import java.util.Scanner;

public class N10164_WayOnMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
	
		int result = 0;
		int k = K;
		if (K == 0) k = N * M;
		
		int n = (k / M) + 1;
		if (k % M == 0) {
			n--;
		}
		int m = k % M;
		if (m == 0) {
			m = M;
		}
		k = n * m;
		result = dp(k, n, m);
		
		if (K != 0) {
			n = (((N * M) - K) / M) + 1;
			m = M - m + 1;
			k = n * m;
			result = result * dp(k, n, m); 
		}
		
		System.out.println(result);
	}
	
	private static int dp(int k, int n, int m) {
		// 1 row or 1 column -> 1
		if (n == 1 || m == 1) {
			return 1;
		}
		// 0,0 이면 1
		if (k == 1) {
			//map[0][0] = 1;
			return 1;
		}
		// 윗변 또는 좌변이면 1
		if ((k <= m) || (k % m) == 1) {
			//map[1][(k % map[1].length) - 1] = 1;
			return 1;
		}
		
		return dp(k - 1, n, m) + dp(k - m, n, m);
	}
}
