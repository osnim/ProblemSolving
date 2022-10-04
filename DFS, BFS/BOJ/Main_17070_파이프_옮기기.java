import java.util.*;
import java.io.*;

public class Main_17070_파이프_옮기기{

	static class Pipe{
		int r1; 
		int c1;
		int r2;
		int c2;
		int d;
		
		public Pipe(int r1, int c1, int r2, int c2, int d) {
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
			this.d = d;
		}
	}
	static int N;
	static int[][] map;
	static int[] dr = {0, 1, 1}; // →, ↘, ↓ 
	static int[] dc = {1, 1, 0};
	
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(new Pipe(0, 0, 0, 1, 0));
		System.out.println(count);
	}

	private static void dfs(Pipe pipe) {
		if(pipe.r2 == N-1 && pipe.c2 == N-1) {
			count++;
			return;
		}
		
		//현재 방향이 오른쪽
		if (pipe.d == 0) {
			//가능한 방향 2가지
			//오른쪽, 대각
			for (int i = 0; i < 2; i++) {
				Pipe newPipe = new Pipe(pipe.r2, pipe.c2, pipe.r2+dr[i], pipe.c2+dc[i], i);
				if(!check(newPipe.r1, newPipe.c1, newPipe.r2, newPipe.c2)) continue; //나가는 것 체크
				if (map[newPipe.r1][newPipe.c1] == 1 || map[newPipe.r2][newPipe.c2] == 1) continue;
				if (i == 1) {
					if(!dir2Check(newPipe.r2, newPipe.c2)) continue; // 대각일때 3방향에 벽이 없는 경우
				}				
				dfs(newPipe);
				
			}
		}
		
		//현재 방향이 대각
		else if(pipe.d == 1) {
			for (int i = 0; i < 3; i++) {
				Pipe newPipe = new Pipe(pipe.r2, pipe.c2, pipe.r2+dr[i], pipe.c2+dc[i], i);
				if(!check(newPipe.r1, newPipe.c1, newPipe.r2, newPipe.c2)) continue; //나가는 것 체크
				if (map[newPipe.r1][newPipe.c1] == 1 || map[newPipe.r2][newPipe.c2] == 1) continue;
				if (i == 1) {
					if(!dir2Check(newPipe.r2, newPipe.c2)) continue; // 대각일때 3방향에 벽이 없는 경우
				}				
				dfs(newPipe);	
			}
			
		}
		
		//현재 방향이 아래
		else{
			for (int i = 1; i <= 2; i++) {
				Pipe newPipe = new Pipe(pipe.r2, pipe.c2, pipe.r2+dr[i], pipe.c2+dc[i], i);
				if(!check(newPipe.r1, newPipe.c1, newPipe.r2, newPipe.c2)) continue; //나가는 것 체크
				if (map[newPipe.r1][newPipe.c1] == 1 || map[newPipe.r2][newPipe.c2] == 1) continue;
				if (i == 1) {
					if(!dir2Check(newPipe.r2, newPipe.c2)) continue; // 대각일때 3방향에 벽이 없는 경우
				}
				dfs(newPipe);	
			}
		}
	}

	private static boolean dir2Check(int nr, int nc) {
		if ( map[nr-1][nc] == 1 || map[nr][nc] == 1 || map[nr][nc-1] == 1 ) return false;
		return true;
	}

	private static boolean check(int nr1, int nc1, int nr2, int nc2) {
		return (nr1 >= 0 && nc1 >= 0 && nr2 >= 0 && nc2 >= 0 && 
				nr1 < N && nc1 < N && nr2 < N && nc2 < N);
	}
}
