

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의_개수 {
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int w, h;
	static boolean [][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w+h == 0) break;
			int[][] map = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 입력 끝
			visited = new boolean[h][w];
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (visited[i][j] || map[i][j] == 0) continue;
					visited[i][j] = true;
					cnt += BFS(i, j, map);
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
	private static int BFS(int x, int y, int[][] map) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x, y});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 8; i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				if (!check(nr, nc, map)) continue;
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
		return 1;
		
	}
	private static boolean check(int nr, int nc, int[][] map) {
		if (nr<0 || nr >= h || nc < 0 ||  nc >= w || visited[nr][nc] || map[nr][nc] ==0) {
			return false;
		}
		return true;
	}
}
