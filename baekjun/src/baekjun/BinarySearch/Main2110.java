package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//��������
//ȣ�����ڵ�
public class Main2110 {

    static int n,c;
    static int[] a; //���� ��ġ�� ��� �迭
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        a = new int[n+1];
        for(int i=1; i<=n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        pro();
    }

    static void pro() {
        // determination�� ������ �ϱ� ���ؼ� ����������.
        Arrays.sort(a, 1, n + 1);

        int L = 1, R = 1000000000, ans = 0;
        // [L ... R] ���� �ȿ� ������ �����Ѵ�!
        // �̺� Ž���� determination ������ �̿��ؼ� answer�� ������ ������!
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int D) {
        // D ��ŭ�� �Ÿ� ���̸� �дٸ� C �� ��ŭ�� �����⸦ ��ġ�� �� �ִ°�?

        // ���� ���� ������ ������ ���� ��ġ�غ���!
        // D ��ŭ�� �Ÿ��� �θ鼭 �ִ�� ��ġ�� ������ C �� ������.
        int cnt = 1, last = a[1];
        for (int i = 2; i <= n; i++) {
            if (a[i] - last < D) {
                continue;
            }
            last = a[i];
            cnt++;
            /*
            if (a[i] - last >= D) {
                last = a[i];
                cnt++;
            }
             */
        }
        return cnt >= c;
    }

}
