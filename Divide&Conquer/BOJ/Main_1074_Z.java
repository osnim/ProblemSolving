package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1074_Z {
	static int N, r, c;
	static long ans = 0L;
	static boolean find = false;
	static long cnt = 0L;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = 2<<Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		Z(0, 0, N);
		System.out.println(ans);
	}

	private static void Z(int x, int y, int n) {
		if (find) return;
		
		if (n == 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					cnt++;
					if(x+i == r && y+j == c) {
						ans = --cnt;
						find = true;
						return;
					}
				}
			}
			
		}
		if ( x <= r && r < x+n/2 && y <= c && c < y+n/2) { // 범위 안에 있다면
			Z(x, y, n/2);
		}else {
			cnt += n*n/4;
		}
		
		if ( x <= r && r < x+n/2 && y+n/2 <= c && c < y+n) { // 범위 안에 있다면
			Z(x, y+n/2, n/2);
		}else {
			cnt += n*n/4;
		}
		
		if ( x+n/2 <= r && r < x+n && y <= c && c < y+n/2) { // 범위 안에 있다면
			Z(x+n/2, y, n/2);
		}else {
			cnt += n*n/4;
		}
		
		if ( x+n/2 <= r && r < x+n && y+n/2 <= c && c < y+n) { // 범위 안에 있다면
			Z(x+n/2, y+n/2, n/2);
		}else {
			cnt += n*n/4;
		}
		
		
	}

}
