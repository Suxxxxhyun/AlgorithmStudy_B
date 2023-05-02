package baekjun.src.baekjun.DynamicProgramming;

//9:00 ~ 9:30
import java.io.*;
public class Main1003 {

    static int t;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp = new int[41][2];

        for(int i=0; i<t; i++){
            pro(Integer.parseInt(br.readLine()));
        }

        System.out.println(sb);
    }

    static void pro(int n){

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<=n; i++){
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }

        sb.append(dp[n][0] + " " + dp[n][1]).append('\n');
    }
}
