package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_숨바꼭질 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
		int N = sc.nextInt();
		int K = sc.nextInt();
		if (N == K) {
			System.out.println(0);
			return;
		}
		int[] dp = new int[100001];
		
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(dp, -1);
		dp[N] = 0;
		q.offer(N);
		while(!q.isEmpty()) {
			int pos = q.poll();
			if(pos*2 < 100001) {
				if(dp[K] > -1)break;
				else if(dp[pos*2] == -1) {
					dp[pos*2] = dp[pos]+1;
					q.offer(pos*2);
				}
			}
			if(pos+1 < 100001) {
				if(dp[K] > -1)break;
				else if(dp[pos+1] == -1) {
					dp[pos+1] = dp[pos]+1;
					q.offer(pos+1);
				}
			}
			if(pos-1 > -1) {
				if(dp[K] > -1)break;
				else if(dp[pos-1] == -1) {
					dp[pos-1] = dp[pos]+1;
					q.offer(pos-1);
				}
			}
			
		}
		System.out.println(dp[K]);
	}

}
