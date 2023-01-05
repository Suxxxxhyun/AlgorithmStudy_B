package baekjun.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//ArrayList(저장공간)이용. --> 시간초과남 --> 이유 왠지 생각해보면, 삭제할때, 원소 삭제하고 뒤에있는 원소들을 앞으로 땡겨올때 시간복잡도 올라가서 그런듯

public class Main18258<T> {
	
	static ArrayList<Integer> queue = new ArrayList<>();
	
	public static void push(int data) {
		queue.add(data);
	}
	
	public static Integer pop() {
		if(queue.isEmpty()) {
			return -1;
		} else {
			return queue.remove(0);
		}
	}
	
	public static Integer size() {
		return queue.size();
	}
	
	public static Integer empty() {
		if(queue.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static Integer front() {
		if(queue.isEmpty()) {
			return -1; 
		} else {
			return queue.get(0);
		}
	}
	
	public static Integer back() {
		if(queue.isEmpty()) {
			return -1; 
		} else {
			return queue.get(queue.size()-1);
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
				case "push" :
					push(Integer.parseInt(st.nextToken()));
				break;
				case "pop" :
					sb.append(pop());
					sb.append('\n');
				break;
				case "size" :
					sb.append(size());
					sb.append('\n');
				break;
				case "empty" :
					sb.append(empty());
					sb.append('\n');
				break;
				case "front" :
					sb.append(front());
					sb.append('\n');
				break;
				case "back" :
					sb.append(back());
					sb.append('\n');
				break;
			}
		}
		
		System.out.println(sb);
	}
	
	

}
