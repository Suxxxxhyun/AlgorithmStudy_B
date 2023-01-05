package baekjun.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1991 {
	
	static Map<String, List<String>> map = new HashMap<>();
	
	//전위 순회 메서드
	private static void preorder(String v) {
		if(v.equals(".")) 
			return;
		
		System.out.print(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
	}
	
	private static void inorder(String v) {
		if(v.equals(".")) return;

		inorder(map.get(v).get(0));
		System.out.print(v);
		inorder(map.get(v).get(1));
	}
	
	private static void postorder(String v) {
		if(v.equals(".")) return;

		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		System.out.print(v);
	}
	

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			//파라미터로 공백을 의미하는 정규식 "\s"
			String[] tmp = br.readLine().split("\\s");
			List<String> list = new ArrayList<>();
			
			//자식노드 추가
			list.add(tmp[1]);
			list.add(tmp[2]);
			
			//부모노드가 키값이 되고있고 value값이 자식노드가 전체가 들어가고 있는 상황.
			map.put(tmp[0], list);
			
		}
		
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		postorder("A");
		
		
	}

}
