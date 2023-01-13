package baekjun.src.baekjun.Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * �ΰ� ����
 */
public class Main1047302 {
    static class Coordinate {
        float x;
        float y;

        public Coordinate(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int destination;
        float time;

        public Edge(int destination, float time) {
            this.destination = destination;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return Float.compare(this.time, o.time);
        }
    }

    public static Coordinate[] coordinateList;
    public static ArrayList<Edge> adjList[];
    public static boolean[] check;
    public static float times[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ����� ��ǥ
        StringTokenizer st = new StringTokenizer(br.readLine());
        float x = Float.parseFloat(st.nextToken());
        float y = Float.parseFloat(st.nextToken());
        Coordinate start = new Coordinate(x, y);

        // ������ ��ǥ
        st = new StringTokenizer(br.readLine());
        x = Float.parseFloat(st.nextToken());
        y = Float.parseFloat(st.nextToken());
        Coordinate end = new Coordinate(x, y);

        int N = Integer.parseInt(br.readLine());
        coordinateList = new Coordinate[N + 2];
        check = new boolean[N + 2];
        times = new float[N + 2];
        adjList = new ArrayList[N + 2];
        for (int i = 0; i < N + 2; i++) {
            adjList[i] = new ArrayList<>();
        }

        // ���� ��ǥ��(�����, ������, ������)
        coordinateList[0] = start;
        coordinateList[N + 1] = end;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Float.parseFloat(st.nextToken());
            y = Float.parseFloat(st.nextToken());
            coordinateList[i] = new Coordinate(x, y);
        }

        // �׷��� �����
        // ������� ������ �ƴϱ� ������ ������ �޷����� ��.
        for (int i = 1; i < N + 2; i++) {
            float distance = (float) Math.sqrt(Math.pow(coordinateList[0].x - coordinateList[i].x, 2)
                    + Math.pow(coordinateList[0].y - coordinateList[i].y, 2));
            adjList[0].add(new Edge(i, (float) (distance / 5.0)));
        }

        // ���������� �޷����ų�, ������ �߻�ǰų� ���� �ɷ� ��1
        for (int i = 1; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                float distance = (float) Math.sqrt(Math.pow(coordinateList[i].x - coordinateList[j].x, 2)
                        + Math.pow(coordinateList[i].y - coordinateList[j].y, 2));
                adjList[i].add(new Edge(j, (float) Math.min(distance / 5.0, Math.abs(distance - 50) / 5.0 + 2)));
            }
        }


        dijkstra(0);

        bw.write(times[N + 1] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(times, Integer.MAX_VALUE);
        pq.add(new Edge(start, 0));
        times[start] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int destination = edge.destination;

            if (check[destination]) {
                continue;
            } else {
                check[destination] = true;
            }

            for (Edge next : adjList[destination]) {
                if (times[next.destination] >= times[destination] + next.time) {
                    times[next.destination] = times[destination] + next.time;
                    pq.add(new Edge(next.destination, times[next.destination]));
                }
            }
        }
    }
}