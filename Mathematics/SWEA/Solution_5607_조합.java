import java.util.*;

public class Solution_5607_조합 {
	
	static long[] fact = new long[1000001];
	static long mod = 1234567891L;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		fact[0] = 1L;
		fact[1] = 1L;
		for (int i = 2; i <= 1000000; i++) {
			fact[i] = (i * fact[i-1]) % mod;
		}

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			long ans = 0;
			int N = sc.nextInt();
			int R = sc.nextInt();
			ans = fact[N] * power(fact[N-R], mod-2)% mod * power(fact[R], mod-2) % mod;
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static long power(long x, long y) {
		long res = 1L;
		x = x % mod;
		while(y > 0) {
			if (y % 2 == 1) {
				res = (res * x) % mod;
			}
			y = y >> 1;
			x = (x * x) %mod;
		}
		
		return res;
	}

}
