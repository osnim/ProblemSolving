import java.io.*;
import java.util.*;

public class Main_맥주_마시면서_걸어가기 {

	static int N;
	static int destx, desty;
	static String ans;
	static class Store {
		int x;
		int y;
		public Store(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static List<Store> stores;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			ans = "sad";
			N = sc.nextInt();;
			stores = new ArrayList<>();
			visited = new boolean[N]; // i번째 편의점을 방문했는지 체크
			int hx = sc.nextInt();
			int hy = sc.nextInt();
			for (int i = 0; i < N; i++) {
				stores.add(new Store(sc.nextInt(), sc.nextInt()));
			}
			destx = sc.nextInt();
			desty = sc.nextInt();
			
			bfs(hx, hy);
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int hx, int hy) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {hx, hy});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			if (calDistance(cx, cy, destx, desty) <= 1000) {
				ans = "happy";
				return;
			}
			
			for (int i = 0; i < N; i++) {
				if (visited[i]) continue; //이미 방문한 편의점
				if (calDistance(cx, cy, stores.get(i).x, stores.get(i).y) > 1000 ) continue;
				q.offer(new int[] {stores.get(i).x, stores.get(i).y});
				visited[i] = true;
			}
		}
	}

	private static int calDistance(int cx, int cy, int sx, int sy) {
		return Math.abs(cx - sx) + Math.abs(cy - sy);
	}

}