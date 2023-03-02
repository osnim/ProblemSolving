import java.io.*;
import java.util.*;

public class Main_9252_LCS2 {
	
	static String str1, str2;
	static int[][] dp, backTrace;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = " " + br.readLine();
		str2 = " " + br.readLine();
		
		int row = str1.length();
		int col = str2.length();
		
		dp = new int[row][col];
		backTrace = new int [row][col];
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1]+1;
					backTrace[i][j] = 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					backTrace[i][j] = dp[i-1][j] > dp[i][j-1] ? 2 : 3;
				}
			}
		}
		System.out.println(dp[row-1][col-1] + "\n" + getLCS(row-1,col-1));
	}

	private static String getLCS(int i, int j) {
		String ans = "";
		while (backTrace[i][j] != 0) {
			if (backTrace[i][j] == 1) {
				ans = str1.charAt(i) + ans;
				i--;
				j--;
			} else if (backTrace[i][j] == 2) { //위에서 가져옴
				i--;
			} else {
				j--;
			}
		}
		return ans;
	}
}
