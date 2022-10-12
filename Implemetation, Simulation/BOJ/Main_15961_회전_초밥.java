import java.util.*;
import java.io.*;

public class Main_15961_회전_초밥 {
	
	static int N; //접시 수
	static int d;  //초밥의 가짓수
	static int k;  //연속해서 먹는 접시의 수
	static int c;  //쿠폰 번호
	static int[] arr; //접시의 수
	static int[] nums; // 초밥의 종류
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //접시 수
		d = sc.nextInt(); //초밥의 가짓수
		k = sc.nextInt(); //연속해서 먹는 접시의 수
		c = sc.nextInt(); //쿠폰 번호
	
		arr = new int[N+k-1];
		nums = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int idx = 0; //맨 앞 k개 만큼 배열 뒤에 추가 
		for (int i = N; i < N+k-1; i++) {
			arr[i] = arr[idx];
			idx++;
		}
		//시작부터 연속으로 k게 먹음
		for (int i = 0; i < k; i++) {
			nums[arr[i]]++;
		}
		
		int cnt = 0;//현재 먹은 초밥의 가짓수
		nums[c]++; //4개 연속으로 먹어서 쿠폰도 포함
		
		for (int i = 0; i < d+1; i++) {
			if (nums[i] > 0) {
				cnt++; 
			}
		}
		int ans = cnt;
		
		int right = k;
		int left = 0;
		while(right < N+k-1) {
			int lNum = arr[left];// 맨 왼쪽 초밥의 종류
			nums[lNum]--; // 초밥 한 개  빼기
			if (nums[lNum] == 0) 
				cnt--;
			
			int rNum = arr[right];
			if (nums[rNum] == 0)
				cnt++;
			
			nums[rNum]++; //초밥 한 개 증가
			right++;
			left++;
			ans = Math.max(cnt, ans);
		}
		
		System.out.println(ans);
	}
}
