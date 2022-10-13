import java.util.*;

public class Solution_8458_원점으로_집합 {

	static int ans, N;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] arr; // N개의 x,y좌표 저장
	static int dir = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			ans = -1;
			N = sc.nextInt();
			arr = new int[N][2];
			int maxX = 0;
			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				maxX = Math.max(maxX, Math.abs(arr[i][0])+Math.abs(arr[i][1]));
				
			}// 입력 끝 
			if (maxX == 0) {
				sb.append("#" + t + " " + 0 + "\n"); // 0칸 움직인다.
				continue;
			}
			
			int first = (arr[0][0] + arr[0][1])%2; // 처음이 홀수인지 짝수인지 체크		
			if (first == 0) {
				if (isAllEven()) {
					int temp = val(maxX);
					for (int i = temp; i < 63248; i++) {
						long ss = nth(i);
						if (ss % 2 ==0) {
							ans = i;
							break;
						}
					}
				}	
					
			}else {
				if (isAllOdd()) {
					int temp = val(maxX);
					for (int i = temp; i < 63248; i++) {
						long ss = nth(i);
						if (ss % 2 ==1) {
							ans = i;
							break;
						}
					}
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	private static long nth(int n) {
		return 0L+n*(n+1L)/2L;
	}

	private static int val(int maxX) {
		double x = ((-1.0+Math.sqrt(1.0+8.0*maxX))/2.0);
		return (int)Math.ceil(x);
	}

	private static boolean isAllOdd() {
		for (int i = 0; i < N; i++) 
			if((Math.abs(arr[i][0] + arr[i][1]))%2 == 0 ) return false;
		return true;
	}

	private static boolean isAllEven() {
		for (int i = 0; i < N; i++) 
			if(Math.abs((arr[i][0] + arr[i][1]))%2 == 1 ) return false;
		return true;
	}

}
