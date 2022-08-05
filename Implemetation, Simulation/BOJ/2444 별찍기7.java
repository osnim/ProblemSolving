
import java.util.Scanner;
public class Main_2444_별찍기7 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = N-i-1; j > 0; j--) {
				System.out.print(" ");
			}
			for (int k = 0; k < i+1; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
