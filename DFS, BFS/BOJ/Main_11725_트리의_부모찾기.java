package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11725_트리의_부모찾기 {
	
	static boolean[] visited;
	static int[] p;
	static int N;
	
	static List<Integer>[] adjList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		visited = new boolean[N+1];
		p = new int[N+1];
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}
		
		visited[1] = true; //루트는 1
		p[1] = 1;
		dfs(1);
		
		for (int i = 2; i <= N; i++) {
			sb.append(p[i]+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int parent) {
		int size = adjList[parent].size();
		if (size == 0) {
			return;
		}
		
		for (int j = 0; j < size; j++) {
			int child = adjList[parent].get(j);
			if (visited[child]) continue;
			visited[child] = true;
			p[child] = parent;
			dfs(child);
		}
	}
}
