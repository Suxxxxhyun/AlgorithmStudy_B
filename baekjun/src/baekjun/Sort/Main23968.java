package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main23968 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		 
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int count = 0 ;
		
		for(int i=0; i<list.size() - 1; i++) {
			
			for(int j=0; j<list.size() - 1 - i; j++) {
				
				if(list.get(j) > list.get(j+1)) {
					Collections.swap(list, j, j+1);
					count++;
					if(count == K) {
						sb.append(list.get(j)).append(" ").append(list.get(j+1));
					}
				}
			}
		}
		
		if(count < K) {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}

}
