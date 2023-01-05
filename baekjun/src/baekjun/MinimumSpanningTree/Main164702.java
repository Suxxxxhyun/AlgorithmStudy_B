package baekjun.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//크루스칼 알고리즘에서 그래프 구현시, 우선순위큐를 이용하지않고 ArrayList를 이용한 경우
public class Main164702 {
	
	public static ArrayList<Edge05> graph = new ArrayList<Edge05>();
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
			graph.add(new Edge05(a,b,weight));
		}
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		Collections.sort(graph);
		
		int last = 0; //이미 만들어진 최소신장트리에서, 마을을 두개로 분할할때, 가장 가중치가 큰 간선을 제거하면 두개의 마을로 쪼갤 수 있음.
		
		
		for(int i=0; i<graph.size(); i++) {
			Edge05 edge = graph.get(i);
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

class Edge05 implements Comparable<Edge05>{
	private int node1;
	private int node2;
	private int weight;
	
	public Edge05(int node1, int node2, int weight) {
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
	
	public int compareTo(Edge05 edge) {
		return this.weight - edge.weight;
	}
	
	
}
