package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
public class Main1927 {

    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    }
}
