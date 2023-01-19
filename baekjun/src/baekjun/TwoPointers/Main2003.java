package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//�������� �������ͷ� �κ��ձ��ϴ� ������ ����.
public class Main2003 {

    static int n,m;
    static int[] a;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        pro();
    }

    static void pro(){
        int end = 0;
        int cnt = 0;
        int intervalSum = 0;

        for(int start = 0; start < n; start++){

            while(intervalSum < m && end < n){
                intervalSum += a[end];
                end += 1;
            }

            if(intervalSum == m){
                cnt += 1;
            }

            intervalSum -= a[start];
        }

        System.out.println(cnt);
    }
}
