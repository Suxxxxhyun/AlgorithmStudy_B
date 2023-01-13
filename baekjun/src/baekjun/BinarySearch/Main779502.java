package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//호석님코드

/*
A의 수(N),B의 수(M)의 최댓값이 2만이므로 int가능
쌍의 개수를 담는 변수를 ans라고 하면, 20000*20000 = 400000000(4억) -> int가능
A의 첫번째 원소와 B의 첫번째부터 20000까지 .. A의 마지막원소와 B의 첫번째부터 20000까지 -> 총 4억의 연산이 걸리므로, 1초안에 풀수가 없어서
정렬을 해주고 가야할 필요가 있음.
A를 기준으로 B를 이분탐색하게되면, (즉, 예를 들어, A가 101이고 101보다 큰 것을 B에서 찾는 다고하면, B에서 선형탐색을 하는 것이 아니라,
이분탐색을 하면, log20000의 시간이 걸리고, A가 최대 2만개가 있으니까, 이분탐색 시간복잡도는 2만log2만일것임.
+ 입력의 시간복잡도는 t의 범위가 나와있지 않지만, A입력(2만) + B입력(2만)
+ a,b정렬의 시간복잡도 2만log2만 * 2 = 4만log2만
총 6만log2만 + 4만 => 1초안에 충분히 구현 가능
 */

public class Main779502 {

    static int t, n,m, ans, result, resultIdx;
    static int[] a,b;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n];
            b = new int[m+1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int k=1; k<=m; k++){
                b[k] = Integer.parseInt(st.nextToken());
            }
            pro();
        }

    }

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L...R] 에서 X 미만의 수 중 제일 오른쪽 인덱스를 return 하는 함수
        // 그런 게 없다면 L - 1 을 return 한다

        int res = L - 1;  // 만약 A[L...R] 중 X 이하의 수가 없다면 L - 1 을 return 한다.
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < X) {
                res = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return res;
    }

    static void pro() {
        // B 배열에 대해 이분탐색을 할 예정이니까, 정렬을 해주자!
        Arrays.sort(b, 1, m + 1);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // A[i] 를 선택했을 때, B 에서는 A[i]보다 작은 게 몇 개나 있는 지 count하기
            ans += lower_bound(b, 1, m, a[i]);
        }
        System.out.println(ans);
    }

}

