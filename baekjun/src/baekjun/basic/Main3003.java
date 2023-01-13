package baekjun.src.baekjun.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3003 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int[] arr1 = new int[6];
		arr1[0] = 1;
		arr1[1] = 1;
		arr1[2] = 2;
		arr1[3] = 2;
		arr1[4] = 2;
		arr1[5] = 8;
		
		int[] arr2 = new int[6];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr3 = new int[6];
		
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] == arr2[i]) {
				arr3[i] = 0;
			} else {
				arr3[i] = arr1[i] - arr2[i];
			}
		}
		
		for(int value : arr3) {
			sb.append(value + " ");
		}
		
		System.out.println(sb);
		
		
	}

}
