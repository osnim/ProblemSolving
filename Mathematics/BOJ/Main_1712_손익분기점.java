package BOJ;

import java.util.Scanner;

public class Main_1712_손익분기점 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if (B>=C) {
			System.out.println(-1);
			return;
		}
		System.out.println(A/(C-B)+1);
	}

}
