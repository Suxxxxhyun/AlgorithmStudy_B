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
			/*for(int j=0; j<N; j++) { //--> while(st.hasMoreTokens())�ص� ������� ��?
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
		//System.out.println(pq); --> ��������Ʈ�� ������ ��µǱ⶧���� �Ϻ��� ���������� �ƴ϶� ��������Ʈ���� ����� ������� ��µ��� �� �� �ִ�.

	}

}
