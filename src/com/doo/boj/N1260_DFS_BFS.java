package com.doo.boj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class N1260_DFS_BFS {

	static int N, M, V;
	static boolean[][] adjacencyMatrix;
	static boolean[] visit;
	static int[] dfsResult;
	static int[] bfsResult;
	static int dfsResultIndex = 0, bfsResultIndex = 0;
	
	public static void main(final String[] args) {
		
		try {
			//final Scanner sc = new Scanner(System.in);
			final Scanner sc = new Scanner(new File("/Users/jeonbyeongdoo/Documents/workspace/algorithm/resources/N1260_SampleData.txt"));
			
			N = sc.nextInt();
			M = sc.nextInt();
			V = sc.nextInt();
			adjacencyMatrix = new boolean[N + 1][N + 1];
			visit = new boolean[N + 1];
			dfsResult = new int[N];
			bfsResult = new int[N];
			
			int s, t;
			for (int i = 0; i < M; i++) {
				s = sc.nextInt();
				t = sc.nextInt();
				adjacencyMatrix[s][t] = true;
				adjacencyMatrix[t][s] = true;
			}
			
			dfs(V);
			visit = new boolean[N + 1];
			bfs(V);
			
			for (int i = 0; i < dfsResult.length; i++) {
				System.out.print(dfsResult[i] + " ");
			}
			System.out.println();
			for (int i = 0; i < bfsResult.length; i++) {
				System.out.print(bfsResult[i] + " ");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dfs(final int n) {
		final Stack<Integer> stack = new Stack<Integer>();
		int current;
		stack.push(n);
		
		final List<Integer> minArray = new ArrayList<Integer>();
		while(!stack.isEmpty()) {
			current = stack.pop();
			if (visit[current]) continue;
			visit[current] = true;
			
			for (int i = 1; i <= N; i++) {
				if (adjacencyMatrix[current][i] && !visit[i]) {
					minArray.add(i);
				}
			}
			Arrays.sort(minArray.toArray());
			for (int i = minArray.size() - 1; i >= 0; i--) {
				stack.push(minArray.get(i));
			}
			dfsResult[dfsResultIndex++] = current;
			minArray.clear();
		}
	}
	
	public static void bfs(final int n) {
		final Queue<Integer> queue = new LinkedList<Integer>();
		int current;
		queue.add(n);
		
		final List<Integer> minArray = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			current = queue.poll();
			if (visit[current]) continue;
			visit[current] = true;
			
			for (int i = 1; i <= N; i++) {
				if (adjacencyMatrix[current][i] && !visit[i]) {
					minArray.add(i);
				}
			}
			Arrays.sort(minArray.toArray());
			for (int i = 0; i < minArray.size(); i++) {
				queue.add(minArray.get(i));
			}
			bfsResult[bfsResultIndex++] = current;
			minArray.clear();
		}
	}
}
