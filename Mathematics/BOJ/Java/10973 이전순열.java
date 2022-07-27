import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{

static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		StringTokenizer stz = new StringTokenizer(sc.nextLine());
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(stz.nextToken());
		}
		if(pp(n-1)) {
			for (int i = 0; i < n; i++) {
				System.out.print(p[i]+" ");
			}
		}else {
			System.out.println(-1);
		}
	}
	private static boolean pp(int size) {
		// 맨 오른쪽 이동 골짜기 찾기
		int i = size; 
		while(i>0 && p[i-1] < p[i]) i--;
		if(i == 0) return false; //이미정렬
		
		// 골짜기 왼쪽보다 작은 수를 첫 오른쪽부터 찾아서 스왑 
		int j = size;
		while(p[i-1] < p[j]) j--;
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		//무조건 스왑
		int k= size;
		while(i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			i++;
			k--;
		}
		return true;
	}
}
