package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683_감시 {

	static public class CCTV{
		int r;
		int c;
		int t;
		
		public CCTV(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	
	static int[][][] cctvType = {
    		{},
    		{{0}, {1}, {2}, {3}},
    		{{0,2}, {1, 3},},
    		{{0, 1},{1, 2},{2, 3},{3, 0}},
    		{{0, 1, 2},{1, 2, 3},{2, 3, 0},{3, 0, 1}},
    		{{0, 1, 2, 3}},
    };
	
	static int N, M;
    static int[][] map;
    static List<CCTV> cctvList;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int cctvCnt;
    static int zeroCnt;
    static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M]; 
        cctvList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int type = Integer.parseInt(st.nextToken());
                map[i][j] = type;
                if (type == 6) continue;
                if (type == 0) {
                	zeroCnt++;
                	continue;
                }
                cctvList.add(new CCTV(i, j, type));
            }
        }
        
        cctvCnt = cctvList.size();
        dfs(0, 0, map);
        System.out.println(ans);
        
	}

	private static void dfs(int cctvIdx, int cnt, int[][] map2) {
		if (cctvIdx == cctvCnt) {
			ans = Math.min(zeroCnt-cnt, ans);
            return;
			
		}
		
		int[][] tempMap = new int[N][M];
		copy(tempMap, map2);
		CCTV cctv = cctvList.get(cctvIdx);
		
		for (int[] types : cctvType[cctv.t]) {
			int temp = 0;
			for (int t : types) {
				temp += observeRange(cctv.r, cctv.c, t, tempMap);
			}
			dfs(cctvIdx+1, cnt+temp, tempMap);
			copy(tempMap, map2);
		}
	}
	
	private static void copy(int[][] tempVisited, int[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempVisited[i][j] = visited[i][j];
            }
        }
    }

    private static int observeRange(int r, int c, int d, int[][] map2) {
        int observeCnt = 0;
        
        while(true) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            int flag = check(nr, nc, map2);
            if (flag == 0) {
				break;
			} else if(flag == 2){
				observeCnt ++;
				map2[nr][nc] = 7;
			}
           
            r = nr;
            c = nc;
            
        }
        return observeCnt;
    }

    private static int check(int nr, int nc, int[][] map2) {
        if (nr < 0 || nr >= N || nc < 0|| nc >= M || map2[nr][nc] == 6) {
            return 0;
        }
        
        // 다른 CCTV를 만났거나 다른 cctv가 감시한 범위라면
        else if( (1 <= map[nr][nc] && map[nr][nc] <= 5) || map2[nr][nc] == 7) {
        	return 1;
        }
        
        return 2;
    }
}
