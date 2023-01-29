package baekjun.src.baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1263 {

    static int n;
    static int[][] a;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a, (a1,a2) -> a2[1] - a1[1]);

        /*for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }*/

        int endTime = a[0][1] - a[0][0];

        for(int i=1; i<n; i++){
            if(a[i][1] < endTime){
                endTime = a[i][1];
            }
            endTime = endTime - a[i][0];
        }

        if(endTime >= 0){
            System.out.println(endTime);
        } else {
            System.out.println(-1);
        }
    }
}
