import java.io.*;
import java.util.*;

public class Solution_1231_중위순회 {

	static class Node{
		
		Node left, right;
		char ch;
		
		public Node(Node left, Node right, char ch) {
			super();
			this.left = left;
			this.right = right;
			this.ch = ch;
		}
	}
	
	static int N;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			Node[] nodes = new Node[N+1]; // 노드 번호를 인덱스로 사용하기 위해
			
			//노드 초기화
			for (int i = 1; i <= N; i++) {
				nodes[i] = new Node(null, null, ' ');
			}
			
			// 노드에 값 할당
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int num = Integer.parseInt(st.nextToken());
				nodes[num].ch = st.nextToken().charAt(0);
                
				if (st.hasMoreTokens()) {
                    int leftChild = Integer.parseInt(st.nextToken());
                    nodes[num].left = nodes[leftChild];
                }

                if (st.hasMoreTokens()) {
                    int rightChild = Integer.parseInt(st.nextToken());
                    nodes[num].right = nodes[rightChild];
                }			
			}
			sb.append("#" + t + " " + inOrder(nodes[1]) + "\n");
		}
		System.out.println(sb);
	}
	
	// 중위 순회 
    static String inOrder(Node node) {
        if (node == null) return "";
        return inOrder(node.left) + node.ch + inOrder(node.right);
    }

}
