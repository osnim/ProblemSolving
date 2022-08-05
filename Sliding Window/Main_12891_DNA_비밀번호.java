package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_12891_DNA_비밀번호 {

	static int S, P;
	static char[] dna_str;
	static int[] rule = new int[4]; //A, C, G, T
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Character, Integer> hm = new HashMap<>();
		int count = 0;
		hm.put('A', 0);
		hm.put('C', 1);
		hm.put('G', 2);
		hm.put('T', 3);
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		dna_str = br.readLine().toCharArray();
		int[] dna_cnt = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) 
			rule[i] = Integer.parseInt(st.nextToken());
		
		//윈도우 슬라이드
		int left = 0;
		int right = P - 1;
		for (int i = left; i <= right; i++) {
			int idx = hm.get(dna_str[i]);
			dna_cnt[idx]++;
		}
		
		while(right < S && left < S) {
			if(dna_cnt[0] >= rule[0] && dna_cnt[1] >= rule[1] && 
					dna_cnt[2] >= rule[2] && dna_cnt[3] >= rule[3]) count++;
			
			dna_cnt[hm.get(dna_str[left])]--;
			left ++;
			
			right ++;
			if (right == S) {
				break;
			}
			dna_cnt[hm.get(dna_str[right])]++;
		}
		System.out.println(count);
	}
}
