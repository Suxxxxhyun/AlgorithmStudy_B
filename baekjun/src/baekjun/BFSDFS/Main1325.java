package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
//�ð��ʰ� �ڵ�(dfs�ڵ�� ǰ) -> bfs�� dfs�� �ð����⵵�� ������, ���������� dfs�� �ð����⵵�� �� ���� �ɸ�.
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
        //n�� �ִ�ġ = ��
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        //m�� �ִ�ġ = �ʸ�
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        //n�� �ִ�ġ = �� * ��������Ʈ�� Ǯ������, O(�� + �ʸ�) => �뷫 �ʸ� * �� = �鸸
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
