package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2954_창영이의_일기장 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기
		StringBuilder sb = new StringBuilder(); //출력을 위한 스트링 빌더 객체 생성
		
		char[] input = br.readLine().toCharArray(); // 입력
		for (int i = 0, size = input.length; i < size; i++) { // 입력만큼 한 글자씩 읽기
			if (input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') { //모음을 만나면
				sb.append(input[i]); 	// 모음 저장
				i+=2; 					// 2칸 뒤로 이동
				continue; 				// 반복 계속 
			}
			sb.append(input[i]); 		// 모음 아닌 글자 저장
		}
		System.out.println(sb);			// 출력
	}

}
