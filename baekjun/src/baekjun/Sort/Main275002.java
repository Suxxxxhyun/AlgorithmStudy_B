package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

/****************선택 정렬 이용****************/

public class Main275002 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int n=0; n<arr.length-1; n++) {
			int lowest = n;
			for(int i=n+1; i<arr.length; i++) {
				if(arr[lowest] > arr[i]) {
					lowest = i;
				}
			}
			int temp = arr[n];
			arr[n] = arr[lowest];
			arr[lowest] = temp;
		}
		
		for(int list : arr) {
			System.out.println(list);
		}

	}

}
