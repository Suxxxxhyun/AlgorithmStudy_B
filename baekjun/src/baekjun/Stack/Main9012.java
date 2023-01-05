package baekjun.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			
			sb.append(solve(br.readLine()));
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static String solve(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			
			char c = s.charAt(i);
			
			if(c == '(') {
				stack.push(c);
			} else {
				if(stack.empty()) {
					return "NO";
				} else {
					stack.pop();
				}
			}
		}
		
		if(stack.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}
	}

}
