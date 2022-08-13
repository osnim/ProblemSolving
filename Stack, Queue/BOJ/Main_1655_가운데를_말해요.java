import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1655_가운데를_말해요 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 짝수
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> (o2-o1)); // 홀수
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(br.readLine());			
			if (i%2 == 1) {
				maxHeap.offer(num);
			}else {
				minHeap.offer(num);
			}
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(minHeap.peek() < maxHeap.peek()) {
					int t1 = minHeap.poll();
					int t2 = maxHeap.poll();
					minHeap.offer(t2);
					maxHeap.offer(t1);
				}
			}
			sb.append(maxHeap.peek()+"\n");
		} 
		System.out.println(sb);
	}

}
