import java.io.*;
import java.util.*;

public class Solution_5643_키순서_Floyd {
	
	static int N, M, cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			
			int[][] adjMatrix = new int[N+1][N+1]; //학생번호 1부터
			
			for (int i = 1; i <= N; i++) adjMatrix[i][0] = -1; //탐색하지 않은 초기 값
			StringTokenizer st = null;
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1; //a < b
			}
			
			int ans = 0;
			for (int k = 1; k <= N; k++) { //경유
				for (int i = 1; i <= N; i++) { //출발 
					if (i == k) continue;
					for (int j = 1; j <= N; j++) { //도착
						if(adjMatrix[i][j] == 1)continue;
						adjMatrix[i][j] = adjMatrix[i][k] & adjMatrix[k][j];
					}
				}
			}
			
			//모든 정점이 알고 있는 관계로 탐색을 마친 상태 (큰 정점을 따라 탐색해서 간접관계를 직접관계로 다 반영해서 인접행렬로 update)
			//열 기준 정보를 확인하면 자신보다 작은 정점을 파악 가능
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adjMatrix[i][0] += adjMatrix[i][j];// i보다 큰 j가 카운트에 누적
					adjMatrix[0][j] += adjMatrix[i][j];// j보다 작은 i가 카운트에 누적
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(adjMatrix[i][0] + adjMatrix[0][i] == N-1) ans ++;
			}
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	} 
	
	static void DFS(int cur, int[][] adjMatrix) { // cur 현재 정점, cur 학생보다 키가 큰 학생따라 탐색
 		for (int i = 1; i <= N; i++) { //자신의 인접행렬 들여다보기
			if(adjMatrix[cur][i] == 1) {
				if (adjMatrix[i][0] == -1) DFS(i, adjMatrix); //나보다 큰 i가 탐색을 하지 않은 상태
				
				//나보다 큰 정점의 탐색 정보를 메모
				if (adjMatrix[i][0] > 0) { // i 보다 큰 정점이 존재 : cur < i < j 를 만족하는 j 존재 ==> cur < j 상태로 메모
					for (int j = 1; j <= N; j++) {
						if (adjMatrix[i][j] == 1) adjMatrix[cur][j] = 1;
					}
				}
			}
		}
 		//자신 보다 큰 정점의 탐색을 모두 완료 메모
 		int cnt = 0;
 		for (int k = 1; k <= N; k++) cnt += adjMatrix[cur][k]; // 1의 개수 만큼 더해짐
 		
 		adjMatrix[cur][0] = cnt;
	}

}
