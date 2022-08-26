import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2098_외판원_순회_DP {

	static int N;
	static int[][] dist;
	static int[][] dp;
	static int min;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		dist = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE/100;
		dp = new int[1<<N][N]; // 도시방문 상황을 비트 연산자로 체크 
		// 010111 이면 XEXCBA를 갔다는 것을 표시 하지만 AB인지 BA인지 모름
		for (int i = 0; i < 1<<N; i++) {
			Arrays.fill(dp[i], -1);
		}
		min = tsp(1,0); // 첫번째(0) 도시를 1 방문하면서 시작
		System.out.println(min);
	}

	private static int tsp(int visited, int city) {
		// 모든 도시를 방문했다.
		if (visited ==(1<<N) -1) { //11111....
			//연결 되어 있나
			if (dist[city][0] == 0) return Integer.MAX_VALUE/100;
			return dist[city][0];
		}
		
		if(dist[visited][city] != -1) {//방문 한 적 있다.
			return dist[visited][city];
		}
		
		for (int i = 0; i < N; i++) { //순열 처럼
			if((visited & (1<<i))!=0) continue; //방문 한 적이 있다.
			if((dist[city][i])==0) continue; // 연결 안되고
			// i 도시 방문 체크, city -> i 
			int result = tsp(visited | (1<<i), i) + dist[city][i];
			// AEDBCA다음 ADEBCA를 할 때 ACB를 구하면 또 구할 필요 없다   
			dist[visited][city] = Math.min(result, dist[visited][city]);
		}
		
		return dist[visited][city];
	}

}
