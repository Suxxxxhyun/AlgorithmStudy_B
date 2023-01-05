package baekjun.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
//https://codingtalk.tistory.com/227 블로그 참조
public class Main2346 {

	public static void main(String[] args) throws IOException{
		
		//point 제네릭 -> 1번의 3값 이런식으로 표현해주려고 point클래스를 만듬.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Deque<point> deque = new LinkedList<>();
		Deque<point> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<=N; i++) {
			int val = Integer.parseInt(st.nextToken());
			deque.offer(new point(i, val));
		}
		
		while(!deque.isEmpty()) {
			
			sb.append(deque.peek().idx);
			sb.append(" ");
			int val = deque.poll().val;
			if(deque.isEmpty()) {
				break;
			}
			
			if(val > 0){
				val--;
				for(int j=0; j<val; j++) {
					deque.offerLast(deque.poll());
				}
			} else {
				for(int j=0; j<Math.abs(val); j++) {
					deque.offerFirst(deque.pollLast());
				}
			}

		}
		System.out.println(sb);
	}
	
	static class point{
		int idx;
		int val;
		public point(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

}
