package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//n�� �ִ� 10^5 = �ʸ�
//x�� �ִ� 2*10^6 = 2�鸸
//�� ���� �ִ� 10^6, ��� int����
//������ ��� ��������, �鸸C2 (�̶�, C�� combination�� ����)
public class Main3273 {

    static int n,x;
    static int[] nums;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        nums = new int[n+1];
        for(int i=1; i<=n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        pro();
    }

    static void pro(){
        Arrays.sort(nums, 1, n+1);

        int right = n;
        int ans = 0, cnt = 0;
        for(int i=1; i<=n; i++){
            int a = nums[i];
            int left = i + 1;

            while(left <= right){
                int mid = (left + right) / 2;
                if(x - a <= nums[mid]){
                    ans = mid;
                    if(determination(mid, a)){
                        cnt++;
                    }
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean determination(int m, int a){
        if(a + nums[m] == x){
            return true;
        } else {
            //System.out.println("mid : " + m + ", a : " + a);
            return false;
        }
    }
}
