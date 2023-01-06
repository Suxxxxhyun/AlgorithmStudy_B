package baekjun.src.baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//컴파일에러(도저히 모르겠음, 근데 버려도 될듯)
public class Main413402 {

    static int t;
    static boolean prime[] = new boolean[10004002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            long num = Long.parseLong(br.readLine());
            var bi = new BigInteger(String.valueOf(num));

            if(bi.isProbablePrime(10)){
                System.out.println(num);
            } else {
                System.out.println(bi.nextProbablePrime());
            }
        }
    }
}
