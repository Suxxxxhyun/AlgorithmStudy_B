package baekjun.src.baekjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구현 성공(제한시간내에 풀지는 못했음)
public class Main20546 {

    static int money1, A, B, money2;
    static int[] a = new int[15];
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        money1 = Integer.parseInt(br.readLine());
        money2 = money1;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=14; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        A = pro1();
        //System.out.println(A);
        B = pro2();
        //System.out.println(B);
        compare();
    }

    static int pro1(){
        int ans = 0, cnt = 0;
        for(int i=1; i<=14; i++){
            if(money1 >= a[i]) {
                ans = money1 / a[i];
                cnt += ans;
                money1 -= (ans * a[i]);
            }
        }
        return money1 + (a[14] * cnt);
    }

    static int pro2(){
        int ans = 0, up = 0, down = 0, cnt = 0;

        for(int L=1, R=2; L<14; L++){
            while(R + 1 <= 15 && R - L + 1 <= 4){
                if(a[R] > a[R - 1]){
                    up += 1;
                } else if(a[R] < a[R - 1]){
                    down += 1;
                } else {
                    R++;
                    break;
                }
                R++;
            }
            if(up == 3){
                if(cnt != 0){
                    money2 += a[R - 1] * cnt;
                    cnt = 0;
                }
            } else if(down == 3){
                ans = money2 / a[R - 1];
                cnt += ans;
                money2 -= a[R - 1] * (ans);
            }
            if(a[L] < a[L + 1]){
                up -= 1;
            } else if(a[L] > a[L + 1]) {
                down -= 1;
            }
            if(R == 14){
                break;
            }
        }
        return money2 + a[14] * cnt;
    }

    static void compare(){
        if(A == B){
            System.out.println("SAMESAME");
        } else if(A > B){
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }
    }
}
