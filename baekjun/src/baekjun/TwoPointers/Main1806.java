package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ȣ�����ڵ�(��������)
public class Main1806 {

    static int n,s;
    static int[] a;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        a = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        pro();
    }

    static void pro() {
        int R = 0, sum = 0, ans = n + 1;
        for (int L = 1; L <= n; L++) {
            // L - 1 �� �������� �����ϱ�
            sum -= a[L - 1];

            // R �� �ű� �� ���� �� ���� �ű��
            while (R + 1 <= n && sum < s){
                sum += a[++R];
            }

            // [L ... R] �� ��, �� sum�� ������ �����ϸ� ���� �����ϱ�
            if (sum >= s)
                ans = Math.min(ans, R - L + 1);
            System.out.println("L : " + L + ", R : " + R + ",ans : " + ans);
        }

        // ans ���� ���� �Ұ��� �Ǵ��ϱ�
        if (ans == n + 1)
            ans = 0;
        System.out.println(ans);
    }

}
