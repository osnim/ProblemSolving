import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_7465_창용_마을_무리의_개수 {
	
	static int[] p;
	static int[] r;
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			p = new int[N+1];
			r = new int[N+1];
			int cnt = N;
			
			makeSet();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " "); 
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if (union(x, y)) cnt--; 
			}
			for (int i = 1; i <= N; i++) {
				p[i] = find(i);
			}
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(p[i]);
			}
			
			sb.append("#" + t + " " + set.size()+"\n");
		}
		System.out.println(sb);
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y ) return false;
		if(r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		}else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
	}
	
	private static int find(int x) {
		if(x == p[x]) return x;
		else return p[x] = find(p[x]);
	}

	private static void makeSet() {
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
		for (int i = 0; i <= N; i++) {
			r[i] = 1;
		}
	}

}
