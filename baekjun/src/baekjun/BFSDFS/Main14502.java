package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

//���� �����ڵ�
//dfs�� bfs�� ����� �����Ͱ�����
//dfs�� Ǯ��, ���̷����� ������ �־���ؼ�, dfs�޼��� ���� if���� ������ graph[x][y] == 2�� �Ѵ���
//[���������Ա�]����ó�� �����¿츦 ��������� ȣ���ϸ� �ɰͰ�����, �����Է�1���� [��]�� ��ǥ�� �Ķ���ͷ� �޴´ٰ� ������,
//�̶� graph[���� ��ǥ] = 0�̹Ƿ�, dfs�޼��� ���� if�� ���ǿ� �ɸ��� ����. -> �� �ٵ� dfs�޼��� ȣ�����ִ� �κп��� 2�϶��� �����ϰԲ� �ϸ� �ǰڳ�.
public class Main14502 {

    static int n,m,result;
    static int[][] graph, graph_2; //graph_2�� ���� ��ġ�ϰ� ������ Ȯ������ִ� ��.
    static ArrayList<Integer> value = new ArrayList<Integer>(); //���������� ������ ����ִ� ����
    static StringTokenizer st;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class coordinate{
        int x, y;

        coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static coordinate[] selected;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        graph_2 = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
                graph_2[i][j] = a;
            }
        }
        selected = new coordinate[3];
        rec_func(0);
        solution();
    }

    //rec_func�� �Ķ���ʹ� �� ��������, selected�� idx�� �ǹ���.
    static void rec_func(int cnt){
        if(cnt == 3){
            //�� 3���� ��� ����ٸ�, graph_2�� ���� ǥ��������.
            for(int i=0; i<3; i++){
                graph_2[selected[i].x][selected[i].y] = 1;
            }

            // dfs�޼���� ���̷����� Ȯ����Ѻ���.
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(graph_2[i][j] == 2){
                        dfs(i,j);
                    }
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    System.out.print(graph_2[i][j] + " ");
                }
                System.out.println();
            }

            //���������� ��������
            count();
            return;
        }

        int start_x;
        int start_y;

        if(cnt == 0){
            start_x = 0;
            start_y = 0;
        } else {
            start_x = selected[cnt-1].x + 1;
            start_y = selected[cnt-1].y + 1;
        }

        for(int x=start_x; x<n; x++){
            for(int y=start_y; y<m; y++){
                if(graph[x][y] == 0){
                    selected[cnt] = new coordinate(x,y);
                    rec_func(cnt + 1);
                }
            }
        }
    }

    //dfs�޼����� �Ķ����(x,y)�� ������ǥ�� �ǹ���.
    static boolean dfs(int x, int y){

        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                continue;
            }

            if(graph_2[nx][ny] == 1){
                continue;
            }

            if(graph_2[nx][ny] == 0 && !visited[nx][ny] && graph_2[x][y] == 2){
                visited[nx][ny] = true;
                graph_2[nx][ny] = 2;
                dfs(nx,ny);
            }
        }
        return false;
    }

    static void count(){

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph_2[i][j] == 0){
                    result += 1;
                }
            }
        }
        value.add(result);
        System.out.println(result);
        graph_2 = graph;
        visited = new boolean[n][m];
        result = 0;
    }

    //���������� �ִ� ���ϱ�
    static void solution(){
        Collections.sort(value);

        System.out.println(value.get(value.size()-1));
    }
}
