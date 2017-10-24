package com.doo.boj;

import java.util.Scanner;

public class N3649_RobotProject {
	
	static int W, n, i, result1, result2;
	static int[] length;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str;
		while (true) {
			str = sc.nextLine();
			
			if (str.equals("")) 
				break;
			else
				W = Integer.parseInt(str) * 10000000;
			
			n = sc.nextInt();
			
			length = new int[n];
			result1 = -1;
			result2 = -1;
			
			for (i = 0; i < n; i++) {
				length[i] = sc.nextInt();
			}
			quickSort(length, 0, n - 1);
			
			if (n < 2) {
				System.out.println("danger");
				sc.nextLine();
				continue;
			}
			
			for (i = 0; i < n; i++) {
				bsForFind(i, i + 1, n - 1);
			}
			
			if (result1 == -1 && result2 == -1) {
				System.out.println("danger");
			}
			else {
				System.out.println("yes " + result1 + " " + result2);
			}
			sc.nextLine();
		}
		
		sc.close();
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		/*
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
			*/
		if (low < i - 1)
            quickSort(arr, low, i - 1);
		if (i < high)
            quickSort(arr, i, high);
	}	
	
	public static void bsForFind(int index, int l, int h) {
		if (l <= h) {
			int num = length[index];
			int m = (l + h) / 2;
			if ((length[m] + num) == W) {
				int tempResult1, tempResult2;
				if (num < length[m]) {
					tempResult1 = num;
					tempResult2 = length[m];
				}
				else {
					tempResult1 = length[m];
					tempResult2 = num;
				}
				
				if (Math.abs(result1 - result2) <= Math.abs(tempResult1 - tempResult2)) {
					result1 = tempResult1;
					result2 = tempResult2;
				}
				
				return;
			}
		
			if ((length[m] + num) > W) {
				bsForFind(index, l, m - 1);
			}
			else {
				bsForFind(index, m + 1, h);
			}
		}
	}
}