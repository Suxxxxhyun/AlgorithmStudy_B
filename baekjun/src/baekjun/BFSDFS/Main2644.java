package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//dfs로 7의 부모, 조상을 기록하는 방법으로 접근할 것임. 시간복잡도는 O(100)이므로 1초안에 구현 가능
//주어진 문제는 a와 b의 촌수를 계산하는 것임.
public class Main2644 {

    static int n,m, res = -1;
    static int a,b;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] visited = new int[101];
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>()); //***
        }
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(c).add(d);
            graph.get(d).add(c);
        }

        /*for(int i=1; i<=n; i++){
            System.out.print(graph.get(i) + " ");
        }*/

        dfs(a, b, 0);
        System.out.println(res);
    }

    //촌수를 확인해주는 메소드
    static void dfs(int start, int end, int cnt){
        visited[start] = 1;
        if(start == end){
            res = cnt;
            return;
        }
       //System.out.println("start : " + start + ", end : " + end + ", cnt : " + cnt);

        for(int i=0; i<graph.get(start).size(); i++){
            if(visited[graph.get(start).get(i)] == 0){
                //파라미터로 cnt++을 해주면 안되는 이유 : dfs(graph.get(start).get(i), end, cnt++); 이라고 한다면
                //dfs(graph.get(start).get(i), end, cnt++); << 이 함수가 다 종료되고 그제서야 cnt값이 증가되기때문에, cnt + 1로 해줘야함
                dfs(graph.get(start).get(i), end, cnt+1);
            }
        }
    }
}
