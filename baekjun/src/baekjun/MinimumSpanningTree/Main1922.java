package baekjun.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Edge implements Comparable<Edge>{
	public String node1;
	public String node2;
	public int weight;
	
	public Edge(String node1,String node2,int weight) {
		this.weight = weight;
		this.node1 = node1;
		this.node2 = node2;
	}
	
	public int compareTo(Edge edge) {
		return this.weight - edge.weight;
	}
	
	public String toString() {
		return "(" + this.node1 + "," + this.node2 + "," + this.weight + ")";
	}
}

//-------------------------------------------iterator반복자 사용

public class Main1922 {
	
	public static HashMap<String,String> parent = new HashMap<String,String>();
	public static HashMap<String,Integer> rank = new HashMap<String,Integer>();
	public static ArrayList<Edge> graph = new ArrayList<Edge>();
	public static ArrayList<String> vertices = new ArrayList<String>();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		Set<String> node = new HashSet<String>();
		
		for(int i=0; i<M; i++) {
			String[] st = br.readLine().split(" ");
			String a = st[0];
			String b = st[1];
			int c = Integer.parseInt(st[2]);
			graph.add(new Edge(a,b,c));
			node.add(a);
			node.add(b);
		}
		
		//iterator반복자 사용한 곳
		Iterator<String> iterator = node.iterator();
		while(iterator.hasNext()) {
			vertices.add(iterator.next());
		}
		
		ArrayList<Edge> result = kruskalFunc(vertices, graph);
		
		int sumweight = 0;
		
		for(int i=0; i<result.size(); i++) {
			sumweight += result.get(i).weight;
		}
		
		System.out.println(sumweight);
		
	}
	
	//노드들의 리스트인 vertices와 그래프 정보인 edges를 파라미터로 받음.
	public static ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges){
		ArrayList<Edge> mst = new ArrayList<Edge>();
		
		Edge currentEdge;
		
		//1. 초기화
		for(int i=0; i<vertices.size(); i++) {
			makeSet(vertices.get(i));
		}
		
		//2. 간선의 가중치 기반으로 정렬
		Collections.sort(edges);
		
		for(int i=0; i<edges.size(); i++) {
			currentEdge = edges.get(i); //간선이 가장 작은것부터 currentEdge에 담기게 됨.
			if(find(currentEdge.node1) != find(currentEdge.node2)) { //두 특정노드의 루트노드가 서로 다르다 = 사이클이 생기지 않는다면 -> 이때 합쳐라!
				Union(currentEdge.node1, currentEdge.node2);
				mst.add(currentEdge);
			}
		}
		
		return mst;
	}
	
	//초기화, union-find메서드를 사용하기 위해, 맨 처음에는 n개의 원소를 개별적인 부분집합으로 만들어야함. 또한 rank는 모두 0!
	public static void makeSet(String node) {
		parent.put(node, node); //개별적인 부분집합이라면, 각 노드의 루트노드는 곧 자기자신이겠지!
		rank.put(node, 0);
	}
	
	//파리미터로 받은 노드의 루트노드를 반환해주는 메서드
	public static String find(String node) {
		//path compression기법 -> 내 부모노드가 루트노드가 아니라면, 루트노드를 일단 찾고, 거쳐간 노드들을 자식노드로 만듬 -> rank를 낮춰주는 역할
		if(parent.get(node) != node) {
			parent.put(node, find(parent.get(node)));
		}
		return parent.get(node);
		
		//path compression기법을 사용하지 않고, 파라미터로 받은 노드의 루트노드를 반환해주는 이것만 생각한다면,
		//if(parent.get(node) != node)
		// return find(parent.get(node));
	}
	
	//nodeV와 nodeU를 합쳐라 라는 메서드 = UNION
	//union메서드를 호출하기 전에, nodeV와 nodeU를 연결할경우 + 사이클이 안생길때만, union메서드를 호출하게된다고 전제를 하겠음!
	public static void Union(String node1, String node2) {
		String root1 = find(node1);
		String root2 = find(node2);
		
		//union-by-rank기법 
		if(rank.get(root1) > rank.get(root2)) {
			parent.put(root2, root1);
		} else { //root1의 랭크 < root2의 랭크 + root1의 랭크 == root2의 랭크
			parent.put(root1, root2);
			if(rank.get(root1) == rank.get(root2)) { //랭크가 서로 같은지 확인
				rank.put(root2, rank.get(root2) + 1);
			}
		}
		
	}

}
