import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_미세먼지_안녕2 {

	static class Dust{
		int r;
		int c;
		int size;
		
		public Dust(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}
	
	static int[] dr = {-1, 0, 1, 0}; //시계 방향
	static int[] dc = {0, 1, 0, -1};
	
	static int R, C, T;
	static int[][] map;
	static int[][] newMap;
	static int mr1 = -1, mr2 = -1; //공기청정기의 행 
	static Queue<Dust> q;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == -1) {
					 if (mr1 == -1) {
						mr1 = i;
					}else mr2 = i;
				}
				else{
					q.add(new Dust(i, j, temp));
				}
				map[i][j] = temp;
			}
		}// 입력 끝
		
		for (int t = 0; t < T; t++) {
			newMap = new int[R][C]; // 임시 저장
			//1. 미세먼지 확산
			spread();
			copyMap(); // 확산 된 맵 복사
			
			cleaning(); //2. 공기청정기 작동
			
			//3. 맵에 저장 된
			q = new LinkedList<>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						q.add(new Dust(i, j, map[i][j]));
					}
				}
			}
		}
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					result += map[i][j];
				}
			}
		}
		System.out.println(result);
	}

	private static void cleaning() {
		//1. 윗 부분
		rotate1(map);
		
		//2. 아랫 부분
		rotate2(map);
	}

	private static void rotate2(int[][] tempMap) {
		for (int i = mr2+1; i < R; i++) { //왼쪽
			tempMap[i-1][0] = tempMap[i][0];
		}
		for (int j = 1; j < C ; j++) { //아래쪽
			tempMap[R-1][j-1] = tempMap[R-1][j];
		}
		for (int i = R-2; i >= mr2; i--) { //오른쪽
			tempMap[i+1][C-1] = tempMap[i][C-1];
		}
		for (int j = C-2; j >= 1; j--) { //위쪽
			tempMap[mr2][j+1] = tempMap[mr2][j];
		}
		tempMap[mr2][1] = 0;
		tempMap[mr2][0] = -1;
	}


	private static void rotate1(int[][] tempMap) {
		for (int i = mr1-1; i > -1; i--) { //왼쪽
			tempMap[i+1][0] = tempMap[i][0];
		}
		for (int j = 1; j < C; j++) { //위쪽
			tempMap[0][j-1] = tempMap[0][j];
		}
		for (int i = 1; i <= mr1; i++) { //오른쪽
			tempMap[i-1][C-1] = tempMap[i][C-1];
		}
		for (int j = C-2; j > 0 ; j--) { //아래쪽
			tempMap[mr1][j+1] = tempMap[mr1][j];
		}
		tempMap[mr1][1] = 0;
		tempMap[mr1][0] = -1;
	}

	private static void copyMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = newMap[i][j];
			}
		}
	}

	private static void spread() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Dust dust = q.poll();
			// 확산이 가능한 먼지들
			int tempSize = 0;
			for (int d = 0; d < 4; d++) { //4방향 확산
				int nr = dust.r + dr[d]; 
				int nc = dust.c + dc[d];
				
				// 인접한 곳 청정기 있거나 칸 없으면 확산 x
				if (!check(nr, nc)) continue; 
				if(map[nr][nc] == -1) continue;
				if (dust.size < 5) continue;
				newMap[nr][nc] += dust.size/5;
				tempSize++; 
			}
			dust.size -= (dust.size/5)*tempSize;		// 나머지
			newMap[dust.r][dust.c] += dust.size;
		}
		newMap[mr1][0] = -1;
		newMap[mr2][0] = -1;
	}

	private static boolean check(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) return true;
		return false;
	}

}
