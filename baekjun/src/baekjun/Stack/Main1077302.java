package baekjun.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//stack��Ű�� �̿��Ѱ��
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
		} stack�� pop�ؼ� ���ع�����, stack�� size�� ��ȭ�ϰ� �Ǽ� �̷��� ����ȵ�!*/
		
		/*for(int o : stack) {
			sum += o;
		} ��� 1*/
		
		//���2
		while(stack.size() != 0) {
			sum+=stack.pop();
		}
		
		System.out.println(sum);
		
		
		

	}

}
