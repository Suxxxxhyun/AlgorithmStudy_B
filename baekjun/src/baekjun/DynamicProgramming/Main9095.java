package baekjun.src.baekjun.DynamicProgramming;

//12:30 ~ 1:00
import java.io.*;
public class Main9095 {

    static int t;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int j=4; j<=10; j++){
            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
        }

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
