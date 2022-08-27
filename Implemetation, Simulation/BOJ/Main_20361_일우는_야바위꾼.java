package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20361_일우는_야바위꾼 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력을 공백 기준으로 자르기 위해
		
		int N = Integer.parseInt(st.nextToken()); //N
		int X = Integer.parseInt(st.nextToken())-1; //X
		int K = Integer.parseInt(st.nextToken()); //K
		
		int[] arr = new int[N];// 종이컵들의 위치를 저장한 배열
		arr[X] = 1; // 간식이 들어있는 종이컵 표시
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine()); // 입력 
			int A = Integer.parseInt(st.nextToken())-1; // 컵 A의 위치
			int B = Integer.parseInt(st.nextToken())-1; // 컵 B의 위치
			
			int temp = arr[A]; // 교환
			arr[A] = arr[B];	// 교환
			arr[B] = temp;	// 교환
		}
		
		for (int i = 0; i < N; i++) { //간식 찾기
			if (arr[i] == 1) { // 간식이 있다면
				System.out.println(i+1);
			}
		}
	}

}
