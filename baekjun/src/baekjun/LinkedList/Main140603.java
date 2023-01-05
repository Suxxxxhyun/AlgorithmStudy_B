package baekjun.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/***************************** Iterator 사용 ************************************************/

public class Main140603 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int M = Integer.parseInt(br.readLine());
		
		LinkedList<Character> list = new LinkedList<>();
		
		for(int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		//반복자인 iterator, listiterator --> 커서의 기능을 갖고있다. 
		//배열이 3개라면, 데이터 자체의 인덱스는 0,1,2 --> 커서는 0,1,2,3까지 가능
		//즉 n개의 배열에서 커서는 0부터 n까지 가능
		ListIterator<Character> iter = list.listIterator();
		
		//hasNext메서드는, 리스트 반복자가 해당 리스트를 순방향으로 순회할때 다음요소가 있으면 true
		while(iter.hasNext()) {
			iter.next();
		}
		//next()메소드는, 다음 요소(데이터)를 반환하고, 커서를 순방향으로 위치시킴.
		//그러므로, 위 while문에서 abcd를 입력했다면, 커서는 d뒤에 위치하게됨.
		
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
				case "L" : 
					if(iter.hasPrevious()) {
						iter.previous();
					}
					//hasPrevious : 리스트를 역방향으로 순회할때 이전요소가 있으면 true, 즉 커서가 문장맨앞에 위치하게 된다면, 이전요소가 없으니 실행 안됨.
				break;
				case "D" :
					if(iter.hasNext()) {
						iter.next();
					}
				break;
				case "B" :
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				break;
				case "P" :
					iter.add(st.nextToken().charAt(0));
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();

		
		for(char c : list) {
			sb.append(c);
		}
		
		System.out.println(sb);
	}

}
