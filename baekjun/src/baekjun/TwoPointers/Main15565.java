package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15565 {

    static int n,k;
    static int[] a;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        pro();
    }

    static void pro(){
        int cnt = 0, ans = Integer.MAX_VALUE;

        for(int L = 0, R = 0; L < n; L++){
            //cnt <= k가 되서는 안되는 이유,
            //예제를
            //7 1
            //2 2 2 1 2 2 2로 입력하게 되면 알게 됨.
            while(R + 1 <= n && cnt < k){
                if(a[R] == 1){
                    cnt += 1;
                }
                R++;

                if(cnt == k){
                    break;
                }
            }
            if(cnt == k){
                //System.out.println(L + "," + R);
                ans = Math.min(ans, (R - 1) - L + 1);
                if(a[L] == 1){
                    cnt -= 1;
                }
            }
        }
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
