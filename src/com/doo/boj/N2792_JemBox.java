package com.doo.boj;

import java.util.Scanner;

public class N2792_JemBox {
	
	static long N, result = 0, h = 0, l = 1;
	static int M, i;
	static long[] jem;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		M = sc.nextInt();
		jem = new long[M];
		
		for (i = 0; i < N; i++) {
			jem[i] = sc.nextLong();
			if (h < jem[i]) h = jem[i];
		}
		
		System.out.println(result);
	}
	
	private static void bs(long mid) {
		long sum = 0;
		
		while (h >= l) {
			for (i = 0; i < N; i++) {
				
			}
		}
	}
}
