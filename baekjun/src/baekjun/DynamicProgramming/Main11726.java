package baekjun.src.baekjun.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11726 {

    static int n;
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pro();
    }

    static void pro(){

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        /*dp[3] = 3;
        dp[4] = 2 + 2;
        dp[5] = 3 + 4*/

        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n] % 10007);
    }
}
