package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {

	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		int color3cnt = 0;
		int color2cnt = 0;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				color3cnt += bfs(i, j);
			}
		}
		
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]) continue;
				color2cnt += bfs(i, j);
			}
		}
		System.out.println(color3cnt + " " + color2cnt);
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		char start = map[i][j];
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		
		//다음 적록색약을 위해 맵 변경 
		if (start == 'G') map[i][j] = 'R'; 
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc)) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] != start) continue;
				
				q.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
				if (start == 'G') { // 다음 적록 색약을 위해 맵 정보 수정
					map[nr][nc] = 'R';
				}
			}
		}
		return 1;
	}

	private static boolean check(int r, int c) {
		if(r>=0 && r < N && c >= 0 && c < N) return true;
		return false;
	}

}
