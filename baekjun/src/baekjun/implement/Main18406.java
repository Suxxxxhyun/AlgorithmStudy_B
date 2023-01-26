package baekjun.src.baekjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main18406 {

    static String n;
    static int front_sum = 0, back_sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();

        int len = n.length() / 2;
        for(int i=0; i<len; i++){
            front_sum += (n.charAt(i) - '0');
        }
        for(int i=len; i<n.length(); i++){
            back_sum += (n.charAt(i) - '0');
        }

        if(front_sum == back_sum){
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
