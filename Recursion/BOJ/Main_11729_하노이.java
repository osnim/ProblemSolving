import java.util.Scanner;

public class Main_11729_하노이 {

	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	static void Hanoi(int N, int a, int b, int c) {
		cnt++;
		if(N == 1) {
			sb.append(a+" "+b+"\n");
			return; //BC
		}
		Hanoi(N-1, a, c, b);
		sb.append(a+" "+b+"\n");
		Hanoi(N-1, c, b, a);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Hanoi(n, 1, 3, 2);
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}
