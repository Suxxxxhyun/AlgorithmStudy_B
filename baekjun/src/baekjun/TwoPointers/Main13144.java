package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//���̰� 10���� ��������, ���Ұ� 1���� 10������ ��� �ٸ� ���ڷ� �̷���� �����̶�� �����Ҷ�,
//�̶� ����� ���� 50���� �����Ƿ�, ������ ��Ÿ���� ������ int�� �ƴ� long���� �����Ѵ�.

/*
1 2 3 1 2
1
1 2
1 2 3       => L=1��° �ε����϶�

  2
  2 3
  2 3 1     => L=2��° �ε����϶�

    3
    3 1
    3 1 2   => L=3��° �ε����϶�

      1
      1 2   => L=4��° �ε����϶�


        2   => L=5��° �ε����϶�
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
