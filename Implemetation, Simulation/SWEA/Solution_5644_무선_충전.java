package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_5644_무선_충전 {

	static class User{
		int r;
		int c;
		
		public User(int r, int c) {
			this.r = r;
			this.c = c;
		}		
	}
	
	static class BC{
		int r;
		int c;
		int coverage;
		int p;
		
		public BC(int r, int c, int coverage, int p) {
			this.r = r;
			this.c = c;
			this.coverage = coverage;
			this.p = p;
		}
	}
	
	static int[][] map;
	static int M, A; // 이동거리, BC 개수
	static int[] dr = {0, -1, 0, 1, 0}; //정지 상 우 하 좌
	static int[] dc = {0, 0, 1, 0, -1}; //정지 상 우 하 좌
	static User userA;
	static User userB;
	static int[] moveA; 
	static int[] moveB; 
	static List<BC> bcList;
	static int totalCharging;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			moveA = new int[M+1]; 
			moveB = new int[M+1];
			bcList = new ArrayList<>();

			moveA[0] = 0; //시작부터 무선충전 범위 안에 있는지 체크
			moveB[0] = 0; //시작부터 무선충전 범위 안에 있는지 체크
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 1; m < M+1; m++)  //유저 A 이동 경로
				moveA[m] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 1; m < M+1; m++)  //유저 B 이동 경로 
				moveB[m] = Integer.parseInt(st.nextToken());
			
			for (int a = 0; a < A; a++) {
				st = new StringTokenizer(br.readLine(), " "); //거꾸로다
				int c = Integer.parseInt(st.nextToken())-1; 	// c
				int r = Integer.parseInt(st.nextToken())-1; 	// r
				int cov = Integer.parseInt(st.nextToken());   	//범위
				int p = Integer.parseInt(st.nextToken());	//파워
				bcList.add(new BC(r, c, cov, p));
			}//입력 끝
			
			totalCharging = 0;
			simulation();
			sb.append("#"+t+" "+ totalCharging + "\n");
		}
		System.out.println(sb);

	}

	private static void simulation() {
		
		userA = new User(0, 0);
		userB = new User(9, 9);
		for (int m = 0; m < M+1; m++) {
			int d = moveA[m];
			userA.r = userA.r + dr[d];
			userA.c = userA.c + dc[d];
			
			d = moveB[m];
			userB.r = userB.r + dr[d];
			userB.c = userB.c + dc[d];
			
			List<BC> listA = new ArrayList<>(); // A가 사용 가능한 BC 리스트
			List<BC> listB = new ArrayList<>(); // B가 사용 가능한 BC 리스트
			for (int i = 0; i < A; i++) {
				BC tempBC = bcList.get(i);
				if(check(userA, tempBC)) listA.add(tempBC);
				if(check(userB, tempBC)) listB.add(tempBC);
			}
			
			//충전량 계산
			
			int amount = calculate(listA, listB);
			totalCharging += amount;
		}
	}

	private static int calculate(List<BC> listA, List<BC> listB) {
		int temp1 = 0;
		for (BC a : listA) {
			temp1 = Math.max(temp1, a.p);
			for (BC b : listB) {
				if (a != b) {
					temp1 = Math.max(temp1, a.p + b.p);
				}
			}
		}
		
		int temp2 = 0;
		for (BC b : listB) {
			temp2 = Math.max(temp2, b.p);
			for (BC a : listA) {
				if (b != a) {
					temp2 = Math.max(temp2, a.p + b.p);
				}
			}
		}
		
		return Math.max(temp1, temp2);
	}

	private static boolean check(User user, BC bc) {
		if((Math.abs(user.r - bc.r) + Math.abs(user.c - bc.c)) <= bc.coverage) return true;
		return false;
	}

}
