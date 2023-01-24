package baekjun.src.baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구현 실패
public class Main1439 {

    static String str;
    static StringTokenizer st1, st2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        st1 = new StringTokenizer(str, "0");
        st2 = new StringTokenizer(str, "1");
        //System.out.println(st1.countTokens());
        //System.out.println(st2.countTokens());
        System.out.println(Math.min(st1.countTokens(), st2.countTokens()));
    }
}
