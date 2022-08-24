import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_집합의_표현 {
	
	static int[] p;
	static int[] r;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
	
		makeSet(N);
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (op == 0) {
				union(a, b);
			}
			else {
				if(find(a) == find(b)){
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb);
	}

	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return false; // 싸이클이 있다
		if (r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		} else {
			r[x] += r[y];
			p[y] = x;
		}
		return true;
		
	}

	private static int find(int x) {
		if(x == p[x]) return p[x];
		else return p[x] = find(p[x]); //부모의 부모를 찾음 > 최종 보스 찾음
	}

	private static void makeSet(int N) {
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		r = new int[N];
		for (int i = 0; i < N; i++) {
			r[i] = 1;
		}
	}

}
