package baekjun.RecursiveCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*********dp ÀÌ¿כ*********/

public class Main1087002 {
	
	public static void FiboDp(int n) {
		int [] dp = new int[n+1];
		
		for(int i=0; i<dp.length; i++) {
			if(i == 0) {
				dp[0] = 0;
			} else if(i == 1) {
				dp[1] = 1;
			} else {
				dp[i] = dp[i-1] + dp[i-2];
			}
		}
		
		System.out.println(dp[n]);
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		FiboDp(n);
	}

}
