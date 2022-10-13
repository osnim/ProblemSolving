import java.util.*;
import java.io.*;

public class Main_16637_괄호_추가하기 {
	
	static int N;
	static char[] arr;
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N];
		arr = sc.next().toCharArray();
		
		dfs(2, arr[0]-'0');
		System.out.println(ans);
	}

	private static void dfs(int endIdx, int sum) {
		if (endIdx >= N) {
			ans = Math.max(ans, sum);
			return;
		}
		// 괄호 없는 경우 
		dfs(endIdx + 2, calc(sum, arr[endIdx-1], arr[endIdx]-'0'));
		
		if (endIdx+2 < N) {
			//괄호 있는 경우 
			int temp = calc(arr[endIdx]-'0', arr[endIdx+1], arr[endIdx+2]-'0'); //먼저 계산해야함
			dfs(endIdx + 4, calc(sum, arr[endIdx-1], temp));
		}
		
	}

	private static int calc(int a, char op, int b) {
		/*System.out.println("????");
		System.out.println(a + " " + op + " " + b); 
		*/
		if (op == '+') return a + b;
		else if (op == '-') return a - b ;
		else if (op == '*') return a * b ;
		else return a / b;
	}

}
