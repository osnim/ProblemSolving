import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485_녹색_옷_입은_애가_젤다지 {

	static int N;
	static int[][] map;
	static int[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				break;
			}
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem "+ cnt++ + ": "+ bfs()+"\n");
		}
		System.out.println(sb);
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		visited[0][0] = map[0][0];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (!check(nr, nc)) continue;
				int temp = map[nr][nc] + visited[r][c];
				if (temp < visited[nr][nc]) {
					visited[nr][nc] = temp;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
		return visited[N-1][N-1];
	}

	private static boolean check(int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < N) return true;
		return false;
	}
	
	
	
	
	
	
	
	
	
	

}
