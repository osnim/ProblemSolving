import java.io.*;
import java.util.*;

public class Main_1600_말이되고픈_원숭이 {

	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] dp;
	
	static int[] hdr = {-2, -1, 1, 2,  2,  1, -1,  1, -2}; //1시방향부터 시계방향 회전
	static int[] hdc = { 1,  2, 2, 1, -1, -2, -2, -2, -1};
	
	static int[] mdr = {-1, 0, 1, 0};
	static int[] mdc = {0, 1, 0, -1};
	
	static int ans = -1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		dp = new int[H][W];
		visited = new boolean[H][W][K+1];
		int sr = 0;
		int sc = 0;
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝 
		
		ans = bfs(sr, sc);
		System.out.println(ans);
		
	}

	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, 0, K});
		visited[x][y][K] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			int k = cur[3];
			if (r == H-1 && c == W-1) {
				return cnt;
			}
			if (k > 0) {
				for (int i = 0; i < 8; i++) {
					int nr = r + hdr[i];
					int nc = c + hdc[i];
					if (!check(nr, nc)) continue;
					if (map[nr][nc] == 1) continue;
					if (visited[nr][nc][k-1]) continue;
					visited[nr][nc][k-1] = true;
					q.offer(new int[] {nr, nc, cnt+1, k-1});
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = r + mdr[i];
				int nc = c + mdc[i];
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == 1) continue;
				if (visited[nr][nc][k]) continue;
				visited[nr][nc][k] = true;
				q.offer(new int[] {nr, nc, cnt+1, k});
			}
			
		}
		return -1;
		
	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < H && nc >= 0 && nc < W ) return true; 
		return false;
	}

}
