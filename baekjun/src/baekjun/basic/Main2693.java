package baekjun.src.baekjun.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main2693 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			
			int var = 0; 
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int [] arr = new int[10];
			
			for(int j=0; j<10; j++) {
				
				arr[j] = Integer.parseInt(st.nextToken());
				//System.out.println(arr[j]);
			}
			
			Arrays.sort(arr);
			
			/*for(int k : arr) {
				System.out.println(k);
			}*/
		
			var = arr[arr.length - 3];
			sb.append(var);
			sb.append('\n');
			
		}
		
		System.out.println(sb);
		
		

	}

}
