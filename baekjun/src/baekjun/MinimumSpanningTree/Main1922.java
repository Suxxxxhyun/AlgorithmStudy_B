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

//-------------------------------------------iterator�ݺ��� ���

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
		
		//iterator�ݺ��� ����� ��
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
	
	//������ ����Ʈ�� vertices�� �׷��� ������ edges�� �Ķ���ͷ� ����.
	public static ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges){
		ArrayList<Edge> mst = new ArrayList<Edge>();
		
		Edge currentEdge;
		
		//1. �ʱ�ȭ
		for(int i=0; i<vertices.size(); i++) {
			makeSet(vertices.get(i));
		}
		
		//2. ������ ����ġ ������� ����
		Collections.sort(edges);
		
		for(int i=0; i<edges.size(); i++) {
			currentEdge = edges.get(i); //������ ���� �����ͺ��� currentEdge�� ���� ��.
			if(find(currentEdge.node1) != find(currentEdge.node2)) { //�� Ư������� ��Ʈ��尡 ���� �ٸ��� = ����Ŭ�� ������ �ʴ´ٸ� -> �̶� ���Ķ�!
				Union(currentEdge.node1, currentEdge.node2);
				mst.add(currentEdge);
			}
		}
		
		return mst;
	}
	
	//�ʱ�ȭ, union-find�޼��带 ����ϱ� ����, �� ó������ n���� ���Ҹ� �������� �κ��������� ��������. ���� rank�� ��� 0!
	public static void makeSet(String node) {
		parent.put(node, node); //�������� �κ������̶��, �� ����� ��Ʈ���� �� �ڱ��ڽ��̰���!
		rank.put(node, 0);
	}
	
	//�ĸ����ͷ� ���� ����� ��Ʈ��带 ��ȯ���ִ� �޼���
	public static String find(String node) {
		//path compression��� -> �� �θ��尡 ��Ʈ��尡 �ƴ϶��, ��Ʈ��带 �ϴ� ã��, ���İ� ������ �ڽĳ��� ���� -> rank�� �����ִ� ����
		if(parent.get(node) != node) {
			parent.put(node, find(parent.get(node)));
		}
		return parent.get(node);
		
		//path compression����� ������� �ʰ�, �Ķ���ͷ� ���� ����� ��Ʈ��带 ��ȯ���ִ� �̰͸� �����Ѵٸ�,
		//if(parent.get(node) != node)
		// return find(parent.get(node));
	}
	
	//nodeV�� nodeU�� ���Ķ� ��� �޼��� = UNION
	//union�޼��带 ȣ���ϱ� ����, nodeV�� nodeU�� �����Ұ�� + ����Ŭ�� �Ȼ��涧��, union�޼��带 ȣ���ϰԵȴٰ� ������ �ϰ���!
	public static void Union(String node1, String node2) {
		String root1 = find(node1);
		String root2 = find(node2);
		
		//union-by-rank��� 
		if(rank.get(root1) > rank.get(root2)) {
			parent.put(root2, root1);
		} else { //root1�� ��ũ < root2�� ��ũ + root1�� ��ũ == root2�� ��ũ
			parent.put(root1, root2);
			if(rank.get(root1) == rank.get(root2)) { //��ũ�� ���� ������ Ȯ��
				rank.put(root2, rank.get(root2) + 1);
			}
		}
		
	}

}
