package baekjun.src.baekjun.BackTrack;

import java.io.*;
import java.util.*;

//1842802를 토대로 내식대로 작성한 코드
public class Main18428 {

    static StringTokenizer st;
    static int n, B;
    static char[][] graph;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static ArrayList<Node> teachers = new ArrayList<Node>();
    static int[][] blank; //장애물이 설치될 위치를 담는 배열
    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];
        blank = new int[n*n + 1][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                char a = st.nextToken().charAt(0);
                graph[i][j] = a;
                if(a == 'X'){
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                } else if(a == 'T'){
                    teachers.add(new Node(i,j));
                }
            }
        }

        pro(0,1);
        System.out.println("NO");
    }

    //장애물이 설치될 수 있는 조합
    static void pro(int cnt, int idx){
        if(cnt == 3){
            if(dfs()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        if(idx > B){
            return;
        }

        graph[blank[idx][0]][blank[idx][1]] = 'O';
        pro(cnt + 1, idx + 1);
        graph[blank[idx][0]][blank[idx][1]] = 'X';
        pro(cnt, idx + 1);

    }


    static boolean dfs(){
        for(int i=0; i<teachers.size(); i++){
            int x = teachers.get(i).x;
            int y = teachers.get(i).y;
            for(int k=0; k<4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                while(isIn(nx,ny)){
                    if(graph[nx][ny] == 'S'){
                        return false;
                    }

                    if(graph[nx][ny] == 'O'){
                        break;
                    }

                    nx = nx + dir[k][0];
                    ny = ny + dir[k][1];
                }
            }
        }
        return true;
    }

    static boolean isIn(int nx, int ny){
        if(nx < 0 || ny < 0 || nx >= n || ny >= n){
            return false;
        } else {
            return true;
        }
    }
}
