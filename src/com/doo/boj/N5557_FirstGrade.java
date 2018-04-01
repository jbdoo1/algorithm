package com.doo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N5557_FirstGrade {
	
	static int N;
	static int[] numbers;
	static long[][] cache;
	
	public static void main(final String[] args) throws IOException {
		final InputStreamReader isr = new InputStreamReader(System.in);
		//final FileReader fr = new FileReader("C:\\workspace\\algorithm\\resources\\N5557_SampleData_1.txt")
		final BufferedReader br = new BufferedReader(isr);
		
		String line = br.readLine();
		N = Integer.parseInt(line);
		numbers = new int[N + 1];
		cache = new long[N + 1][21];
		
		line = br.readLine();
		String[] strs = line.split(" ");
		for (int n = 0; n < N; n++) {
			numbers[n + 1] = Integer.parseInt(strs[n]);
		}
		
		System.out.println(dp(numbers[N], N - 1));
	}
	
	static long dp(final int target, final int idx) {
		if (cache[idx][target] > 0) return cache[idx][target];
		if (idx == 1) {
			if (target == numbers[idx])
				return 1;
			else
				return 0;
		}
		
		long result = 0;
		
		if (target + numbers[idx] <= 20) {
			result += dp(target + numbers[idx], idx - 1);
		}
		if (target - numbers[idx] >= 0) {
			result += dp(target - numbers[idx], idx - 1);
		}
		
		cache[idx][target] = result;
		
		return result;
	}
}