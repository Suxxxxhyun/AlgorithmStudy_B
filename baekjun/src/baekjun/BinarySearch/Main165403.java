package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ȣ�����ڵ�, ���� �ٸ�����, �̺�Ž���� ���������� �����ε�, ������ �ϰ� ���� ����!
//������ Ư�� ���̷� N���� ���� �� �ִ��� �������� �Ǵ��Ͽ�
//���� �� �ִٸ�, �׶��� mid���� ����ϰ� �� �ϰ� �ֱ⶧���� ������ ���� ���� �ʾƵ���.
public class Main165403 {
    static int K,N;
    static int[] A;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new int[K+1];
        for(int i=1; i<=K; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        //left�� 1�� ������ �� �ۿ� ���� ������,
        //���� ���, left = 0, right = 1�̾��� ��, mid���� 0
        //determination�޼��忡�� 0���� ������ �Ǵ� ��Ȳ�� �߻��ǹǷ�, left���� 1�� �����Ѵ�.
        pro();
    }

    static void pro() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0;
        // [L ... R] ���� �ȿ� ������ �����Ѵ�!
        // �̺� Ž���� determination ������ �̿��ؼ� answer�� ������ ������!
        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(long len) {
        // len ��ŭ�� ���̷� �������� �߶��� ��, N �� ��ŭ�� ������ ���� �� �ִ°�?
        long sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += A[i] / len;
        }
        return sum >= N;
    }
}
