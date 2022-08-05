package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와_BFS {
	
	static int N, M, V;
	static int[][] map;
	static int[] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static StringBuilder sb;
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new int[N+1];
		sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			map[n1][n2] = 1;
			map[n2][n1] = 1;
		}//입력 끝
		DFS(V);
		
		visited = new int[N+1];
		sb.append('\n');
		BFS(V);
		System.out.println(sb);
	}

	private static void BFS(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = 1;
		sb.append(start +" " );
		while(!q.isEmpty()) {
			int s = q.poll();
			for (int i = 1; i <= N; i++) {
				if(visited[i] == 1 || map[s][i] == 0) continue;
				visited[i] = 1;
				q.offer(i);
				sb.append(i +" " );
			}
		}
	}

	private static void DFS(int s) {
		if(s > N ) return;
		
		sb.append(s+" ");
		visited[s] = 1;
		
		for (int i = 1; i <=N ; i++) {
			if(visited[i]==1) continue;
			if(map[s][i] == 0) continue;
			DFS(i);
		}
		
	}

}
