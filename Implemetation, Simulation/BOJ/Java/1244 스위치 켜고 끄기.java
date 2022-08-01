import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1244_스위치_켜고_끄기 {

	static int[] swiches;
	static int[][] students;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		swiches = new int [N];
		
		for (int i = 0; i < N; i++) {
			swiches[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = Integer.parseInt(br.readLine());
		students = new int[s][2];
		
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			students[i][0] = Integer.parseInt(st.nextToken());
			students[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < s; i++) {
			if(students[i][0] == 1) { // 남자
				int num = students[i][1]-1;
				for (int j = num; j < N; j+=students[i][1]) {
					swiches[j] = (swiches[j]+1)%2;
				}
				
			}
			else { //여자
				int idx = students[i][1]-1;
				int l = idx;
				int r = idx;
				while((l-1 >= 0 && r+1 < N) && (swiches[l-1] == swiches[r+1])) {
					l--;
					r++;
				}
				for (int j = l; j <= r; j++) {
					swiches[j] = (swiches[j]+1)%2;
				}
			}
		}
		int i = 0;
		while(i < N) {
			System.out.print(swiches[i]+" ");
			if((i+1) % 20 == 0) {
				System.out.println();
			}
			i++;
		}
	}

}
