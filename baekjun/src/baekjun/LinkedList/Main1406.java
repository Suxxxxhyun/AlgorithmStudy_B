package baekjun.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
/***************************** LinkedList 이용시 시간초과 -> 매번 커서의 위치를 처음부터 탐색해야하므로 비효율 ************************************************/

public class Main1406 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Character> linkedlist = new LinkedList<Character>();
		
		//charAt : 문자열중 한글자만 선택해서 char타입으로 반환해줌.
		for(int i=0; i<str.length(); i++) {
			linkedlist.add(str.charAt(i));
		}
		
		linkedlist.add('*');
		int bul = linkedlist.indexOf('*');
		
		for(int i=0; i<N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
				case "L" :	
					int changebul = linkedlist.indexOf('*');
					if(changebul == 0) {
						break;
					}
					linkedlist.remove(changebul);
					linkedlist.add(changebul - 1,'*');
					break;
				case "D" :
					int changebul2 = linkedlist.indexOf('*');
					if(changebul2 == linkedlist.size() - 1) {
						break;
					}
					linkedlist.remove(changebul2);
					linkedlist.add(changebul2 + 1,'*');
					
					break;
				case "B" :
					if(bul == 0) {
						break;
					}
					linkedlist.remove(bul-1);
					break;
				case "P" :
					linkedlist.add(bul, st.nextToken().charAt(0));
					break;
			
			}
		}
		
		linkedlist.remove(new Character('*'));
		for(int i=0; i < linkedlist.size(); i++) {
			sb.append(linkedlist.get(i));
		}
		
		System.out.println(sb);
	}

}
