package baekjun.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라 구현 코드를 참조해서 graph자체를 2차원 배열로 만들어서 접근, 그리고 백준2178문제를 참고해서
//2차원배열 상에서 상하좌우로 이동할 수 있게 구현함.

public class Main4485 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		int n = 1;
		
		StringBuilder sb = new StringBuilder();
		
		while((str = br.readLine()) != null) {
			
			int N = Integer.parseInt(str);
			
			if(N == 0) {
				break;
			}
			
			int[][] graph = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				while(st.hasMoreTokens()){
					for(int j=0; j<graph[i].length; j++) {
						graph[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}
			
			int result = DijkstraFunc(graph, graph[0][0]);
			
			sb.append("Problem " + n + ": " + result);
			sb.append('\n');
			n++;
			//System.out.println(sb);
		}
		System.out.println(sb);
	}
	
	public static int DijkstraFunc(int[][] graph, int start) {
		
		NodeAndPair node;
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int weight, distance; //가중치
		
		//거리저장배열
		int[][] distances = new int[graph.length][graph.length];
		
		for(int i=0; i<distances.length; i++) {
			for(int j=0; j<distances[i].length; j++) {
				distances[i][j] = Integer.MAX_VALUE;
			}
		}
		
		distances[0][0] = start;
		
		PriorityQueue<NodeAndPair> priorityqueue = new PriorityQueue<>();
		priorityqueue.add(new NodeAndPair(start, 0, 0));
		
		while(priorityqueue.size() > 0) {
			node = priorityqueue.poll();
			weight = node.vertex;
			
			for(int i=0; i<4; i++) {
				int nX = node.x + dx[i]; //1
				int nY = node.y + dy[i]; //0
				
				if(nX < 0 || nX >= graph.length || nY < 0 || nY >= graph.length) {
					continue;
				}
				
				if(weight > distances[nY][nX]) {
					continue;
				}
				
				distance = graph[nY][nX] + weight;
				
				if(distances[nY][nX] > distance) {
					distances[nY][nX] = graph[nY][nX] + weight; //
					priorityqueue.add(new NodeAndPair(distances[nY][nX],nX,nY));
				}
			}
		}
		
		return distances[graph.length-1][graph.length-1];
	}
	
	public static class NodeAndPair implements Comparable<NodeAndPair>{
		int vertex;
		int x;
		int y;
		
		NodeAndPair(int vertex, int x, int y){
			this.vertex = vertex;
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(NodeAndPair nodeAndpair) {
			return this.vertex - nodeAndpair.vertex;
		}
	}

}
