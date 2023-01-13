package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1300 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		/*int[][] A = new int[N+1][N+1];
		int[] B = new int[N*N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				A[i][j] = j*i;
				B[i] = j*i;
			}
		}*/
		
		long lo = 1;
		long hi = K;
		
		while(lo < hi) {
			long mid = (lo + hi) / 2;
			long count = 0;
			
			for(int i=1; i<=N; i++) {
				count += Math.min(mid/i, N);
			}
			
			if(K > count) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		
		System.out.println(lo);
		
		
		
		
		
	
	}

}
