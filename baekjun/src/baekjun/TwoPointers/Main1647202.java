package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//구현 실패
//kind를 O(26)로 계산하는 코드
public class Main1647202 {
    static int n, kind;
    static String A;
    static int [] cnt = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = br.readLine();
        pro();
    }

    static void pro(){
        int len = A.length(), ans = 0;
        for(int L=0, R=0; R < len; R++){
            //R번째 문자를 오른쪽에 추가
            add(A.charAt(R));


            //불가능하면, 가능할때까지 L을 이동
            while(true){
                kind = 0;
                for(int i=0; i<26; i++){
                    if(cnt[i] != 0){
                        kind++;
                    }
                }
                if(kind <= n){
                    break;
                }
                erase(A.charAt(L));
                L++;
            }

            //정답갱신
            //System.out.println((R - L + 1) + "R = " + R + "L = " + L);
            ans = Math.max(ans, R - L + 1);
        }
        System.out.println(ans);
    }

    static void add(char x){
        cnt[x - 'a']++;
        if(cnt[x - 'a'] == 1){
            kind++;
        }
    }

    static void erase(char x){
        cnt[x - 'a']--;
        if(cnt[x - 'a'] == 0){
            kind--;
        }
    }
}
