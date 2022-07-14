import java.util.Scanner;

public class Main_2443_별찍기6 {
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i ; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 2*N-2*i-1; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}