package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Solution_4012_요리사 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[] bit = new int[N]; // np를 위한 {0,0,1,1} 만들기
 			int cnt = 1;
			for (int i = N/2; i < N; i++) {
				bit[i] = cnt;
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());  
				}
			}//입력 끝
			
			int count = 0;
			do {
				count++;
				// bit 가 0인 부분 팀 A
				// bit 과 1인 부분 팀 B
				int TeamA = 0;
				int TeamB = 0;
				System.out.println(Arrays.toString(bit));
				ArrayList<Integer> zeroes = new ArrayList<>();
				ArrayList<Integer> ones = new ArrayList<>();
			}while(np(N-1, bit));
		}
	}

	private static boolean np(int size, int[] bit) {
		int i = size;
		while(i > 0 && bit[i-1] >= bit[i])i--;
		if (i==0) return false;
		
		int j = size;
		while(bit[i-1] >= bit[j])j--;
		swap(i-1, j, bit);
		
		int k = size;
		while(i > k) swap(i++, k--, bit);
		return true;
	}

	private static void swap(int i, int j, int[] bit) {
		int temp = bit[i];
		bit[i] = bit[j];
		bit[j] = temp;
	}

}
