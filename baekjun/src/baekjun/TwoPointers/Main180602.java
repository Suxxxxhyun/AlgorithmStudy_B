package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이코테 방식으로 구현 성공
public class Main180602 {
    static int n,s;
    static StringTokenizer st;
    static int[] a;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        a = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        pro();
    }

    static void pro() {
        int end = 0;
        int intervalSum = 0;
        int len = Integer.MAX_VALUE;

        for(int start = 0; start < n; start++) {

            while(intervalSum < s && end < n) {
                intervalSum += a[end];
                end += 1;
            }

            if(intervalSum >= s) {
                intervalSum -= a[start];
                len = Math.min(len, end - start);
            }
        }

        if(len == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(len);
        }
    }
}
