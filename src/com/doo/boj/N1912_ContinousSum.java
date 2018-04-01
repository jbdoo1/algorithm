package com.doo.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * https://www.acmicpc.net/problem/1912
 * 
 * - Sample Input
 * 10
 * 10 -4 3 1 5 6 -35 12 21 -1
 * 
 * - Sample Output
 * 33
 * 
 * @author DOO
 *
 */
public class N1912_ContinousSum {

	static int N, max;
	static int[] numArr, d;
	
	public static void main(final String[] args) throws Exception {
		// Input
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//final BufferedReader br = new BufferedReader(new FileReader("C:\\workspace\\algorithm\\resources\\N1912_SampleData_1.txt"));
		String line = br.readLine();
		N = Integer.parseInt(line);
		numArr = new int[N + 1];
		d = new int[N + 1];
		String[] numStrs = br.readLine().split(" ");
		for (int n = 1; n <= N; n++) {
			numArr[n] = Integer.parseInt(numStrs[n - 1]);
		}
		
		// Solution
		dp(1);
		
		// Output
		System.out.println(max);
	}
	
	static void dp(final int n) {		
		if (n == 1) {
			d[n] = max = numArr[n];
		} else {
			// D(n) = D(n-1) + n > n ? D(n-1) + n : n;
			d[n] = d[n - 1] + numArr[n] > numArr[n] ? d[n - 1] + numArr[n] : numArr[n];
			max = d[n] > max ? d[n] : max;
		}
		
		if (n == N) {
			return;
		} else {
			dp(n + 1);
		}
	}
}
