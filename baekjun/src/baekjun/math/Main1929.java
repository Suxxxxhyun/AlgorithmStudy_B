package baekjun.src.baekjun.math;

import java.io.*;
import java.util.*;

public class Main1929 {

    static int m,n;
    static int[] prime;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        prime = new int[n+1];
        prime[0] = 0;
        prime[1] = 0;
        for(int i=2; i<=n; i++){
            prime[i] = i;
        }

        for(int i=2; i<=n; i++){
            if(prime[i] == 0){
                continue;
            }
            for(int j=i*2; j<=n; j=j+i){
                prime[j] = 0;
            }
        }

        for(int i=m; i<=n; i++){
            if(prime[i] != 0){
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
