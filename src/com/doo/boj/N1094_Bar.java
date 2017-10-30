package com.doo.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N1094_Bar {

	static int target, result, cutCount = 1, barCount = 1;
	final static int X = 64;
	static int remainX = X;
	
	public static void main(final String[] args) {
		
		try {
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new FileReader("/Users/jeonbyeongdoo/Documents/workspace/algorithm/resources/N1094_SampleData_4.txt"));
			
			String line = br.readLine();
			target = Integer.parseInt(line);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(String.valueOf(dp()));
			bw.flush();
			bw.close();
		} catch (final IOException ie) {
			ie.printStackTrace();
		}
	}
	
	static int dp() {
		if (remainX == target) return barCount;
		
		boolean isCut = remainX - X / Math.pow(2, cutCount) >= target;
		if (isCut) {
			remainX -= X / Math.pow(2, cutCount);
		} else {
			barCount++;
		}
		cutCount++;
		
		return dp();
	}
}
