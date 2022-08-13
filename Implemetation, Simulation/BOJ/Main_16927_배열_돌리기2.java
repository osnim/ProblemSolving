package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16927_배열_돌리기2 {
	static int N,M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝
		
		rotate(map, R);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] +" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	
	private static void rotate(int[][] map, int R) {
		
		int start = Math.min(N, M)/2;
		//테두리 1차원으로 펴기 
		for (int i = 0; i < start; i++) {
			
			int r1 = i;
			int r2 = N-1-i;
			int c1 = i;
			int c2 = M-1-i;
			
			int size = 2*(r2-r1) + 2*(c2-c1); // 테두리 개수
			int cnt = 0;
			int[] arr = new int[size];
			int dis = R%size; // 이동 거리
			//윗변
			for (int c = c1; c < c2; c++) {
				arr[(size+(cnt-dis))%size] = map[r1][c];
				cnt++;
			} 
				
			//우측변
			for (int r = r1; r < r2; r++) {
				arr[(size+(cnt-dis))%size] = map[r][c2];
				cnt++;
			}
				
			//아랫변
			for (int c = c2; c > c1; c--) {
				arr[(size+(cnt-dis))%size] = map[r2][c];
				cnt++;
			}
				
			//좌측변
			for (int r = r2; r > r1; r--) {
				arr[(size+(cnt-dis))%size] = map[r][c1];
				cnt++;	
			}
			
			//다시 넣기
			//윗변
			cnt = 0;
			for (int c = c1; c < c2; c++) {
				map[r1][c]= arr[cnt];
				cnt++;
			}
			//우측변
			for (int r = r1; r < r2; r++) {
				map[r][c2] = arr[cnt];
				cnt++;
			}
			//아랫변
			for (int c = c2; c > c1; c--) {
				map[r2][c]= arr[cnt];
				cnt++;
			}
			//좌측변
			for (int r = r2; r > r1; r--) {
				map[r][c1]= arr[cnt];
				cnt++;
			}
		}
	}
}
