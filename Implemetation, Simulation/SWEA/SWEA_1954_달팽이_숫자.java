package algo0802;

import java.util.Scanner;

public class SWEA_1954_달팽이_숫자 {

	static int[][] arr;
	static int N;
	static int [] dr = {0, 1, 0, -1};
	static int [] dc = {1, 0, -1, 0};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			int r = 0;
			int c = 0;
			int pow = N*N;
			int cnt = 1;
			arr[r][c] = cnt;
			cnt++;
			int nr = 0;
			int nc = 0; 
			int d = 0;
			
			while(cnt <= pow) {
				
				nr = r + dr[d];
				nc = c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					d = (d+1)%4;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				if(arr[nr][nc] > 0) {
					d = (d+1)%4;
					nr = r + dr[d];
					nc = c + dc[d];
				}
				arr[nr][nc] = cnt;
				cnt++;
				r = nr;
				c = nc;
			}
			
			System.out.println("#"+t);
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " "); 
				} 
				System.out.println();
			}
		}
		
	}

}
