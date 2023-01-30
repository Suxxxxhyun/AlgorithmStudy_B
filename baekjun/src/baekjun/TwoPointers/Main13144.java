package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//길이가 10만인 수열에서, 원소가 1부터 10만까지 모두 다른 숫자로 이루어진 수열이라고 가정할때,
//이때 경우의 수는 50억이 나오므로, 정답을 나타내는 변수는 int가 아닌 long으로 설정한다.

/*
1 2 3 1 2
1
1 2
1 2 3       => L=1번째 인덱스일때

  2
  2 3
  2 3 1     => L=2번째 인덱스일때

    3
    3 1
    3 1 2   => L=3번째 인덱스일때

      1
      1 2   => L=4번째 인덱스일때


        2   => L=5번째 인덱스일때
*/


public class Main13144 {

    static int n;
    static int[] a;
    static long ans;
    static int[] count = new int[100001];
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        a = new int[n+1];
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        pro();
    }

    static void pro(){

        ans = 0;

        for(int L = 1, R = 0; L <= n; L++){
            while(R + 1 <= n && count[a[R+1]] == 0){
                R += 1;
                count[a[R]] = 1;
            }
            ans += (R - L + 1);
            count[a[L]] = 0;
        }
        System.out.println(ans);
    }
}
