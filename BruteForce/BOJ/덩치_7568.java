package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 덩치7568 {
	
	static int [][] map;
	static int [] result; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stz;
		map= new int [n][2];
		result = new int [n];
		Arrays.fill(result, 1);
		
		for (int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(stz.nextToken());
			map[i][1] = Integer.parseInt(stz.nextToken());
		}
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (map[i][0] < map[j][0] && map[i][1] < map[j][1]) {
					result[i]++;
				}
				else if(map[i][0] > map[j][0] && map[i][1] > map[j][1]) {
					result[j]++;
				}
			} 
		}
		for (int r : result) {
			System.out.println(r);
		}
	}

}
