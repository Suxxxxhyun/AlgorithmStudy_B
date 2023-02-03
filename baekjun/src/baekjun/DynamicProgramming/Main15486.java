package baekjun.src.baekjun.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//���� ����
//https://technote-mezza.tistory.com/61��α� ����
public class Main15486 {

    static int n, max = Integer.MIN_VALUE;
    static StringTokenizer st;
    static int[] t,p;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //������ ��¥���� �����Ϸ���, ����ϴ� ��¥(n+1)���� �ִ�ݾ��� ã�ƾ��ϱ⶧���� n+2�� �������.
        dp = new int[n+2];
        t = new int[n+2];
        p = new int[n+2];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        pro();

    }

    static void pro(){
        for(int i=1;i<=n+1;i++) {
            //���� ��¥�� dp�迭���� max�� �� ū ������ �����Ѵ�.
            max = Math.max(max, dp[i]);

            //i���� ����, t[i]+i�Ͽ� dp���� ������.
            //�� 1���϶�, t[1]+1 => 4�Ͽ� dp���� ������
            if(i+t[i] <= n+1)
                dp[i+t[i]] = Math.max(max+p[i], dp[i+t[i]]);

        }
        System.out.println(max);
    }

}
