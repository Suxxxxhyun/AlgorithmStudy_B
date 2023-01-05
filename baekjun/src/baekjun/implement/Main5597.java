package baekjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Main5597 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int [] arr = new int[30];
		
		for(int i=0; i<30; i++) {
			arr[i] = i+1;
		}
		
		String str;
		
		for(int j=0; j<28; j++) {
			str = br.readLine();
			arr[Integer.parseInt(str) - 1] = 0;
		}
		
		
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				sb.append(arr[i]);
				sb.append('\n');
			}
		}

		
		System.out.println(sb);

	}

}
