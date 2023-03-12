package baekjun.src.baekjun.math;

import java.io.*;
import java.util.*;
//소수 판별법 - 제곱근 사용
public class Main1978 {

    static int n, cnt;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num < 2){
                continue;
            }

            int count = 0;
            for(int j=1; j<=Math.sqrt(num); j++){
                if(num % j == 0){
                    count++;
                }
            }

            if(count <= 1){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
