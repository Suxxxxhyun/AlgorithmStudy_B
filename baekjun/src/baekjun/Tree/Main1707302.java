package baekjun.src.baekjun.Tree;

import java.io.*;
import java.util.*;

/*
-기존의 인접리스트ArrayList<ArrayList<Integer>>가 아닌 ArrayList<Integer>[]로 바꿔서 풀어봄.
-이렇게 하면, 객체를 생성해주는 부분에서 graph = new ArrayList[n+1];
-또, 각 인덱스마다 ArrayList를 생성해줘야하므로, for문을 통해, graph[i] = new ArrayList<Integer>();로 함.
 */

public class Main1707302 {

    static int n,w,u,v,cnt;
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=2; i<=n; i++) {
            if(graph[i].size() == 1) {
                cnt += 1;
            }
        }

        System.out.println((double)w / (double)cnt);
    }

}

