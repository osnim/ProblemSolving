package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_2816_격자판의_숫자_이어_붙이기 {
	
	static int[][] map = new int[4][4];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static HashSet<Integer> set;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
  		for (int t = 1; t <= T; t++) {
  			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					npr(i, j, 0, map[i][j]);
				}
			}
			sb.append("#"+ t +" "+ set.size()+" \n");
		}
  		System.out.println(sb);
	}

	private static void npr(int r, int c, int cnt, int val) {
		if (cnt == 6) {
			set.add(val);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
			
			npr(nr, nc, cnt+1, val * 10 + map[nr][nc]);
			
		}
		
		
		
	}

}
