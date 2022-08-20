package JUNGOL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class JUNGOL_1828_냉장고{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] tempers = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			tempers[i][0] = Integer.parseInt(st.nextToken());
			tempers[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tempers, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
				else return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int cnt = 1; // 시작
		// 최저 온도가 가장 낮은 물질의 온도
		int low = tempers[0][0]; //최저 온도
		int high = tempers[0][1]; // 최고 온도
		
		for (int i = 1; i < n; i++) {
			int tempL = tempers[i][0];
			int tempH = tempers[i][1];
			if(high < tempL) {  // 기준 물질 최저 < 비교 물질 적정 온도 < 기준 물질 최고
				cnt++; //냉장고 수 1대 증가
				low = tempL;
				high = tempH;
			}
			
			
		}
		System.out.println(cnt);
	}
	

}
