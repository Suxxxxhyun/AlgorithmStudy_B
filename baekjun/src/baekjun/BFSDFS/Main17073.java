package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//잘못된 접근  : 리프노드의 개수를 구하기 위해서, 또, 트리문제길래 당연히 dfs/bfs와 연관지어서 생각했는데
//이런과정 필요없이 graph에서 요소가 1개인것이 곧 리프노드임.
//따라서 요소가 1개인(size=1)것을 카운트해주면 됨.
public class Main17073 {

    static int n, w, count;
    static StringTokenizer st;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //System.out.println(graph);
        pro();
        double result = (double)w / (double)count;
        System.out.println(result);
    }

    static void pro(){
        //그래프의 입력이 1 2 로만 주어진다면
        //graph는 [[], [2], [1]] .. 이러한 정보를 갖게되며
        //이때, i = 1부터 시작하게 되면 리프도느드의 개수가 2가 되므로,
        //리프노드의 개수를 세기 위해서 무조건 i=2부터 시작해야함.
        for(int i=2; i<n+1; i++){
            if(graph.get(i).size() == 1){
                count++;
            }
        }
    }
}
