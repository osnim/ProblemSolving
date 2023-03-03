import java.io.*;
import java.util.*;

public class Solution_1248_공통조상 {

	static class Node{
		int num, parents;
		List<Integer> children;
		
		public Node(int num, int parents, List<Integer> children) {
			super();
			this.num = num;
			this.parents = parents;
			this.children = children;
		}
	}
	
	static int V, E, c1, c2;
	static Node[] nodes;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			
			nodes = new Node[V+1]; // 노드 번호를 인덱스로 사용하기 위해
			
			for (int i = 1; i <= V; i++) {
				nodes[i] = new Node(i, 0, new ArrayList<Integer>());
			}
			
			st = new StringTokenizer(br.readLine(), " "); // 한 줄로 된 간선의 정보 다 받음
			
			for (int i = 0; i < E; i++) {
				int parentNum = Integer.parseInt(st.nextToken());
				int childNum = Integer.parseInt(st.nextToken());
				nodes[parentNum].children.add(childNum);
				nodes[childNum].parents = parentNum;
			}
			
			Node CommonParents = findCommonParents(nodes[c1], nodes[c2]);
			
			sb.append("#" + t + " " + CommonParents.num + " " + countSubTree(CommonParents) + "\n");
		}
		System.out.println(sb);
	}

	private static int countSubTree(Node node) {
		int cnt = 1;
		for (Integer child : node.children) {
			cnt += countSubTree(nodes[child]);
		}
		return cnt;
	}

	private static Node findCommonParents(Node c1, Node c2) {
		Stack<Integer> path1 = getPath(c1);
		Stack<Integer> path2 = getPath(c2);
		
		Node CommonParents = nodes[1]; //일단 루트로
		
		while(!path1.isEmpty() && !path2.isEmpty()  ) {
			int p1 = path1.pop();
			int p2 = path2.pop();
			if (p1 == p2) {
				CommonParents = nodes[p1];
			}else {
				break;
			}
		}
		return CommonParents;
	}

	private static Stack<Integer> getPath(Node c) {
		Stack<Integer> path = new Stack();
		Node cur = c;
		while(cur.parents != 0) {
			path.push(cur.parents);
			cur = nodes[cur.parents];
		}
		return path;
	}
}