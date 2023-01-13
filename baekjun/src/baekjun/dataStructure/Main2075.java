package baekjun.src.baekjun.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2075 {
	
	public static int N;
	public static StringTokenizer st;
	//일반적으로 우선순위큐는 오름차순 -> 기본구조는 최소힙
	//public static PriorityQueue<Integer> pq = new PriorityQueue<>();
	//내림차순
	public static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int j=0; j<N; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		/*for(int k : pq) {
			System.out.print(k + " ");
		}
		System.out.println();*/
		
		
		for(int i=0; i<N-1; i++) {
			pq.poll();
		}
		
		
		System.out.println(pq.peek());
	}

}
