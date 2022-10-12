import java.io.*;
import java.util.*;

public class Solution_5643_키순서_DFS1 {
	
	static int N, M, adjMatrix[][];
	static int gtCnt, ltCnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			
			adjMatrix = new int[N+1][N+1]; //학생번호 1부터
			
			StringTokenizer st = null;
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; //a < b
			}
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				gtCnt = ltCnt = 0;
				gtDFS(i, new boolean[N+1]);
				ltDFS(i, new boolean[N+1]);
				if(gtCnt + ltCnt == N-1) ans++;
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	
	static void gtDFS(int cur, boolean[]  visited) { // cur 현재 정점, cur 학생보다 키가 큰 학생따라 탐색
 		int cnt = 0; // 나보다 큰 학생 수
		
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) { //자신의 인접행렬 들여다보기
			if(adjMatrix[cur][i] == 1 && !visited[i]) { // i가 cur보다 키가 크고 아직 탐색하지 않았다면
				gtCnt++;			//나 보다 큰 학생 카운트
				gtDFS(i, visited);
			}
		}
	}
	
	static void ltDFS(int cur, boolean[] visited) { //start 학생부터 자신보다 키가 작은 학생 따라 탐색
		int cnt = 0; // 나보다 큰 학생 수
		
		visited[cur] = true;
		
		for (int i = 1; i <= N; i++) { //인접행렬에서 자신의 열로 간선 정보를 갖고 있는 정점 들여다보기
			if(adjMatrix[i][cur] == 1 && !visited[i]) { // i가 cur보다 키가 작고 아직 탐색하지 않았다면
				ltCnt++;			//나 보다 작은 학생 카운트
				ltDFS(i, visited);
				
			}
		}
	}

}
