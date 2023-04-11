package baekjun.src.baekjun.TwoPointers;

import java.io.*;
import java.util.*;
//9:33 ~ 9:40
public class Main3273 {

    static int n,x;
    static int[] a;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        pro();
    }

    static void pro(){
        Arrays.sort(a);
        int L = 0, R = n-1, cnt = 0;
        //�� L<=R�� �ȵɱ�? �̰� �����غ��� -> �������� ���� �ٸ� ���� ������ ���� X�� �Ǵ� �����.
        while(L < R){
            int sum = a[L] + a[R];
            if(sum < x){
                L++;
            } else {
                if(sum == x){
                    cnt++;
                }
                R--;
            }
        }
        System.out.println(cnt);
    }
}