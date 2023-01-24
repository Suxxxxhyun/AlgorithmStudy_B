package baekjun.src.baekjun.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916 {

    static int n, m, start, end;
    static ArrayList<ArrayList<Bus>> graph = new ArrayList<ArrayList<Bus>>();
    static int[] d;
    static StringTokenizer st;

    static class Bus implements Comparable<Bus>{
        public int index, distance;

        public Bus(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Bus other){
            return this.distance - other.distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        d = new int[n+1];
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<Bus>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Bus(b,cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        Arrays.fill(d, Integer.MAX_VALUE);

        dijkstra();
    }

    static void dijkstra(){
        PriorityQueue<Bus> pq = new PriorityQueue<>();

        d[start] = 0;
        pq.offer(new Bus(start, 0));

        while(!pq.isEmpty()){
            Bus node = pq.poll();
            int idx = node.index;
            int cost = node.distance;

            if(cost > d[idx]){
                continue;
            }

            for(int i=0; i<graph.get(idx).size(); i++){
                int dist = d[idx] + graph.get(idx).get(i).distance;
                if(dist < d[graph.get(idx).get(i).index]){
                    d[graph.get(idx).get(i).index] = dist;
                    pq.offer(new Bus(graph.get(idx).get(i).index, dist));
                }
            }
        }
        System.out.println(d[end]);

    }
}
