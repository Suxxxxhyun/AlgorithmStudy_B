package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//호석코드 듣기전 강의구현성공

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
public class Main7795 {

    static int t, n,m, ans, result, resultIdx;
    static int[] a,b;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            a = new int[n];
            b = new int[m+1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int k=1; k<=m; k++){
                b[k] = Integer.parseInt(st.nextToken());
            }
            solution();
        }

        System.out.println(sb);
    }

    static void solution(){
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i=0; i<n; i++){
            result = 0;
            resultIdx = 0;
            ans += binarySearch(1,m,a[i]);
        }
        sb.append(ans).append('\n');
        ans = 0;
    }

    //A = 2 2 2 2 2
    //B = 1 1 1 1 1 와 같이 문제에서 제시될 수 있다. (즉, 비내림차순인경우까지 고려해야함)
    //위를 대비해서 종료조건을, x와 B가 같은 원소를 찾을때까지 or 인덱스와 오른쪽의 인덱스가 크로스 될때 찾게끔 하는 것이 아니라(즉, 둘중에 하나만 만족시킨다면 종료시키게끔 하는 것이 아니라),
    //그냥 왼쪽의 인덱스와 오른쪽의 인덱스가 크로스 될때만을 종료조건으로 둔다.
    static int binarySearch(int leftIdx, int rightIdx, int x){
        int mid = (leftIdx + rightIdx) / 2;
        if(leftIdx > rightIdx){
            return mid;
        }

        if(x > b[mid]){
            return binarySearch(mid + 1, rightIdx, x);
        } else {
            return binarySearch(leftIdx, mid - 1, x);
        }
    }
}
