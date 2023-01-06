package baekjun.src.baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//시간초과
public class Main4134 {

    static int t; //t(테스트의 개수) -> 범위가 나와있지 않으므로 pass
    static double n; //n의 최댓값이 4십억이므로, int불가능(2^30 = 십억)
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            n = Double.parseDouble(br.readLine());
            solution(n);
        }

        System.out.println(sb);
    }

    static void solution(double num){

        while (true){
            if(confirm(num)){
                sb.append(Math.round(num)).append('\n');
                return;
            }
            num++;
        }
    }

    //소수인지 판별하는 함수(소수는 자기자신과 1만 약수로 갖는 수)
    static boolean confirm(double num){
        int count = 0;
        //루트 num까지만 생각하여 나눠떨어지는 수가 있는지 판별하기(https://st-lab.tistory.com/81블로그참조)
        for(int i=2; i<=Math.round(Math.sqrt(num)); i++){
            if(num % i == 0){
                count++;
            }

            if(count > 1){
                break;
            }
        }

        return count < 1;
    }
}
