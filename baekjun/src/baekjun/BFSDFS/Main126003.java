package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

//인접행렬로 구현하는 경우,
//정점a에서 갈 수 있는 정점을 확인하는 시간이 o(v), 이를 모든 정점에 대해서 생각해줘야하므로,
//o(v^2)만큼 시간복잡도가 소요된다.
//공간복잡도 역시 o(v^2)임!
public class Main126003 {

    static int n,m,v;
    static int[][] graph;
    static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v);
        sb.append('\n');
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(' ');

        for(int i=1; i<=n; i++){
            if(!visited[i] && graph[start][i] == 1){
                dfs(i);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int x = q.poll();
            sb.append(x).append(' ');

            for(int i=1; i<=n; i++){
                if(!visited[i] && graph[x][i] == 1){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
