package baekjun.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//크루스칼 알고리즘
public class Main1647 {
	
	public static PriorityQueue<Edge04> graph = new PriorityQueue<Edge04>();
	public static int[] parent = new int[1000001];
	public static int result = 0;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.offer(new Edge04(a,b,weight));
		}
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		int last = 0; //이미 만들어진 최소신장트리에서, 마을을 두개로 분할할때, 가장 가중치가 큰 간선을 제거하면 두개의 마을로 쪼갤 수 있음.
		
		while(!graph.isEmpty()) {
			Edge04 edge = graph.poll();
			if(find(edge.getNode1()) != find(edge.getNode2())) {
				union(edge.getNode1(), edge.getNode2());
				result += edge.getWeight();
				last = edge.getWeight();
			}
		}
		
		System.out.println(result - last);
	}
	
	public static int find(int v) {
		if(parent[v] == v) {
			return v;
		} 
		return parent[v] = find(parent[v]);
	}
	
	public static void union(int v1, int v2) {
		v1 = parent[v1];
		v2 = parent[v2];
		if(v1 > v2) {
			parent[v1] = v2;
		} else {
			parent[v2] = v1;
		}
	}
}

class Edge04 implements Comparable<Edge04>{
	private int node1;
	private int node2;
	private int weight;
	
	public Edge04(int node1, int node2, int weight) {
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}
	
	public int getNode1() {
		return this.node1;
	}
	
	public int getNode2() {
		return this.node2;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int compareTo(Edge04 edge) {
		return this.weight - edge.weight;
	}
	
	
}
