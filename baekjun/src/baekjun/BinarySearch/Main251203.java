package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//호석님코드, 나와 다른점은, 이분탐색의 전제조건은 정렬인데, 정렬을 하고 있지 않음!
//정렬을 하지 않아도 되는 이유는
//어차피 R은 지방이 요청한 예산들 중 최댓값으로 설정하였고, 이를 통해 얻은 mid값으로
//각 지방의 예산을 결정하여, 총 합을 구하게 된다.
public class Main251203 {

    static int N,M; //지방의 수(n)의 최댓값은 만이므로 int가능, 총 예산(m)은 십억이므로 int가능
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
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
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
