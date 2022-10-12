import java.io.*;
import java.util.*;

public class Solution_5643_키순서_DFS2 {
	
	static int N, M, cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			
			int[][] adjMatrix = new int[N+1][N+1]; //학생번호 1부터
			int[][] TransAdjMatrix = new int[N+1][N+1]; //학생번호 1부터, 자신보다 작은 경우
			
			StringTokenizer st = null;
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; //a < b
				TransAdjMatrix[b][a] = 1; //a > b
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				DFS(i, adjMatrix, new boolean[N+1]);
				DFS(i, TransAdjMatrix, new boolean[N+1]);				
				if(cnt == N-1) ans++;
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	
	static void DFS(int cur, int[][] matrix, boolean[]  visited) { // cur 현재 정점, cur 학생보다 키가 큰 학생따라 탐색
 		visited[cur] = true;
		for (int i = 1; i <= N; i++) { //자신의 인접행렬 들여다보기
			if(matrix[cur][i] == 1 && !visited[i]) { // i가 cur보다 키가 크고(또는 작은) 아직 탐색하지 않았다면
				cnt++;			//나 보다 큰 학생 카운트
				DFS(i, matrix, visited);
			}
		}
	}

}
