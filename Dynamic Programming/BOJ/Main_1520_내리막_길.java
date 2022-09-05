package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1520_내리막_길 {

	static int[][] map;
	static int[][] dp;
	static int M, N; 
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int count;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs2(0, 0));
	}
		
	private static int dfs2(int r, int c) {
		
		if (r == M-1 && c == N-1) {
			return 1;
		}
		
		if (dp[r][c] != -1) 
			return dp[r][c]; //이미 방문, 메모이제이션
		
		dp[r][c] = 0; //첫 방문 체크 
				
		for (int i = 0; i < 4; i++) {
			
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!check(nr, nc)) continue;
			if (map[r][c] <= map[nr][nc]) continue;
			
			dp[r][c] += dfs2(nr, nc); 
		}
		
		return dp[r][c];
	}

	private static boolean check(int nr, int nc) {
		if (0 <= nr && nr < M && 0 <= nc && nc < N) return true;
		return false;
	}

}
