import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가_만든_맛있는_음식 {

	static int[][] p;
	static int N;
	static int count;
	static long min = Long.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		p = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
		}
		
		subset(0, 1L, 0L);
		System.out.println(min);

	}
	
	private static void subset(int cnt, Long s, Long b) {
		if(cnt == N) {
			if(b > 0) {
				min = Math.min(min, Math.abs(s-b));
			}
			return;
		}
		
		subset(cnt+1, s*p[cnt][0], b+p[cnt][1]);
		subset(cnt+1, s, b);
	}

}
