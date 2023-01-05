package baekjun.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//stack패키지 이용한경우
import java.util.Stack;

public class Main1077302 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			
			int val = Integer.parseInt(br.readLine());
			
			if(val == 0) {
				stack.pop();
			} else {
				stack.push(val);
			}
		}
		
		int sum = 0;
		
		/*for(int i=0; i<stack.size(); i++) {
			sum += stack.pop();
		}
		
		for(int o : stack) {
			sum += stack.pop();
		} stack을 pop해서 더해버리면, stack의 size가 변화하게 되서 이렇게 쓰면안됨!*/
		
		/*for(int o : stack) {
			sum += o;
		} 방법 1*/
		
		//방법2
		while(stack.size() != 0) {
			sum+=stack.pop();
		}
		
		System.out.println(sum);
		
		
		

	}

}
