package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
public class Main11866 {
    static int n,k;
    static StringTokenizer st;
    static Deque<Integer> dq = new LinkedList<Integer>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; i++){
            dq.offer(i);
        }
        pro();
    }

    static void pro(){

        sb.append('<');
        while(dq.size() > 1){
            for(int i=0; i<k; i++){
                dq.offerLast(dq.pollFirst());
            }
            sb.append(dq.pollLast()).append(',').append(' ');
        }
        sb.append(dq.pollFirst()).append('>');
        System.out.println(sb);
    }
}
