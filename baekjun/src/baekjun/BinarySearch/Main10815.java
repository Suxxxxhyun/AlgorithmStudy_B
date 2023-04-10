package baekjun.src.baekjun.BinarySearch;

import java.io.*;
import java.util.*;
public class Main10815 {

    static int n,m;
    static int[] a;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        //50��log50��
        Arrays.sort(a);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<m; i++){
            int b = Integer.parseInt(st.nextToken());
            int val = pro(b);
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }

    static int pro(int num){
        //N�� ������ 1���� 50��������, ���� L�� R�� ������ 0���� 499999�� ����.
        int L = 0, R = a.length - 1, ans = -1;
        while(L <= R){
            int mid = (L + R) / 2;

            if(a[mid] > num){
                R = mid - 1;
            } else if(a[mid] < num){
                L = mid + 1;
            } else {
                ans = mid;
                break;
            }
        }
        if(ans == -1){
            return 0;
        } else {
            return 1;
        }
    }
}
