package com.doo.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N2157_Travel {
	
	static int[] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[][] route = new int[K][3];
		d = new int[N];
		List<Integer>[] cityRouteList = new List[N];
		for (int i = 0; i < N; i++) {
			List<Integer> l = new ArrayList<Integer>();
			cityRouteList[i] = l;
		}
		for (int i = 0; i < K; i++) {
			route[i][0] = sc.nextInt();
			route[i][1] = sc.nextInt();
			route[i][2] = sc.nextInt();
			// East->West only
			if (route[i][0] < route[i][1]) {
				cityRouteList[route[i][1] - 1].add(new Integer(i));
			}
		}
		
		System.out.println(dp(N - 1, 0, M, cityRouteList, route));
	}

	private static int dp(int target, int visited, int M, List<Integer>[] cityRouteList, int[][] route) {
		if (visited >= M) {
			return 0;
		} else if (target == 0) {
			return 0;
		}
		
		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < cityRouteList[target].size(); i++) {
			l.add(dp(route[cityRouteList[target].get(i).intValue()][0], visited + 1, M, cityRouteList, route) + route[cityRouteList[target].get(i).intValue()][2]);
		}
		
		return getMax(l);
	}
	
	private static int getMax(List<Integer> l) {
		int result = -1;
		for (int i = 0; i < l.size(); i++) {
			if (result < l.get(i)) {
				result = l.get(i);
			}
		}
		
		return result;
	}
}
