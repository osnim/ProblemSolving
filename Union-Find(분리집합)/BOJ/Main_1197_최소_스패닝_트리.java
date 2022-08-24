import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_최소_스패닝_트리 {

	static class Edge{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int[] p;
	static int[] r;
	static int V, E;
	static Edge[] Edges;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		p = new int[V+1];
		r = new int[V+1];
		makeSet();
		
		int ans = 0;	
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		
		//Edges = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			 st = new StringTokenizer(br.readLine());
			 int f = Integer.parseInt(st.nextToken());
			 int t = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(f, t, w));
		}
		
		int cnt = 0;
		
		for (int i = 0; i < E; i++) {
			Edge e = pq.poll();
			if(find(e.from) == find(e.to)) continue; 
			ans += e.weight;
			union(e.from, e.to);
			cnt++;
			if(cnt == V-1) break;
		}
		System.out.println(ans);
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
		else return p[x] = find(p[x]);//부모의 부모를 찾음 > 최종 보스 찾음
	}

	private static void makeSet() {
		p = new int[V+1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		r = new int[V+1];
		for (int i = 1; i <= V; i++) {
			r[i] = 1;
		}
	}

}
