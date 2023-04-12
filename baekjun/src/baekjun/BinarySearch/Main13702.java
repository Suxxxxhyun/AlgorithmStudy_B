package baekjun.src.baekjun.BinarySearch;

//2:30 ~ 3:00
//������ ���ɸ��� �뷮(x)�� ������, k���� �й��� �� �ֳ�?����?

import java.io.*;
import java.util.*;
public class Main13702 {

    static int n,k;
    static int[] a;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        pro();
    }

    static void pro(){
        long L = 0, R = Integer.MAX_VALUE, ans = 0;
        while(L <= R){
            long mid = (L + R) / 2;
            if(determination(mid)){
                L = mid + 1;
                ans = mid;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(long x){
        long sum = 0;
        for(int i=0; i<a.length; i++){
            if(x > a[i]){
                continue;
            }
            sum += ((long)a[i] / x);
        }
        return (sum >= k) ? true : false;
    }
}
