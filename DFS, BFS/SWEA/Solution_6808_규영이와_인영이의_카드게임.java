package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_6808_규영이와_인영이의_카드게임 {

	static LinkedList<Integer> gyu;
	static LinkedList<Integer> in;
	static int gyuWin;
	static int inWin;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int[] cards = new int[18];
			gyu = new LinkedList<>();
			in = new LinkedList<>();
			gyuWin = 0;
			inWin = 0;
			visited = new boolean[9];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				cards[Integer.parseInt(st.nextToken())-1] = 1; //규영 카드 1 마킹 
			} 
			for (int i = 0; i < 18; i++) {
				if(cards[i] == 1) gyu.add(i+1);
				else in.add(i+1);
			}// 입력 끝
			npn(0, 0, 0);
			sb.append("#"+t+ " " + gyuWin +" "+ inWin + "\n");
		}
		System.out.println(sb);
	}

	private static void npn(int cnt, int gyuPoint, int inPoint) {
		if (cnt == 9) {
			if(gyuPoint > inPoint) gyuWin++;
			else if(gyuPoint < inPoint) inWin++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(visited[i] == true) continue;  
			visited[i] = true;
			int tg= gyu.get(cnt); 
			int ti = in.get(i);
			if(tg > ti) npn(cnt+1, gyuPoint+tg+ti, inPoint);
			else if(tg < ti) npn(cnt+1, gyuPoint, inPoint+ti+tg);
			visited[i] = false;
		}
	}

}
