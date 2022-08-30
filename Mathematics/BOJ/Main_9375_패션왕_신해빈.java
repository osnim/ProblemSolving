package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_9375_패션왕_신해빈 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hashMap = new HashMap<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				String type = st.nextToken();
				if (hashMap.get(type) != null) {
					hashMap.put(type, hashMap.get(type)+1);
				}else {
					hashMap.put(type, 1);
				}
			}// 입력 끝
			int total = 1;
			for (Integer cnt : hashMap.values()) {
				total *= (cnt+1);
			}
			System.out.println(total-1);
		}
	}
}
