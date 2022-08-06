package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2023_신기한_소수 {
	static StringBuilder sb;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		
		  //현재 자리수, 현재 값
		rec(0, 0);
		System.out.println(sb);
	}

	private static void rec(int cnt, int val) {
		if (cnt == n) {
			sb.append(val+"\n");
			return;
		} 
		for (int k = 1; k <=9 ; k++) {
			int temp = k + val*10;
			if(!isPrime(temp)) continue;
			rec(cnt+1, temp);
		}
	}

	private static boolean isPrime(int temp) {
		if (temp <= 1) 	return false;
		
		for (int i = 2; i <= Math.sqrt(temp); i++) {
			if(temp%i == 0) return false;
		}
		return true;
	}
}
