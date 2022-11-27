import java.io.*;
import java.util.*;
public class Solution_4193_수영대회_결승전 {
	static int N, sr, sc, tr, tc;
	static int[][] map;
	static int[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			visited = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine(), " ");
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			tr = Integer.parseInt(st.nextToken());
			tc = Integer.parseInt(st.nextToken());
			// 입력 끝
			
			sb.append("#" + t + " " + bfs() + "\n");
			
		}
		System.out.println(sb);
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {sr, sc, 0});
		visited[sr][sc] = -1;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int t = cur[2];
			if (r == tr && c == tc) {
				return t;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc] != 0) continue;
				if(map[nr][nc] == 2 && t%3 != 2) {
					q.offer(new int[] {r, c, t+1});
					continue;
				}
				q.offer(new int[] {nr, nc, t+1});
				visited[nr][nc] = t+1;
			}	
		}
		return -1;
	}
}
