package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//�߸��� ����  : ��������� ������ ���ϱ� ���ؼ�, ��, Ʈ�������淡 �翬�� dfs/bfs�� ������� �����ߴµ�
//�̷����� �ʿ���� graph���� ��Ұ� 1���ΰ��� �� ���������.
//���� ��Ұ� 1����(size=1)���� ī��Ʈ���ָ� ��.
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
        //�׷����� �Է��� 1 2 �θ� �־����ٸ�
        //graph�� [[], [2], [1]] .. �̷��� ������ ���ԵǸ�
        //�̶�, i = 1���� �����ϰ� �Ǹ� ������������ ������ 2�� �ǹǷ�,
        //��������� ������ ���� ���ؼ� ������ i=2���� �����ؾ���.
        for(int i=2; i<n+1; i++){
            if(graph.get(i).size() == 1){
                count++;
            }
        }
    }
}
