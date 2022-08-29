package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_연습문제_낚시터_자리잡기 {

	static int lines;
	static int[] gatePositions;
	static int[] WaitList;
	static int[] visitied;
	static int ans;
	
	static int[][] GateOrders = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			lines = Integer.parseInt(br.readLine()); //낚시터의 개수
			gatePositions = new int[3]; // 게이트의 위치와 그 위치에서 기다리는 낚시꾼 수
			WaitList = new int[3];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				gatePositions[i] = Integer.parseInt(st.nextToken())-1;
				WaitList[i] = Integer.parseInt(st.nextToken());
			}//입력 끝
			
			simulation();
			sb.append("#" + t + " " + ans + "\n");	
		}

		System.out.println(sb);
	}

	private static void simulation() {
		ans = Integer.MAX_VALUE;
		
		for (int[] orderIdx : GateOrders) {
			int sumDist1 = 0;
			visitied = new int[lines];
			int[] offset = new int[lines*2];// 게이트에서 낚시꾼들을 배치하기 위한 배열
			offsetMake(offset, lines*2, 1); //1. 오른쪽부터 채우고
			
			for (int i = 0; i < 3; i++) {
				int gateX = gatePositions[orderIdx[i]]; //게이트 위치
				int waitCnt = WaitList[orderIdx[i]]; // 그 게이트에 해당하는 낚시꾼 수
				sumDist1 += cacultaion(offset, gateX, waitCnt); //2. 거리 계산
				//System.out.println(Arrays.toString(visitied));
			}
			ans = Math.min(sumDist1, ans);
			//System.out.println();
			
			int sumDist2 = 0;
			visitied = new int[lines];
			offsetMake(offset, lines*2, -1); //1. 오른쪽부터 채우고
			
			for (int i = 0; i < 3; i++) { //2. 왼쪽부터 채우고
				int gateX = gatePositions[orderIdx[i]]; //게이트 위치
				int waitCnt = WaitList[orderIdx[i]]; // 그 게이트에 해당하는 낚시꾼 수
				sumDist2 += cacultaion(offset, gateX, waitCnt); //2. 거리 계산
				//System.out.println(Arrays.toString(visitied));
			}
			ans = Math.min(sumDist2, ans);
			//System.out.println("오른쪽: " + sumDist1 +"  왼쪽 : "+ sumDist2 );
		}
		
	}

	private static int cacultaion(int[] offset, int gateX, int waitCnt) {
		int sumDist = 0;
		int visitedCnt = 0;
		
		for (int j = 0; j < lines*2; j++) {
			int fisherX = gateX+offset[j];
			if (!check(fisherX)) continue; //범위 안나가는지, 	
			if (visitied[fisherX] > 0) continue;
			visitied[fisherX] = Math.abs(fisherX-gateX)+1;
			sumDist += visitied[fisherX]; // 이동 거리
			visitedCnt ++;
			if (visitedCnt == waitCnt) {
				break;
			}
		}
		return sumDist;
	}

	private static boolean check(int x) {
		if (x >= 0 && x < lines) return true;
		
		return false;
	}

	private static void offsetMake(int[] offset, int lines, int sign) {
		offset[0] = 0;
		int cnt2 = 0;
		int num = 1;
		for (int j = 1; j < lines; j++) {
			offset[j] = num*sign;
			cnt2++; // 0, 1 -1, .... 
			sign *= -1;
			if(cnt2 == 2) {
				cnt2 = 0;
				num++;
			}
		}
	}

}
