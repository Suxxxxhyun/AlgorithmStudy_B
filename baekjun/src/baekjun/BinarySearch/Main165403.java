package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//호석님코드, 나와 다른점은, 이분탐색의 전제조건은 정렬인데, 정렬을 하고 있지 않음!
//랜선의 특정 길이로 N개를 만들 수 있는지 없는지를 판단하여
//만들 수 있다면, 그때의 mid값을 출력하게 끔 하고 있기때문에 정렬을 굳이 하지 않아도됨.
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

        //left를 1로 설정할 수 밖에 없는 이유는,
        //예를 들어, left = 0, right = 1이었을 때, mid값은 0
        //determination메서드에서 0으로 나누게 되는 상황이 발생되므로, left값을 1로 설정한다.
        pro();
    }

    static void pro() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
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
        // len 만큼의 길이로 랜선들을 잘랐을 때, N 개 만큼의 랜선을 얻을 수 있는가?
        long sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += A[i] / len;
        }
        return sum >= N;
    }
}
