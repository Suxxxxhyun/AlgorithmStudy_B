package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ȣ�����ڵ�(���� �ٸ��� : determination�κи� �ٸ�!, �ӵ��� ���� ������.)
public class Main234302 {

    static int N, M;
    static int[] A;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        pro();
    }

    static void pro() {
        int L = A[1], R = 1000000000, ans = 0;
        for (int i = 1; i <= N; i++) L = Math.max(L, A[i]);  // ��� ���� �� ��ȭ���� ���� ��ŭ�� �ʿ��ϴ�!
        // [L ... R] ���� �ȿ� ������ �����Ѵ�!
        // �̺� Ž���� determination ������ �̿��ؼ� answer�� ������ ������!
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int len) {
        int cnt = 1, sum = 0;
        for (int i = 1; i <= N; i++) {
            if (sum + A[i] > len) {
                cnt++;
                sum = A[i];
            } else {
                sum += A[i];
            }
        }
        return cnt <= M;
    }
}
