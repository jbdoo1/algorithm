package com.doo.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputTest {
	
	private static String RESOURCES_PATH = "/Users/jeonbyeongdoo/Documents/workspace/Algorithm/resources/";
	private static String FILE_NAME = RESOURCES_PATH + "numbers_1000000.txt";
	private static int MAX_NUM = 1000000;

	public static void main(final String[] args) {
		
		inputFromScanner(MAX_NUM);
		inputFromBufferedReader(MAX_NUM);
		
	}
	
	static void inputFromScanner(final int n) {
		try {
			Scanner sc = new Scanner(new File(FILE_NAME));
			int t;
			//sc.nextLine();
			long timeStarted = System.currentTimeMillis();
			for (int i = 0; i < n; i++) {
				t = sc.nextInt();
				//System.out.println(t);
			}
			System.out.println("Time taken with Scanner : " + (System.currentTimeMillis() - timeStarted) + "ms");
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void inputFromBufferedReader(final int n) {
		try {
			BufferedReader bw = new BufferedReader(new FileReader(FILE_NAME));
			int t;
			long timeStarted = System.currentTimeMillis();
			for (int i = 0; i < n; i++) {
				t = Integer.parseInt(bw.readLine());
				//System.out.println(t);
			}
			System.out.println("Time taken with BufferedReader : " + (System.currentTimeMillis() - timeStarted) + "ms");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
