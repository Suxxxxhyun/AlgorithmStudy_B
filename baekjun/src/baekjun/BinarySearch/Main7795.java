package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//ȣ���ڵ� ����� ���Ǳ�������

/*
A�� ��(N),B�� ��(M)�� �ִ��� 2���̹Ƿ� int����
���� ������ ��� ������ ans��� �ϸ�, 20000*20000 = 400000000(4��) -> int����
A�� ù��° ���ҿ� B�� ù��°���� 20000���� .. A�� ���������ҿ� B�� ù��°���� 20000���� -> �� 4���� ������ �ɸ��Ƿ�, 1�ʾȿ� Ǯ���� ���
������ ���ְ� ������ �ʿ䰡 ����.
A�� �������� B�� �̺�Ž���ϰԵǸ�, (��, ���� ���, A�� 101�̰� 101���� ū ���� B���� ã�� �ٰ��ϸ�, B���� ����Ž���� �ϴ� ���� �ƴ϶�,
�̺�Ž���� �ϸ�, log20000�� �ð��� �ɸ���, A�� �ִ� 2������ �����ϱ�, �̺�Ž�� �ð����⵵�� 2��log2���ϰ���.
+ �Է��� �ð����⵵�� t�� ������ �������� ������, A�Է�(2��) + B�Է�(2��)
+ a,b������ �ð����⵵ 2��log2�� * 2 = 4��log2��
�� 6��log2�� + 4�� => 1�ʾȿ� ����� ���� ����
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
    //B = 1 1 1 1 1 �� ���� �������� ���õ� �� �ִ�. (��, �񳻸������ΰ����� ����ؾ���)
    //���� ����ؼ� ����������, x�� B�� ���� ���Ҹ� ã�������� or �ε����� �������� �ε����� ũ�ν� �ɶ� ã�Բ� �ϴ� ���� �ƴ϶�(��, ���߿� �ϳ��� ������Ų�ٸ� �����Ű�Բ� �ϴ� ���� �ƴ϶�),
    //�׳� ������ �ε����� �������� �ε����� ũ�ν� �ɶ����� ������������ �д�.
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
