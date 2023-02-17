package baekjun.src.baekjun.Tree;

import java.io.*;
import java.util.*;

//https://code-lab1.tistory.com/111��α� ����
//������ȸ(preorder) : ��Ʈ - ���� - ������
//������ȸ(inorder) : ���� - ��Ʈ - ������
//������ȸ(postorder) : ���� - ������ - ��Ʈ
//https://www.youtube.com/watch?v=1VNWJTbE2pM ��Ʃ�� ����

//�־��� Ʈ���� ������ ���ϱ� ���ؼ��� �� root�� ��ĥ �ʿ�� ����.
//Ʈ���� �ִ� ������ ���ϱ� ���ؼ��� ������忡 �����ؾߵ�.(������ �ƴѰ����� �����Ѵٸ�, �̴� �ִ� ������ �ƴ�!)
//��, �������� ������尣�� �Ÿ���.
//����, ��� ������忡�� dfsŽ���� �Ͽ� �ٸ� ������������ �Ÿ��� ���ϰ�, �ִ� �Ÿ��� �����ϸ� ��.

//������带 �����ϴ� �����, ��Ʈ��尡 �ƴϸ鼭 �����尡 1������ ��带 ���ϸ� ��.
//������带 �����Ͽ� ���� �����س���, ��� ������忡�� dfsŽ���� �����ϸ� �ȴ�.
public class Main1967{

    static int N, ans;
    static ArrayList<Pair> tree[];
    static boolean visited[];

    static class Pair{
        int link;
        int w;
        Pair(int a, int b){
            this.link = a;
            this.w = b;
        }
    }
    static ArrayList<Integer> leaf = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new Pair(b,c));
            tree[b].add(new Pair(a,c));
        }

        /* ������� ���ϱ� */
        for(int i=2; i<=N; i++) {
            if(tree[i].size() <2) {
                leaf.add(i);
                //System.out.println(i);
            }
        }

        /* ��� ������忡�� DFS Ž�� */
        for(int i=0; i<leaf.size(); i++) {
            visited = new boolean[N+1];
            visited[leaf.get(i)] = true;
            dfs(leaf.get(i), 0, leaf.get(i));
        }

        System.out.println(ans);

    }
    private static void dfs(int idx, int sum, int start) {
        if(tree[idx].size() == 1 && idx != start) {    // ���������
            ans = Math.max(ans,sum);
            return;
        }

        for(int i=0; i<tree[idx].size(); i++) {
            int next = tree[idx].get(i).link;
            if(!visited[next]) {
                visited[next] = true;
                dfs(next, sum+tree[idx].get(i).w, start);
            }
        }
    }
}