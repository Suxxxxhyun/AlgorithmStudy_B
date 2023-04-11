package baekjun.src.baekjun.greedy;

import java.io.*;
public class Main14916 {

    static int n,cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while(n > 0){
            if(n % 5 == 0){
                cnt = n / 5 + cnt;
                break;
            }
            n -= 2;
            cnt += 1;
            //11
            //9
            //7
            //5
        }

        if(n < 0){
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }
}
