import java.util.*;
import java.io.*;

public class Solution_5643_키_순서 {

	static int N, M; //학생 수, 비교 수
	static int[][] adjMatrix;
	static int[][] TransAdjMatrix; //adjMatrix를 뒤집음
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			adjMatrix = new int[N][N];
			TransAdjMatrix = new int[N][N];
			int count = N;
			for (int i = 0; i < N; i++) {
				Arrays.fill(adjMatrix[i], N+1);
				//Arrays.fill(dp[i], N+1);
			}
			
			for (int i = 0; i < M; i++) {
				int start = sc.nextInt()-1;
				int end = sc.nextInt()-1;
				adjMatrix[start][end] = 1;
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i == j) continue;
						adjMatrix[i][j] = Math.min(adjMatrix[i][k]+adjMatrix[k][j], adjMatrix[i][j]);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					TransAdjMatrix[i][j] = adjMatrix[j][i]; //전치 행렬
				}
			}
			
			for (int i = 0; i < N; i++) {
				Queue<Integer> q = new LinkedList<>();
				boolean[] visited = new boolean[N];
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					if (adjMatrix[i][j] != N+1) { //자신들 보다 큰 경우, 이미 계산 가능하므로 체크 X
						visited[j] = true;
						continue;
					}
					q.offer(j);
				}
				bfs(i, q, visited);
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					if (visited[j] == false) {
						count--;// 자기 등급 정확히 모름
						break;
					}
				}
				
			}
			sb.append("#" + t + " " + count + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int start, Queue<Integer> q, boolean[] visited) {
		while(!q.isEmpty()) {
			int end = q.poll();
			if (visited[end]) continue;
			if (TransAdjMatrix[start][end] != N+1 ) {//start보다 작은 경우
				q.offer(end);
				visited[end] = true;
			}
		}
	}
}
