package com.doo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class N2517_Running {
	
	private static int N;
	private static int[] result;
	
	// Indexed Tree
	private static Node[] data;
	private static int[] tree;
	
	public static void main(final String[] args) throws IOException {
		// Input & Init
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = new int[N];
		makeIndexdTree(N);
		
		for (int n = 0; n < N; n++) {
			Node node = new Node(n, Integer.parseInt(br.readLine()));
			data[n] = node;
		}
		// 실력값으로 sort
		Arrays.sort(data, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				if (a.value < b.value) {
					return -1;
				} else if (a.value == b.value){
					return 0;
				} else {
					return 1;
				}
			}
		});
		// 실력값을 rename
		for (int n = 0; n < N; n++) {
			data[n].value = n;
		}
		// 들어온 순으로 다시 sort
		Arrays.sort(data, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				if (a.index < b.index) {
					return -1;
				} else if (a.index == b.index) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		
		// Solution
		for (int n = 0; n < N; n++) {
			result[n] = data[n].index + 1 - sum(1, 0, data.length - 1, 0, data[n].value - 1);
			update_range(1, 0, data.length - 1, data[n].value, data[n].value, 1);
		}
		
		// Output
		for (int n = 0; n < N; n++) {
			System.out.println(result[n]);
		}
	}
	
	static class Node {
		int index;
		int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	static int makeIndexdTree(final int N) {
		data = new Node[N];
		int leafNodeSize = (int) Math.pow(2, ((int) Math.ceil(logB(N, 2)) + 1));
		tree = new int[leafNodeSize * 2];
		
		return leafNodeSize;
	}
	
	static double logB(final int x, final int base) {
		return Math.log(x) / Math.log(base);
	}
	
	static int sum(final int node, final int start, final int end, final int left, final int right) {
		// out of index
		if (start > right || end < left) return 0;
		
		// fully
		if (left <= start && right >= end) return tree[node];
		
		// partially
		return sum(node * 2, start, (start + end) / 2, left, right) + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}
	
	static void update_range(final int node, final int start, final int end, final int left, final int right, final int diff) {
		// out of index
		if (start > right || end < left) return;
		
		tree[node] += diff;
		
		// leaf node
		if (start == end) return;
		
		// partially - update child nodes
		update_range(node * 2, start, (start + end) / 2, left, right, diff);
		update_range(node * 2 + 1, (start + end) / 2 + 1, end, left, right, diff);
	}
}
