import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {

	static char[][] map;
	static int R, C;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0,-1};
	static int maxCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		boolean[][] visited = new boolean[R][C];
		Stack<Character> stack = new Stack<>(); // 백트래킹을 위해
		HashMap<Character, Boolean> hashMap = new HashMap<>();
		ArrayList<Character> chList = new ArrayList<>();//출력을 위해
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
				hashMap.put(ch, false);
			}
		}
		
		//시작점은 스택에 넣고 visited도 true;
		hashMap.put(map[0][0], true); 
		visited[0][0] = true;
		maxCnt++;
		dfs(0,0,1,visited, hashMap);
		System.out.println(maxCnt);		

	}

	private static void dfs(int r, int c, int cnt, boolean[][] visited, HashMap<Character, Boolean> hashMap) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(!check(nr, nc, visited, hashMap)) {
				maxCnt = Math.max(maxCnt, cnt);
				continue;
			}

			visited[nr][nc] = true;
			char ch = map[nr][nc];
			hashMap.put(ch, true);
			dfs(nr, nc, cnt+1, visited, hashMap); 
			hashMap.put(ch, false);; // 백트래킹
			visited[nr][nc] = false;
		}		
	}

	private static boolean check(int nr, int nc, boolean[][] visited, HashMap<Character, Boolean> hashMap) {
		if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || hashMap.get(map[nr][nc])) {
			return false;
		}
		return true;
	}

}
