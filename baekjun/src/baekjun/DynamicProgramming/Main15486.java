package baekjun.src.baekjun.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구현 실패
//https://technote-mezza.tistory.com/61블로그 참조
public class Main15486 {

    static int n, max = Integer.MIN_VALUE;
    static StringTokenizer st;
    static int[] t,p;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //마지막 날짜까지 포함하려면, 퇴사하는 날짜(n+1)에서 최대금액을 찾아야하기때문에 n+2를 해줘야함.
        dp = new int[n+2];
        t = new int[n+2];
        p = new int[n+2];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        pro();

    }

    static void pro(){
        for(int i=1;i<=n+1;i++) {
            //현재 날짜의 dp배열값과 max값 중 큰 값으로 갱신한다.
            max = Math.max(max, dp[i]);

            //i일의 경우는, t[i]+i일에 dp값을 갱신함.
            //즉 1일일때, t[1]+1 => 4일에 dp값을 갱신함
            if(i+t[i] <= n+1)
                dp[i+t[i]] = Math.max(max+p[i], dp[i+t[i]]);

        }
        System.out.println(max);
    }

}
