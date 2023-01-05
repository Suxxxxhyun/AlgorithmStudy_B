package baekjun.HashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main17219 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String,String> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			hm.put(st2.nextToken(), st2.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			sb.append(hm.get(br.readLine()));
			sb.append("\n");
		}
		System.out.println(sb);
		
		
		
	}

}
