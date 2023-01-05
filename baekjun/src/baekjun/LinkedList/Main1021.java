package baekjun.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1021 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> deque = new LinkedList<Integer>(); //덱이라면서 왜 링크드리스트로 구현하였는가?
		
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			deque.offer(i);
		}
		
		int[] seq = new int[M]; //뽑고자 하는 수를 담은 배열
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			
			int target_idx = deque.indexOf(seq[i]);
			int half_idx;
			
			//만약 현재 덱의 원소가 짝수개다? --> 절반크기에서 -1감소시킴
			
			if(deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			} else {
				half_idx = deque.size() / 2;
			}
			
			if(target_idx <= half_idx) {
				for(int j=0; j<target_idx; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count ++;
				} //pollFirst : 첫번째 요소 반환 + 제거 //pollLast : 마지막 요소 반환 + 제거
				//offerFirst : 맨앞에 객체 추가 //offerLast : 맨 끝에 객체 추가 
			} else {
				for(int j=0; j<deque.size() - target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(count);
		
		

	}

}
