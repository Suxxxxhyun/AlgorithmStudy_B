package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//구현실패, 호석님코드
//n은 10만이하, A에 들어갈 각 원소의 범위는 -10억보다 크거나 같고 10억보다 작거나 같으므로 int가능, int[]가능
//합을 담는 변수가 최대20억, 최하-20억이므로, int가능
//왼쪽을  -2로 설정하였다면 2와 가장 가까운 것을 찾도록 할 것이며,
//2와 가장 가까운 것을 선형탐색이 아닌 이분탐색으로 찾자.
//이분 탐색전에 정렬을 미리 해주어야하니, nlogn의 시간복잡도
//이분탐색은 logn의 시간복잡도가 소요되는데 이것을 n번 실행해줘야하니까 총 nlogn
//따라서 nlogn(정렬) + nlogn(이분탐색) = 결국 nlogn의 시간복잡도가 소요된다.
//또한, result의 범위를 2이상의 원소중 가장 왼쪽의 원소를 찾는 인덱스로 설정할 것임.

public class Main2470 {

    static int N;
    static int[] A;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        pro();

    }

    static void pro() {
        // A 에 대해 이분 탐색을 할 예정이니까, 정렬을 미리 해주자.
        Arrays.sort(A, 1, N + 1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int left = 1; left <= N - 1; left++) {
            // A[left] 용액을 쓸 것이다. 고로 -A[left] 와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾자.
            int candidate = lower_bound(A, left + 1, N, -A[left]);

            // A[candidate - 1] 와 A[candidate] 중에 A[left] 와 섞었을 때의 정보를 정답에 갱신시킨다.

            // 1. A[left] + A[candidate - 1]
            if (left < candidate - 1 && Math.abs(A[left] + A[candidate - 1]) < best_sum) {
                best_sum = Math.abs(A[left] + A[candidate - 1]);
                v1 = A[left];
                v2 = A[candidate - 1];
            }

            // 2. A[left] + A[candidate]
            if (candidate <= N && Math.abs(A[left] + A[candidate]) < best_sum) {
                best_sum = Math.abs(A[left] + A[candidate]);
                v1 = A[left];
                v2 = A[candidate];
            }

        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 R + 1 을 return 한다

        int res = R + 1;  // 만약 A[L...R] 중
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }
}
