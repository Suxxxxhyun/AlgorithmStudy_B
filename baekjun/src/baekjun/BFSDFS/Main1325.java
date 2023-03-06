package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
//시간초과 코드(dfs코드로 품) -> bfs와 dfs의 시간복잡도는 같지만, 실질적으로 dfs의 시간복잡도가 더 오래 걸림.
public class Main1325 {

    static int n,m, cnt, max = Integer.MIN_VALUE;
    static ArrayList<Node> ans = new ArrayList<Node>();
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static class Node{
        int count, idx;

        public Node(int idx, int count){
            this.idx = idx;
            this.count = count;
        }

        public String toString(){
            return "idx = " + idx + ", count = " + count;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        //n의 최대치 = 만
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        //m의 최대치 = 십만
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        //n의 최대치 = 만 * 인접리스트로 풀었으니, O(만 + 십만) => 대략 십만 * 만 = 백만
        for(int i=1; i<=n; i++){
            dfs(i);
            if(cnt >= max){
                ans.add(new Node(i,cnt));
            }
            max = Math.max(cnt, max);
            visited = new boolean[n+1];
            cnt = 0;
        }

        for(int i=0; i<ans.size(); i++){
            if(ans.get(i).count == max){
                sb.append(ans.get(i).idx).append(' ');
            }
        }

        System.out.println(sb);

    }

    static void dfs(int start){
        cnt += 1;
        visited[start] = true;
        for(int i=0; i<graph[start].size(); i++){
            if(!visited[graph[start].get(i)]){
                dfs(graph[start].get(i));
            }
        }
    }

}
