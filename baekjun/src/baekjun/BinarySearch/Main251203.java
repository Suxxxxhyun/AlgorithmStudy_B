package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ȣ�����ڵ�, ���� �ٸ�����, �̺�Ž���� ���������� �����ε�, ������ �ϰ� ���� ����!
//������ ���� �ʾƵ� �Ǵ� ������
//������ R�� ������ ��û�� ����� �� �ִ����� �����Ͽ���, �̸� ���� ���� mid������
//�� ������ ������ �����Ͽ�, �� ���� ���ϰ� �ȴ�.
public class Main251203 {

    static int N,M; //������ ��(n)�� �ִ��� ���̹Ƿ� int����, �� ����(m)�� �ʾ��̹Ƿ� int����
    static int[] A;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        A = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        pro();
    }

    static boolean determination(int limit) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(A[i], limit);
        }
        return sum <= M;
    }

    static void pro() {
        int L = 0, R = 0, ans = 0;
        for (int i = 1; i <= N; i++) {
            R = Math.max(R, A[i]);
        }
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
}
