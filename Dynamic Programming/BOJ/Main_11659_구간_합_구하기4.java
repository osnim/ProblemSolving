package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_구간_합_구하기4 {
	
	static int[] arr;
	static long[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		dp = new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for (int m = 0; m< M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(dp[j] - dp[i-1]);
		}
		
	}

}
