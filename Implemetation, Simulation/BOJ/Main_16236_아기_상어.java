import java.io.*;
import java.util.*;

public class Main_16236_아기_상어 {
	
	static class Baby{
		int r;
		int c;
		int size;
		int eatCnt;
		
		public Baby(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}
	
	static class Fish{
		int r;
		int c;
		int size;
		int cnt;
		
		public Fish(int r, int c, int size, int cnt) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Fish [r=" + r + ", c=" + c + ", size=" + size + ", cnt=" + cnt + "]";
		}
	}
	
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static Baby baby;
	static List<Fish> Fishes;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static int fishCnt;
	static int time;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		//Fishes = new ArrayList<Fish>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken()); 
				if (input == 9) {
					baby = new Baby(i,j,2);
					continue;
				}
				else if(1<= input && input <=6) {
					fishCnt++;
				}
				map[i][j] = input;
			}
		}// 입력 끝
		
		while(true) {
			visited = new boolean[N][N];
			
			if (!bfs()) {
				break;
			}
		}
		System.out.println(time);
	}

	private static boolean bfs() {
		int r = baby.r;
		int c = baby.c;
		int cnt = 0;
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c, cnt});
		visited[r][c] = true;
		
		PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {

			@Override
			public int compare(Fish o1, Fish o2) {
				if(o1.cnt == o2.cnt) {
					if (o1.r == o2.r) {
						return o1.c - o2.c;
					}else {
						return o1.r - o2.r;
					}
				}
				return o1.cnt - o2.cnt;
			}
		});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			r = cur[0];
			c = cur[1];
			cnt = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nr = (r + dr[i]);
				int nc = (c + dc[i]);
				
				if (!check(nr, nc)) continue;
				q.offer(new int[] {nr, nc, cnt+1});
				visited[nr][nc] = true;
				
				if (map[nr][nc] > 0) {
					if(baby.size <= map[nr][nc]) continue; // 먹기 가능 체크 
					
					//먹을 수 있으면 먹을 수 있는 리스트에 넣기
					pq.add(new Fish(nr, nc, map[nr][nc], cnt+1));
				}
			}
		}
		
		if (!pq.isEmpty()) {
			eat(pq);
			
			if (fishCnt == 0) {
				return false;
			}
			return true;
		}
		
		return false;
	}

	private static void eat(PriorityQueue<Fish> pq) {
		
		Fish fish = pq.poll();
		map[fish.r][fish.c] = 0;
		fishCnt--; // 잡아 먹음
		baby.eatCnt++;
		
		time += fish.cnt;
		
		baby.r = fish.r;
		baby.c = fish.c;
		
		// 앙 먹고 크기 증가 하는지 확인!
		if (baby.eatCnt == baby.size) {
			baby.size ++;
			baby.eatCnt = 0;
		}
	}

	private static boolean check(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N || visited[r][c] 
				|| map[r][c] > baby.size) return false;
		
		return true;
	}

}

























