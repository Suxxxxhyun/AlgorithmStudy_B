package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

//구현 실패코드
//dfs든 bfs든 상관이 없을것같은데
//dfs로 풀면, 바이러스가 무조건 있어야해서, dfs메서드 안의 if문의 조건이 graph[x][y] == 2로 한다음
//[음료수얼려먹기]문제처럼 상하좌우를 재귀적으로 호출하면 될것같은데, 예제입력1에서 [하]의 좌표를 파라미터로 받는다고 했을때,
//이때 graph[하의 좌표] = 0이므로, dfs메서드 안의 if문 조건에 걸리지 않음. -> 아 근데 dfs메서드 호출해주는 부분에서 2일때만 진행하게끔 하면 되겠네.
public class Main14502 {

    static int n,m,result;
    static int[][] graph, graph_2; //graph_2는 벽을 설치하고 실제로 확산시켜주는 곳.
    static ArrayList<Integer> value = new ArrayList<Integer>(); //안전영역의 개수를 담아주는 공간
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

    //rec_func의 파라미터는 고른 갯수이자, selected의 idx를 의미함.
    static void rec_func(int cnt){
        if(cnt == 3){
            //벽 3개를 모두 골랐다면, graph_2에 벽을 표시해주자.
            for(int i=0; i<3; i++){
                graph_2[selected[i].x][selected[i].y] = 1;
            }

            // dfs메서드로 바이러스를 확산시켜보자.
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

            //안전영역의 개수세기
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

    //dfs메서드의 파라미터(x,y)는 시작좌표를 의미함.
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

    //안전영역의 최댓값 구하기
    static void solution(){
        Collections.sort(value);

        System.out.println(value.get(value.size()-1));
    }
}
