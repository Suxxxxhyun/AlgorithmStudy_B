package baekjun.src.baekjun.TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//ȣ�����ڵ�, �������� ���
//L�� �����ִ� �͵� ��, ���� ���� ����, R�� �����ִ� �͵� ��, ���� ū ���Ҹ� �����ϴµ�,
//�̸� �̸� ���Ľ�Ų��, �������� ������� ���� -> �� �ð����⵵�� O(N) + O(NlogN)
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
        //�ִ�, �ּҿ��Ҹ� ������ ã�� ���ؼ� ������ ������.
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
