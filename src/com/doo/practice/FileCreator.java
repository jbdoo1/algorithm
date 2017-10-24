package com.doo.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCreator {
	
	private static String RESOURCES_PATH = "/Users/jeonbyeongdoo/Documents/workspace/Algorithm/resources/";
	private static String FILE_NAME = RESOURCES_PATH + "numbers_1000000.txt";
	private static int MAX_NUM = 1000000;
	
	public static void main(final String[] args) {
		
		createNewFile(FILE_NAME);
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			// Write to file
			fw = new FileWriter(FILE_NAME);
			bw = new BufferedWriter(fw);
			
			for (int i = 1; i <= MAX_NUM; i++) {
				bw.write(String.valueOf(i));
				bw.newLine();
			}
			bw.flush();
			
			// View result(print file contents)
			printFile(FILE_NAME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void createNewFile(final String fileName) {
		try {
			final PrintWriter pw = new PrintWriter(fileName);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void printFile(final String fileName) {
		try {
			final BufferedReader bw = new BufferedReader(new FileReader(fileName));
			String line = null;
			while((line = bw.readLine()) != null) {
				System.out.println(line);
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
