package baekjun.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//직접 구현 방식 -> 배열을 이용해서, 삭제할때 앞으로 땡기지않도록, 배열을 원인것처럼 접근해서 풀어볼거임.

public class Main1825802 {
	
	public static int [] que;
	public static int rear = 0;
	public static int front = 0;
	public static int num = 0;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		que = new int[N];
		
		for(int i=0; i<N; i++) {
			
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
	
	public static void push(int x) {
		que[rear++] = x;
		num++;
	}
	
	public static int pop() {
		if(num == 0) {
			return -1;
		} else {
			int res = que[front++];
			//que[front] = 0; //얘 한번 지우고도 시도해볼것.
			num--;
			return res;
		}
	}
	
	public static int size() {
		return num;
	}
	
	public static int empty() {
		if(num == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int front() {
		if(num == 0) {
			return -1;
		} else {
			return que[front];
		}
	}
	
	public static int back() {
		if(num == 0) {
			return -1;
		} else {
			return que[rear-1];
		}
	}

}
