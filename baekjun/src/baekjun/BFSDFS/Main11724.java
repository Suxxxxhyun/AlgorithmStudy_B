package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11724 {

    static int n,m, cnt = 0;
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        //System.out.println(graph);
        for(int i=1; i<=n; i++){
            if(dfs(i)){
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }

    static boolean dfs(int start){
        if(!visited[start]){
            visited[start] = true;
            for(int i=0; i<graph.get(start).size(); i++){
                int x = graph.get(start).get(i);
                //System.out.println(x);
                dfs(x);
            }
            return true;
        } else {
            return false;
        }
    }
}
