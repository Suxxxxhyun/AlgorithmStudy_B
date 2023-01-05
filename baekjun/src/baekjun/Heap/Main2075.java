package baekjun.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2075 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
				
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			/*for(int j=0; j<N; j++) { //--> while(st.hasMoreTokens())해도 상관없을 듯?
				pq.offer(Integer.parseInt(st.nextToken()));
			}*/
			while(st.hasMoreTokens()) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		//System.out.println(pq);
		
		for(int i=0; i<N-1; i++) {
			pq.poll();
		}
		
		System.out.println(pq.poll());
		//System.out.println(pq); --> 완전이진트리 구조로 출력되기때문에 완벽한 내림차순이 아니라 완전이진트리에 저장된 순서대로 출력됨을 알 수 있다.

	}

}
