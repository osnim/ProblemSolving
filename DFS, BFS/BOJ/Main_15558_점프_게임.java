package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15558_점프_게임 {
	
	static int K, N;
	static int clear = 0; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		char[][] lines = new char[N][2];
		for (int i = 0; i < 2; i++) {
			lines[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < 2; i++) {
			System.out.println(Arrays.toString(lines[i]));
		}
		
		dfs(0, 0, 0, lines);
		System.out.println(clear);
	}
	
	//1초부터 시작하지만 난 0초부터 0째 줄 사라짐
	private static void dfs(int r, int c, int time, char[][] lines) {
		System.out.println(r+" "+c);
		if (clear == 1) {
			return;
		}
		
		boolean check3 = false; // 3방향 중 하나라도 못가면 끝냄

		if(canGo(r+1, c, time, lines)) {
			
			dfs(r+1, c, time+1, lines);
			check3 = true;
			
		} 
		if(canGo(r-1, c, time, lines)) {
			System.out.println(r+" "+c);
			dfs(r-1, c, time+1, lines);
			check3 = true;
		}
		
		if (jump(r, (c+1)%2, lines)) {
			if(canGo(r+K, (c+1)%2, time, lines)) {
				System.out.println(r+" "+c);
				dfs(r+K, (c+1)%2, time+1, lines);
				check3 = true;
			} 
		}
		
		
		
		if (!check3) {
			return;
		}
	}

	private static boolean jump(int r, int c, char[][] lines) {
		
		return lines[r][c] == '1';
	}

	private static boolean canGo(int r, int c, int time, char[][] lines) {
		if (r >= N) {
			clear = 1;
			return true;
		}
		
		if(r<0 || r < time || lines[r][c] == '0') return false;
		
		return true;
	}

}
