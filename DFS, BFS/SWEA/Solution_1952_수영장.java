package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {

	static int[] arr;
	static int day, month, month3, year;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr = new int[12];
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			month3 = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			ans = year;
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 12; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			sb.append("#" + t + " " + ans + "\n");	
		}
		System.out.println(sb);
	}

	private static void dfs(int idx, int sum) {
		//종료 조건
		if(sum > ans) return;
		
		if (idx >= 12) {
			ans = Math.min(ans, sum);
			return;
		}
		
		//실행하면서 재귀호출
		
		//사용일이 0일 이면 그냥 넘어감
		if (arr[idx] == 0) {
			dfs(idx+1, sum);
			return;
		}
		
		dfs(idx+1, sum + arr[idx] * day); //1일권
		
		dfs(idx+1, sum + month); //1달권
		
		dfs(idx+3, sum + month3); //3달권
	}
}
