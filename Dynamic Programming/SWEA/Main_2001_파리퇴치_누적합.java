package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2001_파리퇴치_누적합 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N+1][N+1];
			int max = 0;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					int k = Integer.parseInt(st.nextToken());
					map[i][j] = k + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
				}
			}
			
			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					int temp = map[i][j] - map[i-M][j] - map[i][j-M] + map[i-M][j-M];
					max = Math.max(temp, max);
				}
			}
			sb.append("#"+ t + " "+ max+'\n');

		}
		System.out.println(sb);
	}
}
