package baekjun.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//���� ���� ��� -> �迭�� �̿��ؼ�, �����Ҷ� ������ �������ʵ���, �迭�� ���ΰ�ó�� �����ؼ� Ǯ�����.

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
			//que[front] = 0; //�� �ѹ� ����� �õ��غ���.
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
