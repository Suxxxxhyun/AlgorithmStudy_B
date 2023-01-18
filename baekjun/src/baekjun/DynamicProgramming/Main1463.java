package baekjun.src.baekjun.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1463 {

    static int n;
    static int[] d = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        d[1] = 0;
        d[2] = 1;

        for(int i=3; i<=n; i++){

            d[i] = d[i - 1] + 1;

            if(i % 3 == 0){
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if(i % 2 == 0){
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
        }
        System.out.println(d[n]);
    }
}
