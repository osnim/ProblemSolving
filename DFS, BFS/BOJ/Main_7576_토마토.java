package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	
	static class Tomato{
		int r;
		int c;
		
		public Tomato(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Tomato> q;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int days;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 1) {
					q.offer(new Tomato(i, j));
				}
			}
		}// 입력 끝
		
		
		
		while(true) {
			BFS();
			if (q.isEmpty()) {
				break;
			}
			days++;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(days);
		
	}

	private static void BFS() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Tomato tomato = q.poll();
			int r = tomato.r;
			int c = tomato.c;
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == -1) continue; // 벽
				if (map[nr][nc] > 0) continue; // 이미 왔다 감
				
				q.offer(new Tomato(nr, nc));
				map[nr][nc] = days+1;
			}
		}
	}

	private static boolean check(int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < M) return true;
		return false;
	}
	

}
