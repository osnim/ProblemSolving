package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[100][100];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int bot = Integer.parseInt(st.nextToken());
			
			for (int i = bot; i < bot+10; i++) {
				for (int j = left; j < left+10; j++) {
					map[i][j] = 1;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					cnt++ ;
				}
			}
		}
		System.out.println(cnt);
	}

}
