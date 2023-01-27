package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//구현 성공
public class Main2667 {

    static int n, cnt, h;
    static ArrayList<Integer> house = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static String a;
    static int[][] visited, graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new int[n][n];
        for(int i=0; i<n; i++){
            a = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = a.charAt(j) - '0';
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dfs(i,j)){
                    cnt += 1;
                    house.add(h);
                    h = 0;
                }
            }
        }
        sb.append(cnt).append('\n');
        Collections.sort(house);
        for(int i=0; i<house.size(); i++){
            sb.append(house.get(i)).append('\n');
        }
        System.out.println(sb);
    }

    static boolean dfs(int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= n){
            return false;
        }
        if(graph[x][y] == 1 && visited[x][y] == 0){
            visited[x][y] = 1;
            h += 1;
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x,y-1);
            dfs(x,y+1);
            return true;
        } else {
            return false;
        }
    }
}
