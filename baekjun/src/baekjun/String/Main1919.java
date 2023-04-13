package baekjun.src.baekjun.String;

import java.io.*;
public class Main1919 {

    static char[] a1, a2;
    static String x1, x2;
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a1 = new char[26];
        a2 = new char[26];
        x1 = br.readLine();
        x2 = br.readLine();
        for(int i=0; i<x1.length(); i++){
            a1[x1.charAt(i) - 'a']++;
        }
        for(int i=0; i<x2.length(); i++){
            a2[x2.charAt(i) - 'a']++;
        }
        for(int i=0; i<26; i++){
            if(a1[i] != a2[i]){
                if(a1[i] > a2[i]){
                    cnt += a1[i] - a2[i];
                } else {
                    cnt += a2[i] - a1[i];
                }
            }
        }
        System.out.println(cnt);
    }
}
