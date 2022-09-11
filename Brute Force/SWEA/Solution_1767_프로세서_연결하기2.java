package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_프로세서_연결하기2 {
	
	static class Core{
		int r;
		int c;
		int d;
		boolean[] dirCheck = {true, true, true, true};
		
		public Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] map;
	static int N;
	static List<Core> coreList;
	static int coreCnt, realCoreCnt;
	static boolean[] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int maxCore = -1;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			coreList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 || i == N-1 || j == 0 || j == N-1 || map[i][j] == 0)// 가장자리나 프로세서가 없을 때
						continue;
					coreList.add(new Core(i, j));
				}
			}// 입력 끝
			
			for (Core co : coreList) {
				for (int d = 0; d < 4; d++) {
					check4Dir(co, d); // 4방향에 코어 있으면 탐색 불가 
				}
			}
			
			ans = Integer.MAX_VALUE;
			maxCore = -1;
			visited = new boolean[coreCnt];
			
			dfs(0, 0, 0); // 못 찾을 때만 들어감
			
			if (ans == Integer.MAX_VALUE) {
				ans = 0;
			}
		
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int idx, int coreCnt, int sum) {
		if (idx == coreList.size()) {
			if (maxCore < coreCnt) {
				maxCore = coreCnt;
				ans = sum;
			}else if(maxCore == coreCnt)
				ans = Math.min(ans, sum);
			return;
		}
		
		int r = coreList.get(idx).r;
		int c = coreList.get(idx).c;
		
		for (int i = 0; i < 4; i++) {
			int cnt = 0, nr = r, nc = c;
			int coreTempCnt = 0;
			
			while(true) {
				nr = nr + dr[i];
				nc = nc + dc[i];
				
				if (nr < 0 || nr == N || nc < 0 || nc == N) { //끝까지 연결된 경우
					coreTempCnt++;
					break;
				}
				if (map[nr][nc] != 0) {
					cnt = 0;
					break;
				}
				
				cnt++; // 전선도 없고 프로세서도 없는 경우
			}
			
			//cnt 만큼 채우기
			int fill_r = r;
			int fill_c = c;

			for (int j = 0; j < cnt; j++) {
				fill_r = fill_r + dr[i];
				fill_c = fill_c + dc[i];
				map[fill_r][fill_c] = 2; 
			}
			
			dfs(idx + 1, coreCnt + coreTempCnt, sum+cnt);
			
			fill_r = r;
			fill_c = c;
			
			for (int j = 0; j < cnt; j++) { // 맵 되돌리기
				fill_r = fill_r + dr[i];
				fill_c = fill_c + dc[i];
				map[fill_r][fill_c] = 0;
			}
		}
	}

	private static void check4Dir(Core co, int d) {
		int r = co.r;
		int c = co.c;
		while(true) {
			r = r + dr[d];
			c = c + dc[d];
			
			if (r < 0 || r == N || c < 0 || c == N) {
				co.dirCheck[d] = true;
				return; //위부 전원 연결 가능
			}
			
			if (map[r][c] == 1) {
				co.dirCheck[d] = false;
				return ; //다른 프로세서가 있거나 이미 선이 깔려 있을 때
			}
		}
	}
}
	
