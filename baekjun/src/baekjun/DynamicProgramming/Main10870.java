package baekjun.src.baekjun.DynamicProgramming;

import java.io.*;
public class Main10870 {

    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[21];
        pro(n);
    }

    static void pro(int x){

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=x; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[x]);
    }
}
