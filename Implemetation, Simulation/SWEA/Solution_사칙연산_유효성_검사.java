package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

public class Solution_사칙연산_유효성_검사 {
	
	public static void main(String[] args) throws Exception{
		Stack<Object> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			boolean flag = true;
			//char[] arr = new char[N+1];
			ArrayList<String[]> arr = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				String[] temp = br.readLine().split(" ");
				arr.add(temp);
			}
			
			for (int i = 0; i < N; i++) {
				if (check(arr.get(i), i+1)) continue;
				else {
					sb.append("#"+t+" "+0+"\n");
					flag = false;
					break;
				}
			}
			if (flag) sb.append("#"+t+" "+1+"\n");
		}
		System.out.println(sb);
	}

	private static boolean check(String[] arr, int i) {
		String op = "[+-/*]";
		String num = "[0-9]";
		
		if (arr.length == 4) {
			if (!Pattern.matches(op, arr[1])) return false;
			else if(Integer.parseInt(arr[2]) != 2*i || Integer.parseInt(arr[3]) != (2*i)+1 ) return false;
		}
		else if(arr.length == 2) {
			if (!Pattern.matches(num, arr[1])) return false;
		}
		return true;
	}
}
