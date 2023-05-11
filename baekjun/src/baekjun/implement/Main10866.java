package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
public class Main10866 {

    static int n;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if(str.equals("push_front")){
                int x = Integer.parseInt(st.nextToken());
                dq.offerFirst(x);
            } else if(str.equals("push_back")){
                int x = Integer.parseInt(st.nextToken());
                dq.offerLast(x);
            } else if(str.equals("pop_back")){
                if(dq.isEmpty()){
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.pollLast()).append('\n');
                }
            } else if(str.equals("pop_front")){
                if(dq.isEmpty()){
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.pollFirst()).append('\n');
                }
            } else if(str.equals("size")){
                sb.append(dq.size()).append('\n');
            } else if(str.equals("empty")){
                if(dq.isEmpty()){
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if(str.equals("front")){
                if(dq.isEmpty()){
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.peekFirst()).append('\n');
                }
            } else {
                if(dq.isEmpty()){
                    sb.append(-1).append('\n');
                } else {
                    sb.append(dq.peekLast()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
