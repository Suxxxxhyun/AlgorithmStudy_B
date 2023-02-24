package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
//https://gh402.tistory.com/27블로그 참조
//구현 실패
public class Main18405 {

    static StringTokenizer st;
    static int n,k,s,x,y;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                int a =Integer.parseInt(st.nextToken());
                graph[i][j] = a;
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        for(int i=0; i<s; i++){
            for(int j=1; j<=k; j++){
                if(graph[x-1][y-1] != 0){
                    break;
                }
                bfs(j);
            }
        }
        System.out.println(graph[x-1][y-1]);
    }

    public static void bfs(int virus){
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == virus){
                    q.add(new Node(i,j));
                }
            }
        }

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int k=0; k<4; k++){
                int nx = node.x + dir[k][0];
                int ny = node.y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                    continue;
                }

                if(graph[nx][ny] != 0){
                    continue;
                }

                graph[nx][ny] = virus;
            }
        }
    }
}
