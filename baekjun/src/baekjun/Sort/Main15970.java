package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
���� ����(n)�� �ִ� 5õ, ��ġ(x)�� �ִ� �ʸ�, ���� ����(n)�� 5õ�̸� ����(y)�� �ִ� 5õ���� -> ��� int����
��� ���� ���ؼ� ���� ������ ���� �ٸ� ���� �׻� �����Ѵ�.��� �Ͽ����Ƿ�
���� ����(n)�� 5õ�̶�� �Ѵٸ�, ����(y)�� 2500������ ����
���� ���� ���� �ٸ� �� ���� ���� �ָ� �������ִ� ���� (0,10^5) �̶��� �Ÿ��� �ʸ�. -> ȭ��ǥ�� ���̴� �̽ʸ�.
2500���� ��� �ִ� �Ÿ��� �ʸ��̶�� �Ѵٸ� �̶��� ȭ��ǥ�� ���̴� 2500*2*10^5 => �� 5���̹Ƿ�, ȭ��ǥ�� �� ���̸� ��� ������ int�� ������ �־ ��
o(n^2) -> �ð����⵵ ���͵� Ȯ�� ===========================================
������ �ε����� �Ͽ� ��ġ������ ��� �迭a�� �ִٸ� �� �迭a�� ���� ���� ������ ��ġ�� ���ϰ� ��
1. �迭a�� ������ �ε����� �Ͽ� ��ġ������ ��� �ð����⵵ O(N)
2. ������ ��ġ�� ���� => nlongn
3. �¿츶�� ���̸� Ȯ���ϴ� ���� ����ð��� �����
4. �ٵ� 3���� ��� ���� ���ؼ� �¿츦 Ȯ��������ϹǷ� O(N)
-> �� �ð����⵵�� nlogn�̶�� �� �� ����
 */
public class Main15970 {

    static int n;
    static ArrayList<Integer>[] a;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int color=1; color<=n; color++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[y].add(x);
        }

        solution();
    }

    static void solution(){
        for(int i=1; i<=n; i++){
            Collections.sort(a[i]);
        }

        int ans = 0;

        for(int color=1; color<=n; color++){
            for(int i=0; i<a[color].size(); i++) {
                int left_distance = left(color,i);
                int right_distance = right(color,i);
                ans += Math.min(left_distance,right_distance);
            }
        }

        System.out.println(ans);
    }

    static int left(int color, int idx){
        if(idx == 0){ // ���ʿ� �� �̻� ���� ���� ����
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx) - a[color].get(idx-1);
    }

    static int right(int color, int idx){
        if(idx + 1 == a[color].size()){ // �����ʿ� �� �̻� ���� ���� ����
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx+1) - a[color].get(idx);
    }
}
