package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
//bfs�ڵ�� �ٲ�µ���.. �ð��ʰ��� ����.
public class Main132502 {

    static int n,m, cnt, max = Integer.MIN_VALUE;
    static int[] result;
    //static ArrayList<Node> ans = new ArrayList<Node>();
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
        result = new int[n+1];
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
            bfs(i);
            /*if(cnt >= max){
                ans.add(new Node(i,cnt));
            }*/
            result[i] = cnt;
            max = Math.max(cnt, max);
            visited = new boolean[n+1];
            cnt = 0;
        }

        //System.out.println(ans);
        for(int i=1; i<n; i++){
            if(max == result[i]){
                sb.append(i).append(' ');
            }
        }

        /*for(int i=0; i<ans.size(); i++){
            if(ans.get(i).count == max){
                sb.append(ans.get(i).idx).append(' ');
            }
        }*/

        System.out.println(sb);

    }

    static void bfs(int start){
        cnt += 1;
        Queue<Integer> q = new LinkedList<Integer>();
        visited[start] = true;
        q.offer(start);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0; i<graph[node].size(); i++){
                if(!visited[graph[node].get(i)]){
                    visited[graph[node].get(i)] = true;
                    cnt += 1;
                    q.offer(graph[node].get(i));
                }
            }
        }
    }

}

