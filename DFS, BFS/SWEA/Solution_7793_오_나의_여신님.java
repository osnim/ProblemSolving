import java.io.*;
import java.util.*;

public class Solution_7793_오_나의_여신님 {
	
	static class Devil{
		int r;
		int c;
		
		public Devil(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static char[][] map;
	static String ans;
	
	static int DR, DC, SR, SC; // 여신과 수연의 위치
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int[][] syVisited;
	static int[][] dvVisited;
	
	
	static List<Devil> devils;
	static char[][] devilMap;
	static int[][] syMap; // 수연이 도착시간을 기록한 맵
	static int[][] dvMap; // 악마가 도착한 시간을 기록한 맵
	static Queue<int[]> devilQ;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); 
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			ans = "GAME OVER";
			devils = new ArrayList<>();
			devilMap = new char[N][M];
			devilQ = new LinkedList<>();
			dvVisited = new int[N][M];
			syVisited = new int[N][M];
			
			
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'D') { //여신
						DR = i; DC = j;
					}else if(map[i][j] == 'S') { //수연
						SR = i; SC = j;
					}else if(map[i][j] == '*') {
						devilQ.offer(new int[] {i, j, 0});
						dvVisited[i][j] = 0;
					}
				}
			}//입력 끝
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, devilMap[i], 0, M);
			}
			
			bfs(SR, SC);
			
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int SR, int SC) {
		Queue<int[]> SQ = new LinkedList<>(); //수연 큐
		SQ.offer(new int[] {SR, SC, 0});
		syVisited[SR][SC] = 0;
		
		while((!SQ.isEmpty()) || (!devilQ.isEmpty())) {
			//먼저 악마부터 퍼뜨림
			int size = devilQ.size();
			for (int s = 0; s < size; s++) {
				int[] cur = devilQ.poll();
				int r = cur[0];
				int c = cur[1];
				int time = cur[2];
				
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if (dvVisited[nr][nc] > 0) continue;
					if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
						devilQ.offer(new int[] {nr, nc, time+1});
						dvVisited[nr][nc] = time+1;
						map[nr][nc] = '*';
					}
				}
			} // 악마 먼저 퍼뜨림
			
			size = SQ.size();
			for(int s = 0; s < size; s++) {
				int[] cur = SQ.poll();
				int r = cur[0];
				int c = cur[1];
				int time = cur[2];
				if (r == DR && c == DC) {
					ans = String.valueOf(time);
					return;
				}
				
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
					if (syVisited[nr][nc] > 0) continue;
					if (map[nr][nc] == '.' || map[nr][nc] == 'D') {
						SQ.offer(new int[] {nr, nc, time+1});
						syVisited[nr][nc] = time+1;
						map[nr][nc] = 'S';
					}
				}
			}
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
			
		}
		
		
	}
	
	
}
