package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2397002 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		
		int [] A = new int[N];
		int [] B = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}
		
		int count = 0;
		boolean swap = false;
		
		if(check(A, B)) {
			count = 1;
			System.out.println(count);
			return;
		} else {
			for(int i=0; i<A.length-1; i++) {
				for(int j=0; j<A.length-1-i; j++) {
						
					if(A[j] > A[j+1]) {
						//Collections.swap(list, j, j+1);
						int temp = A[j+1];
						A[j+1] = A[j];
						A[j] = temp;
						swap = true;
						if((A[j] == B[j]) && (A[j+1] == B[j+1])) {
							if(check(A, B)) {
								count = 1;
								break;
							}
						}
					}
				}
			}
				
			System.out.print(count);
		}
		

	}
	
	public static boolean check(int [] dataList1, int [] dataList2) {
		return Arrays.equals(dataList1, dataList2);
	}
	
	

}
