package baekjun.src.baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//우소 : 우선순위큐에 기본구조는 최소힙이다.
//1. 입력(우선순위큐에 원소삽입) : log1 + log2 + log3 .. + logn = log(n!) => nlogn보다는 값이 작음 => 따라서, 시간복잡도는 nlogn
//2. 원소pop : nlogn
//3. 총 시간복잡도 : 2nlogn * t => 4백만log2십만
public class Main194602 {

    static int t,n, cnt;
    static StringTokenizer st;
    static PriorityQueue<candidate> pq = new PriorityQueue<candidate>();
    static StringBuilder sb = new StringBuilder();

    static class candidate implements Comparable<candidate>{
        int test1, test2; //test1은 서류, test2는 면접

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

