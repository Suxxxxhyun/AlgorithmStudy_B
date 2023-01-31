package baekjun.src.baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//정렬하는데 시간복잡도 십만log십만 + for문시간복잡도(십만) => 십만log십만 * 20 => 200백만log십만
public class Main194603 {

    static int t,n, cnt;
    static StringTokenizer st;
    static ArrayList<candidate> list = new ArrayList<candidate>();
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
                list.add(new candidate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list);
            pro();
            list = new ArrayList<candidate>();
        }
        System.out.println(sb);
    }

    static void pro() {

        candidate c = list.get(0);
        //System.out.println(c);
        int x = c.test2;
        cnt = 1;

        for(int i=1; i<list.size(); i++) {
            candidate next = list.get(i);
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

