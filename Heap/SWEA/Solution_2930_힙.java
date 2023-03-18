import java.util.*;
import java.io.*;

// 메모리 100,384kb, 실행시간: 369ms

public class Solution_2930_힙 {

	static int N; // 수행해야 하는 연산 수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			sb.append("#" + t);
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				char cmd = st.nextToken().charAt(0);
				if (cmd == '1') { // 추가
					int addNum = Integer.parseInt(st.nextToken());
					pq.offer(-addNum);
				}
				else { // 빼기
					if(pq.isEmpty()) {
						sb.append(" " + -1);
					}else {
						sb.append(" " + -pq.poll());
					}
				}
			}
			sb.append(" \n");
		}
		System.out.println(sb);
	}
}
