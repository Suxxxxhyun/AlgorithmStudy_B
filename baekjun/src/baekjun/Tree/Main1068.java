package baekjun.src.baekjun.Tree;

import java.io.*;
import java.util.*;

//호석님코드(실패)
public class Main1068 {

    static int n, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;
    //leaf[x] = x를 root로 하는 단말노드의 개수
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        child = new ArrayList[n];
        leaf = new int[n];
        for(int i=0; i<n; i++){
            child[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int par = Integer.parseInt(st.nextToken());
            if(par == -1){
                root = i;
                continue;
            }
            child[par].add(i);
        }
        /*for(int i=0; i<n; i++){
            System.out.println(child[i]);
        }*/
        erased = Integer.parseInt(br.readLine());
        pro();
    }

    static void pro(){
        //erased와 그의 부모 사이의 연결을 끊어주기
        for(int i=0; i<n; i++){
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }

        /*for(int i=0; i<n; i++){
            System.out.println(child[i]);
        }*/

        //erased가 root인 예외 처리하기
        if(root != erased){
            dfs(root, -1);
        }

        for(int i=0; i<leaf.length; i++){
            System.out.print(leaf[i] + " ");
        }
        System.out.println(leaf[root]);
    }

    static void dfs(int x, int par){
        if(child[x].isEmpty()){
            leaf[x]++;
        }
        for(int y : child[x]){
            if(y == par){
                continue;
            }
            dfs(y,x);
            leaf[x] += leaf[y];
        }
    }
}
