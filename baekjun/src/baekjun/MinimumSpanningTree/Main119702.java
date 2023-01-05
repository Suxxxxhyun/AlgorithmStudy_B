package baekjun.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//크루스칼알고리즘으로 구현함
public class Main119702 {
	
	public static PriorityQueue<Edge03> graph = new PriorityQueue<Edge03>();
	public static int[] parent;
	public static int V,E;
	public static int result = 0;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		V = Integer.parseInt(str1[0]);
		E = Integer.parseInt(str1[1]);
		
		parent = new int[V+1];
		
		for(int i=0; i<E; i++) {
			String[] str2 = br.readLine().split(" ");
			graph.add(new Edge03(Integer.parseInt(str2[0]),Integer.parseInt(str2[1]),Integer.parseInt(str2[2])));
		}
		
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		while(graph.size() > 0) {
			Edge03 edge = graph.poll();
			if(find(edge.getNode1()) != find(edge.getNode2())) {
				union(edge.getNode1(), edge.getNode2());
				result += edge.getWeight();
			}
		}
		
		System.out.println(result);
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
		
		if(v1 < v2) {
			parent[v2] = v1;
		} else {
			parent[v1] = v2;
		}
	}
	
	
}

class Edge03 implements Comparable<Edge03>{
	private int weight;
	private int node1;
	private int node2;
	
	public Edge03(int node1, int node2, int weight) {
		this.weight = weight;
		this.node1 = node1;
		this.node2 = node2;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getNode1() {
		return this.node1;
	}
	
	public int getNode2() {
		return this.node2;
	}
	
	public int compareTo(Edge03 edge) {
		return this.weight - edge.weight;
	}
	
	public String toString() {
		return "(" + this.weight + "," + this.node1 + "," + this.node2 + ")";
	}
}
