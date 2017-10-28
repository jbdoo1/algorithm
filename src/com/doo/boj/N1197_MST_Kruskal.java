package com.doo.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1197_MST_Kruskal {
	
	static int V, E, sumOfCost, eCount;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static int[] arr;
	
	static class Edge implements Comparable<Edge> {
		int a, b, cost;
		
		public Edge(final int a, final int b, final int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
	
	public static void main(final String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			arr = new int[V + 1];
			for (int v = 1; v <= V; v++) {
				arr[v] = v;
			}
			
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			int a, b;
			while (eCount < (V - 1)) {
				final Edge edge = pq.poll();
				a = find(edge.a);
				b = find(edge.b);
				if (a != b) {
					union(a, b);
					sumOfCost += edge.cost;
					eCount++;
				}
			}
			
			System.out.println(sumOfCost);
			
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//			bw.write(sumOfCost);
//			bw.flush();
//			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static int find(final int n) {
		if (arr[n] == n) return n;
		return arr[n] = find(arr[n]);
	}
	
	static void union(final int a, final int b) {
		final int rootA = find(a);
		final int rootB = find(b);
		
		arr[rootB] = rootA;
	}
}
