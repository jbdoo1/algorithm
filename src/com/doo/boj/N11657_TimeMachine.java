package com.doo.boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class N11657_TimeMachine {

	static int N, M;
	static int[] result;
	static Map<Integer, Map<Integer, Line>> graph = new HashMap<Integer, Map<Integer, Line>>();
	
	public static void main(final String[] args) {
		try {
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	BufferedReader br = new BufferedReader(new FileReader("/Users/jeonbyeongdoo/Documents/workspace/algorithm/resources/N11657_SampleData_1.txt"));
			String str;
			str = br.readLine();
			N = Integer.parseInt(str.split(" ")[0]);
			M = Integer.parseInt(str.split(" ")[1]);
			result = new int[N + 1];
			int a, b, c;
			for (int m = 1; m <= M; m++) {
				str = br.readLine();
				a = Integer.parseInt(str.split(" ")[0]);
				b = Integer.parseInt(str.split(" ")[1]);
				c = Integer.parseInt(str.split(" ")[2]);

				Map<Integer, Line> lines = graph.get(Integer.valueOf(a));
				if (lines == null) {
					lines = new HashMap<Integer, Line>();
				}
				Line oldLine = lines.get(Integer.valueOf(b));
				if (oldLine == null || oldLine.time > c) {
					lines.put(Integer.valueOf(b), new Line(a, b, c));
				}
				graph.put(Integer.valueOf(a), lines);
			}
			
			boolean ret = bellmanFord(1);
			
			if (ret) {
				System.out.println(-1);
			} else {
				for (int i = 2; i < result.length; i++) {
					if (result[i] == Integer.MAX_VALUE) {
						System.out.println(-1);
					} else {
						System.out.println(result[i]);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static boolean bellmanFord(final int s) {
		boolean updated = false;
		for (int n = 1; n <= N; n++) {
			result[n] = Integer.MAX_VALUE;
		}
		result[s] = 0;
		
		for (int i = 1; i <= N; i++) {
			updated = false;
			for (int n = 1; n <= N; n++) {
				Map<Integer, Line> lines = graph.get(Integer.valueOf(n));
				if (lines != null) {
					for (Integer to : lines.keySet()) {
						Line line = lines.get(to);
						if (result[n] < Integer.MAX_VALUE && (result[n] + line.time) < result[line.to]) {
							result[to] = result[n] + line.time;
							updated = true;
						}
					}
				}
			}
		}
		
		return updated;
	}
	
	static class Line {
		int from, to, time;
		
		public Line(final int from, final int to, final int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
}
