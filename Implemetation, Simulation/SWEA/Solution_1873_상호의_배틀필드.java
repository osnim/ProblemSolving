package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_1873_상호의_배틀필드 {
	
	static int H;
	static int W;
	static char[][] map;
	static char[] cmds;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static HashMap<Character, Integer> dirHM = new HashMap<>();
	static char dir;
	static int r;
	static int c;
	static int nr;
	static int nc;
 	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dirHM.put('U', 0);
		dirHM.put('R', 1);
		dirHM.put('D', 2);
		dirHM.put('L', 3);
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				String temp = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = temp.charAt(j);
					if(map[i][j] == '^') {dir = 'U'; r = i; c = j ;}
					else if(map[i][j] == 'v') {dir = 'D'; r = i; c = j;}
					else if(map[i][j] == '<') {dir = 'L'; r = i; c = j ;}
					else if(map[i][j] =='>') {dir = 'R'; r = i; c = j ;}
				} 
				//System.out.println(Arrays.toString(map[i]));
				
			}
			//System.out.println(dir);
			int N = Integer.parseInt(br.readLine());
			cmds = new char[N];
			cmds = br.readLine().toCharArray();
			//System.out.println(Arrays.toString(cmds));
			
			for (int cmd = 0; cmd < N; cmd++) {
				if(cmds[cmd] == 'U') up();
				else if(cmds[cmd] == 'R') right();
				else if(cmds[cmd] == 'D') down();
				else if(cmds[cmd] == 'L') left();
				else shoot();
				//System.out.println(cmds[cmd] + " " + map[r][c]+" "+ dir);
			}
			//System.out.print('#'+ t + " ");
			sb.append("#"+ t + " ");
			for (int i = 0; i < H; i++) {
				sb.append(map[i]).append("\n");
			} 
		}	
		System.out.println(sb);
	}
	private static void shoot() {
		if (dir == 'U') {
			int x = r-1;
			int y = c;
			while(x >= 0 &&(map[x][y] == '-' || map[x][y] == '.' || map[x][y] == '*')) {
				if(map[x][y] == '*') {
					map[x][y] = '.';
					break;
				}
				x--;
			}
		}
		if (dir == 'R') {
			int x = r;
			int y = c+1;
			while(y < W  &&(map[x][y] == '-' || map[x][y] == '.' || map[x][y] == '*')) {
				if(map[x][y] == '*') {
					map[x][y] = '.';
					break;
				}
				y++;
			}
		}
		if (dir == 'D') {
			int x = r+1;
			int y = c;
			while(x < H &&(map[x][y] == '-' || map[x][y] == '.' || map[x][y] == '*')) {
				if(map[x][y] == '*') {
					map[x][y] = '.';
					break;
				}
				x++;
			}
		}
		if (dir == 'L') {
			int x = r;
			int y = c-1;
			while(y >= 0 &&(map[x][y] == '-' || map[x][y] == '.' || map[x][y] == '*')) {
				if(map[x][y] == '*') {
					map[x][y] = '.';
					break;
				}
				y--;
			}
		}
	}
	private static void up() {
		dir = 'U';
		if(check()) { // 그 방향으로 갈 수 있다
			//현재 위치 평탄화
			map[r][c] = '.';
			r = nr; 
			c = nc;
			map[r][c] = '^';
		}
		else {
			map[r][c] = '^';
		}
		
	}
	private static void right() {
		dir = 'R';
		if(check()) { // 그 방향으로 갈 수 있다
			//현재 위치 평탄화
			map[r][c] = '.';
			r = nr; 
			c = nc;
			map[r][c] = '>';
		}
		else {
			map[r][c] = '>';
		}
	}
	private static void down() {
		dir = 'D';
		if(check()) { // 그 방향으로 갈 수 있다
			//현재 위치 평탄화
			map[r][c] = '.';
			r = nr; 
			c = nc;
			map[r][c] = 'v';
			
		}
		else {
			map[r][c] = 'v';
		}
		
	}
	private static void left() {
		dir = 'L';
		if(check()) { // 그 방향으로 갈 수 있다
			//현재 위치 평탄화
			map[r][c] = '.';
			r = nr; 
			c = nc;
			map[r][c] = '<';
			
		}
		else {
			map[r][c] = '<';
			
		}
		
	}
	
	public static boolean check() {
		nr = r+dr[dirHM.get(dir)];
		nc = c+dc[dirHM.get(dir)];
		
		if(nr < 0 || nr >= H || nc < 0 || nc >= W) return false;
		if(map[nr][nc] != '.') return false;
		
		return true;
	}

}
