package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008_숫자_만들기 {
	
	static int[] op;
	static int N;
	static int max;
	static int min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] nums = new int[N];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			op = new int[4];
			for (int j = 0; j < 4; j++) {
				op[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}//입력 끝
			dfs(1, nums[0], nums, op[0], op[1], op[2], op[3]);
			int diff = max - min;
			sb.append("#"+ t +" "+ diff + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cnt, int tot, int[] nums, int plus, int minus, int mul, int div) {
		if(cnt == N) {
			max = Math.max(max, tot);
			min = Math.min(min, tot);
			return;
		}
		if(plus > 0) dfs(cnt+1, tot+nums[cnt], nums, plus-1, minus, mul, div);
		if(minus > 0) dfs(cnt+1, tot-nums[cnt], nums, plus, minus-1, mul, div);
		if(mul > 0) dfs(cnt+1, tot*nums[cnt], nums, plus, minus, mul-1, div);
		if(div > 0) dfs(cnt+1, tot/nums[cnt], nums, plus, minus, mul, div-1);
		
	}

}
