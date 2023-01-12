package src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//��α� https://www.acmicpc.net/problem/12851����
//���� ����
//n�� k�� �ִ��� 10���̹Ƿ� int����
//�����̰� 0, ������ 10���� ��ġ�� �ִٰ� �Ѵٸ�(Ȥ�� �� �ݴ�)
//�̶��� ��쿡 ����Ͽ� 0���� 10�������� ��ġ�� �湮���θ� üũ�ϱ� ���� ũ�Ⱑ 10��1�� check�迭 ����
//bfs�� �������� ���ε�, bfs�� �ð����⵵�� O(N)�� �ð����⵵�� 2�ʾȿ� ����� ����Ǯ������.
public class Main12851 {

    static StringTokenizer st;
    static int n,k,count = 0;
    static int minTime = Integer.MAX_VALUE;
    static int[] check = new int[100001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) {
            sb.append(0).append('\n');
            sb.append(1);
        } else {
            bfs(n);
            sb.append(minTime);
            sb.append('\n');
            sb.append(count);
        }

        System.out.println(sb);
    }

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(n);
        check[n] = 1;

        while(!q.isEmpty()) {
            int x = q.poll();

            if(minTime < check[x]) {
                return;
            }

            for(int i=0; i<3; i++) {

                int next;

                if(i == 0) {
                    next = x - 1;
                } else if(i == 1) {
                    next = x + 1;
                } else {
                    next = x * 2;
                }

                if(next == k) {
                    count++;
                    minTime = check[x];
                }

                if (next < 0 || next > 100000)
                    continue;

                if(check[next] == 0 || check[next] == check[x] + 1) {
                    q.offer(next);
                    check[next] = check[x] + 1;
                }
            }
        }

    }

}
