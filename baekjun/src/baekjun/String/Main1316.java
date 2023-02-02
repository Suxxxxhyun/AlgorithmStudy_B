package baekjun.src.baekjun.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//구현 성공
public class Main1316 {

    static int n, cnt;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String s = br.readLine();
            a = new int[26];
            if(pro(s)){
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }

    static boolean pro(String x){

        for(int i=0; i<x.length()-1; i++){
            if(x.charAt(i) == x.charAt(i+1)){
                a[x.charAt(i) - 'a'] = 1;
            } else {
                if(a[x.charAt(i+1) - 'a'] != 0){
                    return false;
                }
                a[x.charAt(i) - 'a'] = 1;
            }
        }
        return true;
    }

}
