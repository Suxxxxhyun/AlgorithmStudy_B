package baekjun.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/***************************** 스택 사용 ************************************************/
public class Main140602 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		String str = br.readLine();
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<str.length(); i++) {
			stack1.push(str.charAt(i));
		}
		
		for(int i=0; i<M; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
				case "L" : 
					if(!stack1.isEmpty()) {
						stack2.push(stack1.pop());
					}
					break;
				case "D" :
					if(!stack2.isEmpty()) {
						stack1.push(stack2.pop());
					}
					break;
				case "B" :
					if(!stack1.isEmpty()) {
						stack1.pop();
					}
					break;	
				case "P" :
					stack1.push(st.nextToken().charAt(0));
					break;
				default :
					break;
			}
		}
		
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}
		
		System.out.println(sb);
		
	}

}
