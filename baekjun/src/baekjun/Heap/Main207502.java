package baekjun.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//https://tweety1121.tistory.com/entry/%EB%B0%B1%EC%A4%80-2075%EB%B2%88-N%EB%B2%88%EC%A7%B8-%ED%81%B0-%EC%88%98-%EC%9E%90%EB%B0%94

public class Main207502 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int[][] arr = new int [N][N];
		
		for(int i=0; i<N; i++) {
			String [] line = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				pq.add(arr[i][j]); //2차원배열로 add해준다하더라도 그냥 12,7,9,15,5,13,8 ..이런순서로 삽입된다.
			}
		}
		
		//System.out.println(pq);
		
		for(int i=1; i<=N; i++) {
			if(i == N) {
				System.out.println(pq.poll());
			}
			pq.poll();
		}

	}

}
