package BOJ;

import java.util.*;
import java.io.*;

public class Main_2529_부등호 {
	
	static char[] arr;
	static String[] p = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	static int k;
	static long max = -1;
	static long min = Long.MAX_VALUE;
	static String[] nums;
	static String maxStr = "";
	static String minStr = "";
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt();
		arr = new char[k];
		nums = new String[k+1];
		
		for (int i = 0; i < k; i++) {
			arr[i] = sc.next().charAt(0);
		}
		
		npr(0, 0);
		System.out.println(maxStr);
		System.out.println(minStr);
	}

	private static void npr(int cnt, int flag) {
		if (cnt == k+1) {
			for (int i = 0; i < k; i++) {
				if (arr[i] == '<') {
					int n1 = Integer.parseInt(nums[i]);
					int n2 = Integer.parseInt(nums[i+1]);
					if(n1 >= n2) return; // 부등호가 틀렸을 때 리턴
				}
				else if(arr[i] == '>'){
					int n1 = Integer.parseInt(nums[i]);
					int n2 = Integer.parseInt(nums[i+1]);
					if(n1 <= n2) return;
				}
			}
			// 부등호가 모두 맞았을 때
			String str = "";
			for (int j = 0; j < k+1; j++) {
				str += nums[j];
			}
			
			long temp = Long.parseLong(str);
			if(min > temp) {
				minStr = str;
				min = temp;
			}
			if (max < temp) {
				maxStr = str;
				max = temp;
			}
			return;
			
		}
		for (int i = 0; i < 10; i++) {
			if ((flag & 1<<i) != 0) continue;
			nums[cnt] = p[i];
			npr(cnt + 1, flag|1<<i);
		}	
	}
}
