import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10971_외판원_순회_2_NP {

	static int N;
	static int[][] map;
	static int min;
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		p = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		
		do {
			int sum = 0;
			boolean flag = true;
			for (int i = 0; i < N-1; i++) {
				if (map[p[i]][p[i+1]] == 0) {
					flag = false;
					break;
				}
				sum += map[p[i]][p[i+1]];
			}
			if (map[p[N-1]][p[0]] == 0 || !flag) {
				continue;
			}
			sum += map[p[N-1]][p[0]];
			min = Math.min(sum, min);
			
		} while (np(N-1));
		System.out.println(min);
	}

	private static boolean np(int size) {
		int i = size;
		while(i > 0 && p[i-1] > p[i])i--;
		if (i == 0) return false;
		
		int j = size;
		while(p[i-1] > p[j]) j--;
		swap(i-1, j);
		
		int k = size;
		while(i < k)swap(i++, k--);
		
		return true; // false -> true로 바꿈[원경]
	}

	private static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
