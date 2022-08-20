package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스_2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		ArrayList<Integer>[] lists = new ArrayList[N];
		boolean[] visited = new boolean[N]; 
		
		for (int i = 0; i < N; i++) {
			lists[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			lists[start].add(end);
			lists[end].add(start);
		}
		
		Queue<Integer> q= new LinkedList<>();
		q.add(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			for (int des : lists[node]) {
				if (!visited[des]) {
					q.offer(des);
					visited[des] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
