package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//구현실패
/*
n은 최대 10^5, k는 최대 10^9,
n이 10^5일때, 원소의 총 개수는 10^5^2, 이 모든 원소를 일차원배열B에 넣게되면, 10^10이므로, 이미 시간초과가 남.
*/

//블로그(https://st-lab.tistory.com/281)풀이
/*
B[11] = 8의 의미는 8이라는 값보다 작거나 같은 원소의 개수는 11개라고 재해석할 수 있음. (B가 어차피 오름차순 정렬이기때문에)

정리하면, B[k] = x라는 의미는 x보다 작거나 같은 원소의 개수는 최소 k개라는 의미이다.
이때, B[k] = x에서 k인덱스의 원소 값 x를 찾는 것인데, x의 값을 조정해가면서 x보다 작거나 같은 원소의 개수가 k값이랑 일치하면 된다는 뜻!
즉, x를 mid로 잡자는 것!

또, 행렬A에서 각 행마다, 1단, 2단, 3단.. 이런식으로 원소가 이루어지게 된다는 것을 알 수 있다.
이때, 임의의 x에 대해서 x보다 작거나 같은 원소의 개수를
일일히 세어보는 것이 아니라, (1단에 있는 원소 / x + 2단에 있는 원소 / x ... + n단에 있는 원소 / x)를 하게되면,
x보다 작거나 같은 원소의 개수를 빠르게 구할 수 있다.

또, 임의의 x에 대해서 x의 범위는 1부터 n^2까지인데, 예를 들어, n=4라고 한다면, x의 초기범위는 1부터 16까지라는 것을 알 수 있음.
이때, 범위를 줄일수 없을까?

블로그에서 확인해보면 알겠지만, 결국 x<=k라는 사실을 알 수 있음.
정리하면 x의 범위를 1부터 k까지로 좁힐 수 있다.

그리고, 난 블로그와 다르게 그냥, 이분탐색으로 진행하였지, lowerbound를 사용하지 않음. (이 부분은, https://steady-coding.tistory.com/20블로그 참조)
 */

public class Main130002 {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        pro();
    }

    static void pro(){
        int L = 1, R = k, ans = 0;

        while(L <= R){
            int mid = (L + R) / 2;
            int count = 0;

            for(int i=1; i<=n; i++){
                count += Math.min(mid / i, n);
            }

            if(count < k){
                L = mid + 1;
            } else {
                ans = mid;
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
