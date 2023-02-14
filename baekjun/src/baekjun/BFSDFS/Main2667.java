package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//구현 성공
//인접행렬로 구현한 것이 아닌이유
//인접행렬(i,j)는 정점 i와 정점 j의 연결관계를 나타내는것인데,
//미로탐색에서의 (i,j)는 하나의 정점을 나타내는 것일 뿐, 정점 i와 정점 j의 연결관계가 아님!
//그럼 인접리스트인 이유는?
//한 정점에서 모든 정점을 확인하는 것이 아닌, 갈 수있는 정점만 확인하는 것이기때문에,
//내 코드는 인접리스트임.
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
