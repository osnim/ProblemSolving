package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_연습문제_헌터 {

	static class Hunter{
		int r;
		int c;
		
		public Hunter(int r, int c) {	
			this.r = r;
			this.c = c;
		}		
	}
	
	static class Monster{
		int r;
		int c;
		int no;

		public Monster(int r, int c, int no) {
			this.r = r;
			this.c = c;
			this.no = no;
		}
	}
	
	static class Customer{
		int r;
		int c;
		int no;
		
		public Customer(int r, int c, int no) {
			this.r = r;
			this.c = c;
			this.no = no;
		}
	}
	static int N;
	static int[][] map;
	static List<Monster> monList;
	static List<Customer> cusList; 
	static Hunter hunter = new Hunter(0, 0);
	static int monSize, cusSize;
	static ArrayList<Integer> p;
	static int totalSize; 
	static boolean[] visited;
	static int[] killList;
	static int ans;
	static int killCnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cusList = new ArrayList<>();			
			monList = new ArrayList<>();
			map = new int[N][N];
			ans = Integer.MAX_VALUE;
			p = new ArrayList<>();
	
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					if (temp > 0) { // 몬스터
						monList.add(new Monster(i, j, temp));
						p.add(temp);
					}
					else if(temp < 0) { // 고객
						cusList.add(new Customer(i, j, temp));
						p.add(temp);
					}
				}
			}// 입력 끝
			
			monList.sort(new Comparator<Monster>() {
				@Override
				public int compare(Monster o1, Monster o2) {
					return o1.no - o2.no;
				}
			});
			
			cusList.sort(new Comparator<Customer>() {
				@Override
				public int compare(Customer o1, Customer o2) {
					return o2.no - o1.no; // 음수라서 내림차순
				}
			});
			
			monSize = monList.size();
			cusSize = cusList.size();
			totalSize = monSize + cusSize;
			visited = new boolean[totalSize];
			killList = new int[monSize];
			npr(0, 0);
			sb.append("#" + t + " " + ans+ "\n");
		}
		System.out.println(sb);
	}

	private static void npr(int cnt, int sumDis) {
		if (cnt == totalSize) {
			ans = Math.min(sumDis, ans);
			return;
		}
		
		for (int i = 0; i < totalSize; i++) {
			if (visited[i]) continue;
			int hr = hunter.r;
			int hc = hunter.c;
			
			if(p.get(i) > 0) { // 몬스터
				int monNo = p.get(i);
				visited[i] = true;
				Monster mon = monList.get(monNo-1);
				int dis = findDis(hunter.r, hunter.c , mon.r, mon.c);
				hunter.r = mon.r;
				hunter.c = mon.c;
				killList[killCnt++] = monNo;
				npr(cnt+1, dis+sumDis);
				killList[--killCnt] = 0;
			}
			else {
				int cusNo = p.get(i);
				if (!check(cusNo)) continue; // 현재가 고객이지만 이 고객의 번호와 일치하는 몬스터가 없는 경우
				visited[i] = true;
				Customer cus = cusList.get((cusNo*-1)-1);
				int dis = findDis(hunter.r, hunter.c, cus.r, cus.c);
				hunter.r = cus.r;
				hunter.c = cus.c;
				npr(cnt+1, dis+sumDis);	
			}
			visited[i] = false;
			hunter.r = hr; //백트래킹
			hunter.c = hc;
		}
	}

	private static int findDis(int r, int c, int r2, int c2) {
		return Math.abs(r-r2)+Math.abs(c-c2);
	}

	private static boolean check(int cusNo) {
		for (int j = 0; j < killCnt; j++) {
			if (killList[j] == -cusNo) {
				return true;
			}
		}
		return false;
	}
}
