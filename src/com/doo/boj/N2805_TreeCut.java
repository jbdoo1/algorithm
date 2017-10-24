package com.doo.boj;

import java.util.Scanner;

public class N2805_TreeCut {
	
	static int N, i;
	static long M, result, h, l = 1;
	static long[] tree;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextLong();
		tree = new long[N];
		
		for (i = 0; i < N; i++) {
			tree[i] = sc.nextLong();
			if (h < tree[i]) h = tree[i];
		}
		
		bs((l + h) / 2);
		
		System.out.println(result);
	}
	
	private static void bs(long mid) {
		
		long sum = 0;
		
		while (h >= l) {
			
			for (i = 0; i < N; i++)
			{
				if (tree[i] > mid) sum += (tree[i] - mid);
			}
			
			if (sum >= M) {
				result = mid;
				l = ++mid;
				bs((l + h) / 2);
			}
			else {
				h = --mid;
				bs((l + h) / 2);
			}
		}
	}
}
