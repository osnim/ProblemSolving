import java.io.*;
import java.util.*;

public class Main_20057_마법사_상어와_토네이도 {
	
	static class Shark{
		int r, c, d;

		public Shark(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
	}
	
	static int N, ans, map[][];
	static Shark shark;
	static int first;
	
	static int[] dr = {0, 1, 0, -1}; //좌 하 우 상
	static int[] dc = {-1, 0, 1, 0};
	
	static int[][][] SpreadDir = {
			// 2% 		10%		   7%		1%  	5% 		 10%	7%		1%       2% 
			{{-2, 0}, {-1, -1}, {-1, 0}, {-1, 1}, {0, -2}, {1, -1}, {1, 0}, {1, 1}, {2, 0}}, 
			{{0, -2}, {1, -1}, {0, -1}, {-1, -1}, {2, 0}, {1, 1}, {0 ,1}, {-1, 1}, {0, 2}}, 
			{{2, 0}, {1, 1}, {1, 0}, {1, -1}, {0, 2}, {-1, 1}, {-1, 0}, {-1, -1}, {-2, 0}}, 
			{{0, 2}, {-1, 1}, {0, 1}, {1, 1}, {-2, 0}, {-1, -1}, {0, -1}, {1, -1}, {0, -2}}
	};
	static double[] percent = {0.02, 0.10, 0.07, 0.01, 0.05, 0.10, 0.07, 0.01, 0.02};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		map = new int[N][N];
		shark = new Shark(N/2, N/2, 0);
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		simulation();
		System.out.println(ans);
	}

	private static void simulation() {
		//1, 1, 2, 2, ... , N-1, N-1, N-1

		for (int i = 1; i < N; i++) { // i 길이를  2번 이동한다.
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < i; k++) {
					move();
				}
				shark.d = (shark.d+1)%4; // d는 같은 길이 이동 2회 하면 바뀐다 
			}
		}
		for (int i = 0; i < N-1; i++) {
			move();// N-1칸 마지막 한번 더 이동
		}
		
	}

	private static void move() {
		int yr = shark.r + dr[shark.d];
		int yc = shark.c + dc[shark.d];
		
		if (map[yr][yc] > 0) {
			spread(yr, yc);// 모래 흩날리기
			
		}		
		shark.r = yr;
		shark.c = yc;
	}

	private static void spread(int yr, int yc) {
		int[] temp = new int[10];
		int[][] drdcList = SpreadDir[shark.d];
		int memoSandCnt = map[yr][yc];
		map[yr][yc] = 0;
		int a = memoSandCnt;
		int ar = yr + dr[shark.d];
		int ac = yc + dc[shark.d];
		
		for (int i = 0; i < 9; i++) {
			int[] cur = drdcList[i];
			int drr = cur[0];
			int dcc = cur[1];
			
			int nr = yr + drr;
			int nc = yc + dcc;
			
			if (isOut(nr, nc)) {//밖으로 나간 경우
				ans += (int)(memoSandCnt*percent[i]);
				a -= (int)(memoSandCnt*percent[i]);
				continue;
			}
			temp[i] = (int)(memoSandCnt*percent[i]);
			a -= temp[i];
		}
		if (isOut(ar, ac)) { //밖으로 나간 경우
			ans += a;
		}else {
			temp[9] = a;
		}
		
		for (int i = 0; i < 9; i++) {
			if (temp[i] > 0) {
				int[] cur = drdcList[i];
				int drr = cur[0];
				int dcc = cur[1];
				int nr = yr + drr;
				int nc = yc + dcc;
				map[nr][nc] += temp[i];
			}
		}
		if (temp[9] > 0) {
			map[ar][ac] += temp[9]; 
		}
	}
	private static boolean isOut(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) return true;
		return false;
	}
}
