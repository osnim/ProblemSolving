package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17406_배열_돌리기4 {
	static int N,M,K;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] ops = new int[K][3]; 
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) 
				ops[k][i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		boolean[] visited = new boolean[K];
		npr(0, visited, map, ops);
		System.out.println(min);
	}

	private static void npr(int cnt, boolean[] visited, int[][] map, int[][] ops) {
		if (cnt == K) {
			for (int i = 0; i < N; i++) {
				int sum = 0;//행렬 A의 값
				for (int j = 0; j < M; j++) {
					sum += map[i][j];
				}
				if(min > sum) {
					min = sum;
				}
			}
			return;
		}
		
		for (int k = 0; k < K; k++) {
			if(visited[k]) continue;
			visited[k] = true;
			
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = map[i][j]; 
				} 
			}//복사
			
			rotate(temp, 1, ops[k]);
			npr(cnt+1, visited, temp, ops);	
			visited[k] = false;
		}
	}

	private static void rotate(int[][] map, int R, int[] ops) {
		int r1 = ops[0]-ops[2]-1;
		int c1 = ops[1]-ops[2]-1;
		int r2 = ops[0]+ops[2]-1;
		int c2 = ops[1]+ops[2]-1;
		
		int start = Math.min(r2-r1, c2-c1)/2;
		//테두리 1차원으로 펴기 
		for (int i = 0; i < start; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			
			//윗변
			for (int c = c1; c < c2; c++) list.add(map[r1][c]);
			//우측변
			for (int r = r1; r < r2; r++) list.add(map[r][c2]);
			//아랫변
			for (int c = c2; c > c1; c--) list.add(map[r2][c]);
			//좌측변
			for (int r = r2; r > r1; r--) list.add(map[r][c1]);
			int[] arr = new int[list.size()];
			
			//CW회전
			for (int j = 0; j < list.size(); j++) 
				arr[(j+1)%list.size()] = list.get(j);
			//다시 넣기
			//윗변
			int cnt = 0;
			for (int c = c1; c < c2; c++) {
				map[r1][c]= arr[cnt];
				cnt++;
			}
			//우측변
			for (int r = r1; r < r2; r++) {
				map[r][c2] = arr[cnt];
				cnt++;
			}
			//아랫변
			for (int c = c2; c > c1; c--) {
				map[r2][c]= arr[cnt];
				cnt++;
			}
			//좌측변
			for (int r = r2; r > r1; r--) {
				map[r][c1]= arr[cnt];
				cnt++;
			}
			r1 += 1;
			c1 += 1;
			r2 -= 1; //바운더리
			c2 -= 1; //바운더리
		}
	}
}
