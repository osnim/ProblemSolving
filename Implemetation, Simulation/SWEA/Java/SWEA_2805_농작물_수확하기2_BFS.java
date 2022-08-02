package algo0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_2805_농작물_수확하기2_BFS {

	static int T;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int sum;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	//최악 50*50*5 = 12500 sum < 2_000_000_000
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				char[] temp = str.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j]-'0';
				}
			}//입력 끝
			sum = 0;
			bfs();
			System.out.println("#" + t + " " + sum);
		}
	}

	//4방 > 다이아몬드로 결정이 성장한다. > 다이아몬드로 검색
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>(); //FIFO
		q.offer(new int[] {N/2, N/2, 0}); // 시작위치, depth 넣어
		sum += map[N/2][N/2]; //중앙
		visited[N/2][N/2] = true; //중앙 온적 있다.
		while(!q.isEmpty()) {
			int[]cur = q.poll(); // 빼서
			int r = cur[0]; // 현재 r
			int c = cur[1]; // 현재 c
			int dep = cur[2]; //현재 깊이
			if(dep<N/2) { // N/2겹보다 작아야한다. 실행이 안되면 큐에 넣을 것이 없어서 큐가 굸어 죽는다.
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(visited[nr][nc]) continue; //방문한 적 있으면 제외
					q.offer(new int[] {nr,nc,dep+1});//넣어
					sum += map[nr][nc];
					visited[nr][nc] = true;
				}
			}	
		}
	}
}
