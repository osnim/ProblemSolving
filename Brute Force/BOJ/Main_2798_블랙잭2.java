package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2798_블랙잭2 {

	static int[] arr;
	static int N;
	static int M;
	static int[] nums;
	static int max = -1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		nums = new int[3];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		nCr(0,0);
		System.out.println(max);
	}

	private static void nCr(int start, int cnt) {
		int sum = 0;
		if (cnt == 3) {
			for (int i = 0; i < 3; i++) {
				sum += nums[i];
			}
			 
			if(sum <= M) {
				max = Math.max(max, sum);
				System.out.println(Arrays.toString(nums) +" " + sum);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			nums[cnt] = arr[i];
			nCr(i+1, cnt+1);
			nums[cnt] = 0;
		}
	}
}
