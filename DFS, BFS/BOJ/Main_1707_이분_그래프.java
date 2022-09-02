package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1707_이분_그래프{
	
	static class Node{
		int from;
		int to;
		
		public Node(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	static int V, E;
	static List<Integer>[] adjList;
	static int[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adjList = new ArrayList[V+1];
			for (int i = 0; i < V+1; i++) {
				adjList[i] = new ArrayList<>();	
			}
			
			visited = new int[V+1];
			Arrays.fill(visited, -1);
					
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from].add(to);
				adjList[to].add(from);
			}
			
			for (int i = 1; i < V+1; i++) {
				if (visited[i] == -1) {
					visited[i] = 0; 
					DFS(i);	
				}
				
			}
			if(isBiparties()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

	private static boolean isBiparties() {
		for (int i = 1; i < V+1; i++) {
			for (int j = 0, size = adjList[i].size(); j < size; j++) {
				int idx =  adjList[i].get(j);
				if (visited[i] == visited[idx]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void DFS(int i) {
		//연결된 점만 방문
		for (int j = 0, size = adjList[i].size(); j < size; j++) {
			int idx = adjList[i].get(j);
			if (visited[idx] == -1) {
				if (visited[i] == 0) {
					visited[idx] = 1;
				} else {
					visited[idx] = 0;
				}
				//요소별로 방문
				DFS(idx);
			}
		}
	}
}
