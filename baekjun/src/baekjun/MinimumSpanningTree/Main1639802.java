package baekjun.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//무방향 완전그래프의 경우, 정점이 n개일때, 간선의 개수는 n(n-2)/2이고, 
//행성의 개수가 최대 1000개이기때문에, 1000(999)/2가 되서, 시간복잡도는 대략 500000log500000이며
//1초 안에 풀수있다는 정당성을 얻을 수 있음.
//또, 무방향 완전그래에서, 최대 1000개일 경우, 모든 간선의 비용이 최대 1억이라고 가정할 경우,
//최소신장트리의 간선의 개수는 정점의 개수에서 -1한것이므로, 간선이 총 50만개까지 가능하다는 뜻이고,
//그 50만개의 간선모두 1억으로 비용이 연결되었다고 생각하면, 50만*1억이 되서
//21억보다 범위가 커지기 떄문에 비용을 int가 아닌 long으로 게산해야된다.
public class Main1639802 {
	
	public static int N;
	public static long cost;
	public static StringTokenizer st;
	public static ArrayList<E02> edges = new ArrayList<E02>();
	public static int[] parent = new int[1001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = 0;
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				edges.add(new E02(i,j,Integer.parseInt(st.nextToken())));
			}
		}
		
		Collections.sort(edges);
		
		for(int i=0; i<edges.size(); i++) {
			E02 edge = edges.get(i);
			if(find(edge.getNodeA()) != find(edge.getNodeB())){
				union(edge.getNodeA(),edge.getNodeB());
				cost += edge.getWeight();
			}
		}
		
		System.out.println(cost);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	

}

class E02 implements Comparable<E02>{
	private int nodeA;
	private int nodeB;
	private int weight;
	
	public E02(int nodeA, int nodeB, int weight) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.weight = weight;
	}
	
	public int getNodeA() {
		return this.nodeA;
	}
	
	public int getNodeB() {
		return this.nodeB;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int compareTo(E02 edge) {
		return this.weight - edge.weight;
	}
}

