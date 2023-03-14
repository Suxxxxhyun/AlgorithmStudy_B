package baekjun.src.baekjun.Tree;

import java.io.*;
import java.util.*;

//호석님 코드
//* dfs메서드에 파라미터를 2개줌으로써 visited를 구현하지 않아도 됨.
public class Main1172502 {
    static int n;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    //static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n+1];
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        pro();
    }

    static void pro(){
        //1번 정점이 root이므로, 1번 정점부터 파악하자.
        //dfs메서드에 파라미터를 2개줌으로써 visited를 구현하지 않아도 됨.
        dfs(1, -1);

        for(int i=2; i<=n; i++){
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }

    //par = parent
    static void dfs(int x, int par){
        for(int y : adj[x]){
            if(y == par){
                continue;
            }
            parent[y] = x;
            dfs(y,x);
        }
    }
}
