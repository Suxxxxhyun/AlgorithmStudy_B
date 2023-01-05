package baekjun.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10773 {
	
	public static int[] stack;
	public static int size = 0;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		stack = new int[N];
		
		while(N-- > 0) {
			
			int val = Integer.parseInt(br.readLine());
			
			if(val == 0) {
				pop();
			} else {
				push(val);
			}
		}
		
		int sum =0;
		for(int i=0; i<stack.length; i++) {
			sum += stack[i];
		}
		System.out.println(sum);
		

	}
	
	public static void push(int data) {
		stack[size++] = data;
	}
	
	public static void pop() {
		stack[size - 1] = 0;
		size--;
		
	}

}
