package baekjun.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main11004 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//큰 숫자를 우선으로 해서 poll해줌.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		
		/*while(st1.hasMoreTokens()) {
			pq.offer(Integer.parseInt(st1.nextToken()));
		}*/
		
		for(int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(st1.nextToken()));
		}
		
		if(K==1) {
			System.out.println(pq.poll());
		} else {
			for(int i=0; i<K-1; i++) {
				pq.poll();
			}
			System.out.println(pq.poll());
		}
		
		System.out.println(pq);
		
		

	}

}
