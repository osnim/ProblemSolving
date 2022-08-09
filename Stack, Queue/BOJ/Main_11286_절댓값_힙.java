package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11286_절댓값_힙 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1, o2);
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
		});
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(minHeap.isEmpty()) sb.append(0 + "\n");
				else {
					int num = minHeap.poll();
					sb.append(num + "\n");
				}
			}//빼는 것
			
			else minHeap.offer(x);//넣는 것 
		}
		System.out.println(sb);
	}
}
