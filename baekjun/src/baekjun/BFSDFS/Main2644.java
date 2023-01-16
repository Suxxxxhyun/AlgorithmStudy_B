package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//dfs�� 7�� �θ�, ������ ����ϴ� ������� ������ ����. �ð����⵵�� O(100)�̹Ƿ� 1�ʾȿ� ���� ����
//�־��� ������ a�� b�� �̼��� ����ϴ� ����.
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

        dfs(a, b, 0);
        System.out.println(res);
    }

    //�̼��� Ȯ�����ִ� �޼ҵ�
    static void dfs(int start, int end, int cnt){
        visited[start] = 1;
        if(start == end){
            res = cnt;
            return;
        }
       //System.out.println("start : " + start + ", end : " + end + ", cnt : " + cnt);

        for(int i=0; i<graph.get(start).size(); i++){
            if(visited[graph.get(start).get(i)] == 0){
                dfs(graph.get(start).get(i), end, cnt+1);
            }
        }
    }
}
