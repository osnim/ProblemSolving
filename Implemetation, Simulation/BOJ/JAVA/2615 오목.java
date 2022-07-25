import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	static int N = 19;
	static int[][] map;
	static int []dr = { 0, -1,  1, -1, 1, -1, 1, 0}; //대칭 d <-> 7-d
	static int []dc = {-1, -1, -1,  0, 0,  1, 1, 1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new File("Test5.txt"));
		
		map = new int[N+2][N+2];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				map[i][j] = sc.nextInt();
			}
		}//읽기
		//로직
		for (int r = 1; r < N+1; r++) {
			for (int c = 1; c < N+1; c++) {
				//바둑알을 찾아서
				if(map[r][c] !=0) {
					//4방
					for (int d = 0; d < 4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						// 오목인지 찾으려는 반대 방향
						// 바둑알이 없거나 다른 색 바둑알
						//오목 방향이 오직 5개
						if((map[nr][nc]!= map[r][c]) // 색상이 다르다.
								&& (steps(map[r][c],r,c,7-d))) {// 같은색상이다
									//연속적으로 몇 개
							//출력
							System.out.println(map[r][c]);
							System.out.println(r +" "+c);
							return;
						}
					}
				}
			}
		}
		System.out.println("0");
	}
	// 5 6 7목 이든 0으로 채워 넣음 > 색상이 무조건 달라진다.
	private static boolean steps(int color, int r, int c, int d) {
		int cnt = 1;
		for (; color == map[r+dr[d]][c+dc[d]]; r+=dr[d], c+=dc[d]) {
			cnt ++;
		}
		return cnt == 5 ? true : false;
		
	}

}
