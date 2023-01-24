package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2559 {

    static int n,k,sum = 0;
    static int min = Integer.MIN_VALUE;
    //sum은, 10만일간 온도를 측정한다고 하였을때, 그 10만일간의 온도가 모두 100이라고 한다면,
    // 10^2*10^5 = 10^7이므로 int가능
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

        for(int L = 0, R = 0; L < n; L++){
            while(R + 1 <= n && R - L + 1 <= k){
                sum += a[R];
                R++;
            }
            if(R - 1 - L + 1 == k){
                min = Math.max(sum, min);
                sum -= a[L];
            }
        }
        System.out.println(min);
    }
}

