package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로_탐색 {

	static int N, M;
	static char [][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new int [N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		BFS(0,0);
		System.out.println(visited[N-1][M-1]);
	}

	private static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x,y});
		visited[x][y] = 1; 
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if (nr <0 || nr >= N || nc < 0 || nc >= M 
						|| visited[nr][nc] > 0 || map[nr][nc] == '0' ) continue;
				q.offer(new int[]{nr, nc});
				visited[nr][nc] = visited[r][c]+1;
				
			}
		}
		
	}

}
