package com.doo.boj;

import java.util.Scanner;

public class N10166_Stand {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int D1 = sc.nextInt();
		int D2 = sc.nextInt();
		boolean[] map = new boolean[36001];
		initMap(map);
		
		for (int i = D1; i <= D2; i++) {
			for (int j = 1; j <= i; j++) {
				map[(36000 / i) * j] = true;
			}
		}
		
		int result = 0;
		for (int i = 1; i < map.length; i++) {
			if (map[i]) result++;
		}
		
		System.out.println(result);
	}
	
	private static void initMap(boolean[] map) {
		for (int i = 0; i < map.length; i++) {
			map[i] = false;
		}
	}
}
