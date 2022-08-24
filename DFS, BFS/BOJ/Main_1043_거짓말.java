import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1043_거짓말 {
	
	static int [] p;
	static int [] r;
	static int N,M,T;
	static List<List<Integer>> people;
    static List<Integer> truth;        //진실을 아는 사람들
    static int result;

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		p=new int[N+1]; // 1 2 3 4로 표현하기 위해 
		r=new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		truth = new ArrayList<Integer>();
		T = Integer.parseInt(st.nextToken());
		if(T!=0) {
			for (int i = 0; i < T; i++) {
				truth.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		people = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			List<Integer> pe = new ArrayList<Integer>();
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				pe.add(Integer.parseInt(st.nextToken()));
			}
			people.add(pe);
		}//읽기
		
		
		//로직
		
		makeSet();  // 1~N까지 초기화
					// 진실을 알고 있는 사람 미리 연결하기 
					//Tip : 0번은 비어있는데 진실을 알고 있지 않을 경우도 있으므로 0번을 최종 보스로
		
		ready(); // 진실과 파티 연결
		
		go(); // 파티 계산
		
		result=0;
		
		calc(); // Tip2) 연결했으므로 people에 있는 첫사람만 체크를 하면된다.
		
		System.out.println(result);

	}
	
	private static void calc() {
		for (List<Integer> pe : people) {
			if(p[pe.get(0)] != 0) result++;
		}
		
	}

	private static void go() {
		for (int i = 0, size = people.size(); i < size; i++) {
			for (int j = 1, size2 = people.get(i).size(); j < size2; j++) {
				union(people.get(i).get(0), people.get(i).get(j));
			}
		}
		for (int i = 1; i <= N; i++) {
			p[i] = find(p[i]);
		}
	}

	private static void ready() {
		for (int i = 0; i < truth.size(); i++) {
			union(0, p[truth.get(i)]);
		}
	}

	private static void makeSet() {
		p = new int[N+1];
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
		r = new int[N+1];
		for (int i = 0; i <= N; i++) {
			r[i] = 1;
		}
	}
	
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return false; // 싸이클이 있다
		/*if (r[x] < r[y]) {
			r[y] += r[x];
			p[x] = y;
		}
		else {
			r[x] += r[y];
			p[y] = x;
		}*/
		if (p[y] == 0) {
			p[x] = y;
		}
		else {
			p[y] = x;
		}
		
		return true;
	}

	private static int find(int x) {
		if(x == p[x]) return p[x];
		else return p[x] = find(p[x]); //부모의 부모를 찾음 > 최종 보스 찾음
	}

}
