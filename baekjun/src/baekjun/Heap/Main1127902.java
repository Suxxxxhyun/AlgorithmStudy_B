package baekjun.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main1127902 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		//내림차순으로 정렬할때 쓰는 Collections패키지의 reverorder() 메서드
		//최대값이 우선인, 즉 높은 숫자가 우선순위인, 우선순위큐 선언 = 최대힙
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(pq.isEmpty()) {
					sb.append(0);
					sb.append('\n');
				} else {
					sb.append(pq.poll());
					sb.append('\n');
				}
			} else {
				pq.add(x);
			}
		}
		System.out.println(sb);
		System.out.println(pq);
		

	}

}
