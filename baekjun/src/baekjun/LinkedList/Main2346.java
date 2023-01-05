package baekjun.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main2346 { //뭐지..? 구현이 이해 안됨. nxt에 1번을 in이 가리키도록 하고있는거임? //백준 2346일단 패스
						//https://loosie.tistory.com/453 --> baekjun.Queue / main2346에 풀음

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<int []> q = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] arr = new int[N];
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("1");
		int in = arr[0]; // 3을 가리키게 하고 있음
		
		for(int i=1; i<N; i++) {
			q.add(new int[] {(i+1), arr[i]});
		}
		
		while(!q.isEmpty()) {
			if(in > 0) {
				for(int i=1; i<in; i++) {
					q.add(q.poll());
				}
				
				int[] nxt = q.poll();
				in = nxt[1];
				sb.append(nxt[0] + " ");
			}
		}
		
		

	}

}
