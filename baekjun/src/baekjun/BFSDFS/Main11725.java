package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://velog.io/@darak/BJ-11725-%ED%8A%B8%EB%A6%AC%EC%9D%98-%EB%B6%80%EB%AA%A8-%EC%B0%BE%EA%B8%B0-Java��α� ����
//����� ����(n)�� �ִ� 10���̹Ƿ�, int����
//bfs�� �ð����⵵�� O(N)�̹Ƿ�, O(�ʸ�) -> 1�ʾȿ� ��������
public class Main11725 {

    static int n;
    static int[] visited, parent; //parent�� �θ��带 �������ִ� �迭
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

    //2�� ������ �θ��� ��带 ���
    static void output(){
        for(int i=2; i<=n; i++){
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }
}

