import java.io.*;
import java.util.*;

public class Solution_4014_활주로_건설 {

	static int N, X, map[][];
	static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			X = sc.nextInt();
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			ans = 0;
			
			for (int j = 0; j < N; j++) {
				checkCol(j); // 1열 부터 체크
			}
			
			for (int i = 0; i < N; i++) {
				checkRow(i); // 1행 부터 체크
			}
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	private static void checkRow(int i) {
		boolean[] visited = new boolean[N];
		int cnt = 1;
		for (int j = 0; j < N-1; j++) {
			if (Math.abs(map[i][j] - map[i][j+1]) > 1) {
				cnt=0;
				break;
			}
			if (map[i][j] - map[i][j+1] == 1) { // 왼쪽이 큰 경우
				// 밖에 나가는 경우 
				if (j+X >= N) { 
					cnt=0;
					break;
				}

				//이미 설치된 경우
				if(isVisited(visited, j+1, j+X)) {
					cnt=0;
					break;
				}

				//위 2개다 아닌 경우 설치 가능
				put(visited, j+1, j+X);
				
			} else if(map[i][j+1] - map[i][j] == 1) { //오른쪽이 큰 경우
				// 밖에 나가는 경우 
				if (j+1-X < 0) {
					cnt=0;
					break;
				}

				//이미 설치된 경우
				if(isVisited(visited, j+1-X, j)) {
					cnt=0;
					break;
				}

				//위 2개다 아닌 경우 설치 가능
				put(visited, j+1-X, j);
			}
		}
		ans += cnt;
	}

	private static void checkCol(int j) {
		boolean[] visited = new boolean[N];
		int cnt = 1;
		for (int i = 0; i < N-1; i++) {
			if (Math.abs(map[i][j] - map[i+1][j]) > 1) {
				cnt=0;
				break;
			}
			
			if (map[i][j] - map[i+1][j] == 1) { // 위에가 큰 경우
				// 밖에 나가는 경우 
				if (i+X >= N) { 
					cnt=0;
					break;
				}

				//이미 설치된 경우
				if(isVisited(visited, i+1, i+X)) {
					cnt=0;
					break;
				}

				//위 2개다 아닌 경우 설치 가능
				put(visited, i+1, i+X);
				
			} else if(map[i+1][j] - map[i][j] == 1) { //아래가 큰 경우
				// 밖에 나가는 경우 
				if (i+1-X < 0) {
					cnt=0;
					break;
				}

				//이미 설치된 경우
				if(isVisited(visited, i+1-X, i)) {
					cnt=0;
					break;
				}

				//위 2개다 아닌 경우 설치 가능
				put(visited, i+1-X, i);
			}
		}
		ans += cnt;
	}

	private static void put(boolean[] visited, int start, int end) {
		for (int i = start; i <= end; i++) {
			visited[i] = true;
		}
	}

	private static boolean isVisited(boolean[] visited, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (visited[i]) {
				return true;
			}
		}
		return false;
	}
}
