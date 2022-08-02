package algo0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2805_농작물_수확하기 {

	static int[][] arr;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[][] visited;
	static int N;
	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				char[] temp = str.toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = temp[j]-'0';
				}
			}//입력 끝
			int k = N/2;
			for (int i = 0; i <= N/2; i++) {
				for (int j = k; j < 2*i+1 + k; j++) {
					sum += arr[i][j];
				}
				k--;
			}
			
			k = 1;
			for (int i = 0; i < N/2 ; i++) {
				for (int j = k; j < 2*i ; j++) {
					sum += arr[i+N/2+1][j];
				}
				k++;
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}

	
	
}
