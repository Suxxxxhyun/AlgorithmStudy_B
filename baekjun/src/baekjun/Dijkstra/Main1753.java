package baekjun.src.baekjun.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1753 {

    static int v,e,start;
    static StringTokenizer st;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int[] d = new int[20001];
    static StringBuilder sb = new StringBuilder();

    static class Node implements Comparable<Node>{
        private int index, distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
        public int getIndex(){
            return this.index;
        }

        public int getDistance(){
            return this.distance;
        }

        public int compareTo(Node other){
            return this.distance - other.distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        for(int i=0; i<v+1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
        }

        Arrays.fill(d,Integer.MAX_VALUE);

        dijkstra();

        for(int i=1; i<=v; i++){
            if(d[i] == Integer.MAX_VALUE){
                sb.append("INF").append('\n');
            } else {
                sb.append(d[i]).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int idx = node.getIndex();
            int cost = node.getDistance();

            for(int i=0; i<graph.get(idx).size(); i++){

                int dist = d[idx] + graph.get(idx).get(i).getDistance();

                if(d[graph.get(idx).get(i).getIndex()] > dist){
                    d[graph.get(idx).get(i).getIndex()] = dist;
                    pq.offer(new Node(graph.get(idx).get(i).getIndex(),dist));
                }
            }
        }
    }
}
