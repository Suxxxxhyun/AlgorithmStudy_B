package baekjun.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

//크루스칼 방식도 풀 수 있고 -> 프림 하고 바로 시도해볼것 (어제 한 서로소집합으로 풀어볼것)
//프림알고리즘 방식으로도 풀 수 있음

//1. 프림알고리즘으로 접근한 방식
public class Main1197 {
	
	public static HashMap<Integer, HashMap<Integer,Integer>> graph = new HashMap<Integer, HashMap<Integer,Integer>> (); //ex) 1이라는 노드에서, 2라는 노드와 연결되어있고 그에 따른 가중치 1
	public static HashMap<Integer,Integer> graphValue; //ex) 2라는 노드와 연결되어있고 그에 따른 가중치 1

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		
		int V = Integer.parseInt(str1[0]);
		int E = Integer.parseInt(str1[1]);
		int startNode = 0;
		
		for(int i=0; i<E; i++) {
			String[] str2 = br.readLine().split(" ");
			graphValue = new HashMap<Integer,Integer>();
			if(graph.containsKey(Integer.parseInt(str2[0]))) {
				graphValue.put(Integer.parseInt(str2[0]), Integer.parseInt(str2[2]));
				graph.put(Integer.parseInt(str2[1]), graphValue);
				continue;
			}
			graphValue.put(Integer.parseInt(str2[1]), Integer.parseInt(str2[2]));
			graph.put(Integer.parseInt(str2[0]), graphValue);
			if(i == 0) {
				startNode = Integer.parseInt(str2[0]); //시작정점
			}
		}
		
		long value = primAlgorithm(graph,startNode);
		System.out.println(value);
	}
	
	public static long primAlgorithm(HashMap<Integer, HashMap<Integer,Integer>> graph, Integer startNode) {
		PriorityQueue<Edge02> pq = new PriorityQueue<Edge02>();
		HashMap<Integer,Integer> mstPath = new HashMap<Integer,Integer>(); //ex) 1이라는 노드와 1이라는 노드가 연결되어있다. 가중치 0으로
		HashMap<Integer, Edge02> keyObjects = new HashMap<Integer, Edge02>();
		ArrayList<Path> mst = new ArrayList<Path>(); //최소신장트리
		Edge02 edgeObejct, poppedEdge,linkedEdge;
		long totalWeight = 0;
		HashMap<Integer,Integer> linkedEdges; //인접간선정보
		
		for(Integer graphKey : graph.keySet()) {
			if(startNode == graphKey) {
				edgeObejct = new Edge02(graphKey,0); //(1이라는 노드, 자기자신의 가중치 - 0) -> 우선순위큐에 넣을것임
				mstPath.put(graphKey, graphKey);
			} else {
				edgeObejct = new Edge02(graphKey,Integer.MAX_VALUE);
				mstPath.put(graphKey, null);
			}
			pq.offer(edgeObejct);
			keyObjects.put(graphKey, edgeObejct);
		}
		
		while(pq.size() > 0) {
			poppedEdge = pq.poll();
			keyObjects.remove(poppedEdge.node1);
			
			mst.add(new Path(mstPath.get(poppedEdge.node1), poppedEdge.node1, poppedEdge.weight));
			totalWeight += poppedEdge.weight;
			
			linkedEdges = graph.get(poppedEdge.node1);
			for(Integer adjacent : linkedEdges.keySet()) {
				if(keyObjects.containsKey(adjacent)) {
					linkedEdge = keyObjects.get(adjacent);
					
					if(linkedEdges.get(adjacent) <= linkedEdge.weight) {
						linkedEdge.weight = linkedEdges.get(adjacent);
						mstPath.put(adjacent, poppedEdge.node1);
						pq.remove(linkedEdge);
						pq.offer(linkedEdge);
					}
				}
			}
		}
		
		return totalWeight;
		
	}

}

class Path{
	public Integer node1;
	public Integer node2;
	public Integer weight;
	
	public Path(Integer node1,Integer node2,Integer weight) {
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}
	
	public String toString() {
		return "(" + this.node1 + this.node2 + this.weight + ")";
	}
}

class Edge02 implements Comparable<Edge02>{
	public Integer node1;
	public Integer weight;
	
	public Edge02(Integer node1,Integer weight) {
		this.node1 = node1;
		this.weight = weight;
	}
	
	public int compareTo(Edge02 edge) {
		return this.weight - edge.weight;
	}
	
	public String toString() {
		return "(" + this.node1 + this.weight + ")";
	}
}
