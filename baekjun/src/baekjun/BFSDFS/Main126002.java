package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//이코테 구현 활용, 두번째 방법
public class Main126002 {
    static int n,m,v;
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        for(int i=0; i<n+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=1; i<=n; i++) {
            if(graph.get(i) != null) {
                Collections.sort(graph.get(i));
            }
        }

        dfs(v);
        visited = new boolean[n+1];
        sb.append('\n');
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int start) {

        visited[start] = true;
        sb.append(start).append(' ');

        for(int i=0; i<graph.get(start).size(); i++) {
            int x = graph.get(start).get(i);
            if(!visited[x]) {
                dfs(x);
            }
        }
    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int y = q.poll();
            sb.append(y).append(' ');
            for(int i=0; i<graph.get(y).size(); i++) {
                int x = graph.get(y).get(i);
                if(!visited[x]) {
                    visited[x] = true;
                    q.offer(x);
                }
            }
        }
    }
}
