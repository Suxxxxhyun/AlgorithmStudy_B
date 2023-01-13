package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ȣ�����ڵ�
public class Main280503 {

    static int n,m;
    static long sum;
    static int[] a;
    static StringTokenizer st;

    static void pro() {
        long L = 0, R = 2000000000, ans = 0;
        // [L ... R] ���� �ȿ� ������ �����Ѵ�!
        // �̺� Ž���� determination ������ �̿��ؼ� answer�� ������ ������!
        while (L <= R) {
            int mid = (int) ((L + R) / 2);
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int H) {
        // H ���̷� �������� �߶��� ��, M ��ŭ�� ���� �� ������ true, ������ false�� return�ϴ� �Լ�
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] > H) {
                sum += a[i] - H;
            }
        }
        return sum >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            int height = Integer.parseInt(st.nextToken());
            a[i] = height;
        }

        pro();
    }
}
