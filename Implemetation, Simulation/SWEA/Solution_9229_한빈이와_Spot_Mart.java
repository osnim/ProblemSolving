package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와_Spot_Mart {
	static Integer[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N, M;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}//입력
			int[] dp = new int[N];
			int max = -1;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					int sum = arr[i] + arr[j];
					if (sum <= M && sum > max) {
						max = sum;
					}
				}
			}
			sb.append("#"+t+" "+max+ "\n");
		}
		System.out.println(sb);
			
	}


}
