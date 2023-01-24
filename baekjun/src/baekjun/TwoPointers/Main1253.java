package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//���� ����
public class Main1253 {

    static int n;
    static StringTokenizer st;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        pro();
    }

    static void pro(){
        //�ּ�, �ִ븦 ������ �˱� ���� ����
        Arrays.sort(a, 1, n+1); //2000log2000

        int ans = 0;
        for(int i=1; i<=n; i++){
            //i��° ���Ұ� ���� �ٸ� �μ��� ������ ǥ���� �Ǵ°�?
            if(func(i)){
                ans++;
            }
        }
        System.out.println(ans);
    }

    //target_idx��° ���Ұ� ���� �ٸ� �μ��� ������ ǥ���� �Ǵ°�?
    static boolean func(int target_idx){
        int L = 1, R = n;
        int target = a[target_idx];
        while(L < R){
            if(L == target_idx){
                L++;
            } else if(R == target_idx){
                R--;
            } else {
                if(a[L] + a[R] > target){
                    R--;
                } else if(a[L] + a[R] == target){
                    return true;
                } else {
                    L++;
                }
            }
        }
        return false;
    }
}
