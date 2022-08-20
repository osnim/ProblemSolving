package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8382_방향_전환 {
	
	static int T;
	static int r1, r2, c1, c2;
	static int[] dr = {-1, 0, 1, 0}; //상좌하우 even odd 
	static int[] dc = {0, -1, 0, 1}; 
	static int[][][] visited;// 핵심 > 딜레마: 갈 수 있는 방법 + 무한루프
	static int val;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			r1 = 100+Integer.parseInt(st.nextToken());
			c1 = 100+Integer.parseInt(st.nextToken());
			r2 = 100+Integer.parseInt(st.nextToken());
			c2 = 100+Integer.parseInt(st.nextToken());
			
			visited = new int[201][201][2]; //2 ->  <<---->> ^||v
			val = -1;
			bfs();
			System.out.println("#" + t + " " + val);
		}
		
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r1, c1, 0, 0}); // 시작점, 간 거리, 두 가지 방향
		q.offer(new int[] {r1, c1, 0, 1}); // 시작점, 간 거리, 두 가지 방향
		visited[r1][c1][0] = 1; // 상하로 움직였다
		visited[r1][c1][1] = 1; // 좌우로 움직였다.
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			int dir = cur[3];
			
			if(r == r2 && c == c2) {
				val = cnt;
				return;
			}
			
			for (int d = 1; d < 4; d+=2) {
				int s = (dir+d)%4; 	//0+1,  0+3 4방중 2방 만들기
				int u = (dir+d)%2;	// 홀짝 만들기
				int nr = r+dr[s]; 	// 방향이 바뀐다
				int nc = c+dc[s]; 	// 방향이 바뀐다
				if (!check(nr, nc)) continue;
				if (visited[nr][nc][u] == 0) {
					q.offer(new int[] {nr, nc, cnt+1, s}); // 시작점, 간 거리, 두 가지 방향
					visited[nr][nc][u] = 1; // 좌우로 움직였다.
					
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < 201 && c>=0 && c < 201;
	}
}
