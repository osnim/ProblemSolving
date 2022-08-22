package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {

	static int [][] map;
	static boolean []visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken())-1;
			
			map= new int[100][100];
			visited = new boolean[100];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				
				map[from][to] = 1;
			}
			
			int last = bfs(start);
			
			sb.append("#" + t + " " + last + "\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		visited[start] = true;
		q.offer(new int[] {start, 0});
		
		int maxLast = start;
		int maxDepth = 0;
		
		while (!q.isEmpty()) {
			int cur[]  = q.poll();
			int from = cur[0];	// 시작점
			int depth = cur[1]; // 너비
			
			for (int c = 0; c < 100; c++) {
				if (map[from][c] == 0 || visited[c]) continue;
				else {
					
					if (maxDepth < depth+1) { // 이전 단계보다 높고 값도 크다면
						maxDepth = depth+1;
						maxLast = c+1;
						
					}else if(maxDepth == depth+1) {
						maxLast = Math.max(maxLast, c+1);
					}
					
					
					q.offer(new int[] {c, depth+1});
					visited[c] = true;
				}
			}
			
		}
		
		return maxLast;
	}

}
