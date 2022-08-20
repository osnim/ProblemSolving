package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Solution_1247_최적_경로 {

	static int[][] map;
	static int[] p; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int ans = Integer.MAX_VALUE;
			int count = 0;
			
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			st = new StringTokenizer(br.readLine());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			
			int[][] cusInfoes = new int[N][2];
			for (int i = 0; i < N; i++) {
				cusInfoes[i][0] = Integer.parseInt(st.nextToken());
				cusInfoes[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			do {
				count++;
				int result = 0;
				int sx = cx; // 시작점
				int sy = cy; //
				int dx = 0;
				int dy = 0;
				for (int i = 0; i < N; i++) {
					dx = cusInfoes[p[i]][0];
					dy = cusInfoes[p[i]][1];
					result += Math.abs(sx-dx) + Math.abs(sy-dy);
					sx = dx;
					sy = dy;
				}
				result += Math.abs(hx-sx) + Math.abs(hy-sy);
				
				ans = Math.min(result, ans);
				
			}while(np(N-1));
			
			sb.append("#" + t +" " +ans +"\n");
		}
		System.out.println(sb);

	}
	private static boolean np(int size) {
		int i = size;
		while(i > 0 && p[i-1] > p[i]) i--;
		if(i == 0) return false;
		
		int j = size;
		while(p[i-1] > p[j])j--;
		swap(i-1, j);
		
		int k = size;
		while(i < k)swap(i++, k--);
		
		return true;
		
	}
	private static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
		
	}

}
