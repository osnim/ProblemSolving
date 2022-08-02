package algo0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	
	static int dir = 0; 
	static int[][] arr;
	static int r; 
	static int c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			r = 99;
			c = 0;
			arr = new int[100][100];
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			for (int j = 0; j < 100; j++) {
				if(arr[r][j] == 2) {
					c = j;
					break;
				}
			}
			
			while(r > 0) {
				r--;
				goCheck(); 
			}
			System.out.println("#"+t+" "+ c);
		}
	}
	public static void goCheck() {
		if(c-1 >= 0 && arr[r][c-1] == 1) {
			while(c-1 >= 0 && arr[r][c-1] == 1) {
				c--;
			}
			return;
		}
		else if (c+1 < 100 && arr[r][c+1] == 1) {
			while(c+1 < 100 && arr[r][c+1] == 1) {
				c++;
			}
			return;
		}
	}
}
