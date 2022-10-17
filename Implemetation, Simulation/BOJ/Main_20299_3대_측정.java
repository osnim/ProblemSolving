import java.util.*;
import java.io.*;

public class Main_20299_3대_측정{

	static int N, K, L;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		L = Integer.parseInt(st.nextToken()); 
		
		map = new int[N][4];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
			map[i][3] = sum;
			if (map[i][0] >= L && map[i][1] >= L && map[i][2] >= L && sum >= K) {
				cnt++;
				sb.append(map[i][0] + " " + map[i][1]+ " " + map[i][2] + " ");
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
		
	}

}
