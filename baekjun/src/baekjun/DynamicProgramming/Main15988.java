package baekjun.src.baekjun.DynamicProgramming;

//9:24 ~ 9:54
import java.io.*;
public class Main15988 {

    static int t;
    static long[] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp = new long[1000001];
        pro();
        for(int i=0; i<t; i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }

        System.out.println(sb);
    }

    static void pro(){
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=1000000; i++){
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
        }
    }
}
