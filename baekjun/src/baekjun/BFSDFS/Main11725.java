package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://velog.io/@darak/BJ-11725-%ED%8A%B8%EB%A6%AC%EC%9D%98-%EB%B6%80%EB%AA%A8-%EC%B0%BE%EA%B8%B0-Java블로그 참조
//노드의 개수(n)는 최대 10만이므로, int가능
//bfs의 시간복잡도는 O(N)이므로, O(십만) -> 1초안에 구현가능
public class Main11725 {

    static int n;
    static int[] visited, parent; //parent는 부모노드를 저장해주는 배열
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        visited = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        output();
    }

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[x] = 1;

        while(!q.isEmpty()){
            int y = q.poll();

            for(int i=0; i<graph.get(y).size(); i++){
                if(visited[graph.get(y).get(i)] == 0){
                    q.offer(graph.get(y).get(i));
                    parent[graph.get(y).get(i)] = y;
                    visited[graph.get(y).get(i)] = 1;
                }
            }
        }
    }

    //2번 노드부터 부모의 노드를 출력
    static void output(){
        for(int i=2; i<=n; i++){
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }
}

