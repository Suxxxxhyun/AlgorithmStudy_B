package baekjun.src.baekjun.DynamicProgramming;

import java.io.*;
//https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-15991-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-6-Java
public class Main15991 {

    static int t;
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp = new long[100001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;
        for(int i=7; i<=100000; i++){
            dp[i] = (dp[i-6] + dp[i-4] + dp[i-2]) % 1000000009;
        }

        for(int i=0; i<t; i++){
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
    }
}
