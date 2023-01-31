package baekjun.src.baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//��� : �켱����ť�� �⺻������ �ּ����̴�.
//1. �Է�(�켱����ť�� ���һ���) : log1 + log2 + log3 .. + logn = log(n!) => nlogn���ٴ� ���� ���� => ����, �ð����⵵�� nlogn
//2. ����pop : nlogn
//3. �� �ð����⵵ : 2nlogn * t => 4�鸸log2�ʸ�
public class Main194602 {

    static int t,n, cnt;
    static StringTokenizer st;
    static PriorityQueue<candidate> pq = new PriorityQueue<candidate>();
    static StringBuilder sb = new StringBuilder();

    static class candidate implements Comparable<candidate>{
        int test1, test2; //test1�� ����, test2�� ����

        public candidate(int test1, int test2) {
            this.test1 = test1;
            this.test2 = test2;
        }

        public int compareTo(candidate c) {
            return this.test1 - c.test1;
        }

        public String toString() {
            return "test1 : " + test1 + ", test2 : " + test2;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                pq.offer(new candidate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            pro();
        }
        System.out.println(sb);
    }

    static void pro() {

        candidate c = pq.poll();
        int x = c.test2;
        cnt = 1;

        while(!pq.isEmpty()) {
            candidate next = pq.poll();
            //System.out.println(next);

            if(x < next.test2) {
                continue;
            } else {
                x = next.test2;
                cnt += 1;
            }
        }
        sb.append(cnt).append('\n');
    }

}

