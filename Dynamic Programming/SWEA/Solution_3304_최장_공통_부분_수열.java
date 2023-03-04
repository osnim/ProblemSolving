import java.io.*;
import java.util.*;

public class Solution_3304_최장_공통_부분_수열 {
	
	static String str1, str2;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			str1 = " " + st.nextToken();
			str2 = " " + st.nextToken();
			int row = str1.length();
			int col = str2.length();
			
			dp = new int[row][col];
			
			for (int i = 1; i < row; i++) {
				for (int j = 1; j < col; j++) {
					if(str1.charAt(i) == str2.charAt(j)) {
						dp[i][j] = dp[i-1][j-1]+1;
					}
					else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			
			sb.append("#" + t + " " + dp[row-1][col-1] + "\n");
		}
		System.out.println(sb);
	}
}
