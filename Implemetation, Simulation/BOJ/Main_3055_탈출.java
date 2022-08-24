import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {

	static int R, C;
	static char[][] map;
	static int time;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static Queue<int[]> qwater = new LinkedList<>();
	static Queue<int[]> qgoSm = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
				if(ch == 'S') {
					//go = new goSm(i, j, 0);
					qgoSm.add(new int[] {i, j, 0});
				}
				else if(ch == '*') {
					qwater.add(new int[] {i, j});
				}
 			}
		}// 입력 끝
		
		while(true) {
			bfsWa();
			bfsGo();

			if (time > 0) {
				System.out.println(time);
				break;
			}

			if (qgoSm.isEmpty()) {
				System.out.println("KAKTUS");
				return;
			}
		}
	}

	private static void bfsWa() {
		int size = qwater.size();
		for (int i = 0; i < size; i++) {
			int[] cur = qwater.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == '*') continue;
				if (map[nr][nc] == 'D') continue;
				if (map[nr][nc] == 'X') continue;
				
				qwater.add(new int[]{nr, nc});
				map[nr][nc] = '*';
			}
		}
	}

	private static void bfsGo() {
		int size = qgoSm.size();
		for (int i = 0; i < size; i++) {
			int[] go = qgoSm.poll();
			int r = go[0];
			int c = go[1];
			int t = go[2];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!check(nr, nc)) continue;
				if (map[nr][nc] == '*') continue;
				if (map[nr][nc] == 'X') continue;
				if (map[nr][nc] == 'S') continue;
				if (map[nr][nc] == 'D') {
					time = t+1;
					return;
				}
				qgoSm.add(new int[]{nr, nc, t+1});
				map[nr][nc] = 'S';
			}
		}
	}

	private static boolean check(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) return false; 
		return true;
	}	

}
