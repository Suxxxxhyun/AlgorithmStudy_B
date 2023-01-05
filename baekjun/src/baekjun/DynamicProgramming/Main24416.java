package baekjun.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main24416 {
	
	static int count = 0;
	static int count2 = 0;
	
	static int RecursiveCall(int n) {

		if(n <= 2) {
			count++;
			return 1;
		} else {
			return RecursiveCall(n-1) + RecursiveCall(n-2);
		}
	}
	
	static void dpfib(int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<dp.length; i++) {
			dp[i] = dp[i-2] + dp[i-1];
			count2++;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		RecursiveCall(n);
		System.out.print(count);
		System.out.print(" ");
		dpfib(n);
		System.out.print(count2);
	}

}
