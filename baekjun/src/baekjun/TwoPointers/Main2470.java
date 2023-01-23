package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//호석님코드, 투포인터 방식
//L은 남아있는 것들 중, 가장 작은 원소, R은 남아있는 것들 중, 가장 큰 원소를 선택하는데,
//이를 미리 정렬시킨뒤, 투포인터 방식으로 진행 -> 총 시간복잡도는 O(N) + O(NlogN)
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

    static void pro(){
        //최대, 최소원소를 빠르게 찾기 위해서 정렬을 해주자.
        Arrays.sort(A, 1, N+1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, L = 1, R = N;

        while(L < R){
            if(best_sum > Math.abs(A[L] + A[R])){
                best_sum = Math.abs(A[L] + A[R]);
                v1 = A[L];
                v2 = A[R];
            }
            if(A[L] + A[R] > 0){
                R--;
            } else {
                L++;
            }
        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }
}
