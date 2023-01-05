package baekjun.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//�׷��� ��ü�� ���ʿ� �������ϴµ�, ��� ���������� �� ������. --> ���� �ذ� ����

public class Main10473 {
	
	public static final int INF = Integer.MAX_VALUE;
	public static ArrayList<Depo> depo = new ArrayList<Depo>(); //��ǥ�� ������ �Ͽ� ��� ������ ��� ����
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); 
	public static double []table = new double[101]; //�Ÿ�����迭

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		
		double meX = Double.parseDouble(str1[0]); //25.0�� double�� �ٲ��ִ� �޼��� -> Double.parsedouble
		double meY = Double.parseDouble(str1[1]);
		
		String[] str2 = br.readLine().split(" ");
		double endX = Double.parseDouble(str2[0]);
		double endY = Double.parseDouble(str2[1]);
		
		depo.add(new Depo(meX, meY));
		
		int n = Integer.parseInt(br.readLine()); //��������
		for(int i=0; i<n; i++) {
			String[] str3 = br.readLine().split(" ");
			double depoX = Double.parseDouble(str3[0]);
			double depoY = Double.parseDouble(str3[1]);
			depo.add(new Depo(depoX, depoY));
		}
		
		depo.add(new Depo(endX, endY));
		
		Arrays.fill(table, INF);
		
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		System.out.println(depo);
		
		dijkstra(meX, meY, endX, endY, 0);
	}
	
	//selfdistance : ���� ���ڽ��� �Ÿ� = 0
	public static void dijkstra(double meX, double meY, double endX, double endY, int selfdistance) {
		
		table[0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(); //�켱����ť
		pq.offer(new Node(0,0));
		int currentidx;
		
		//���κ���, �� ���������� �Ÿ����� graph.get(0)�� ����
		for(int i=1; i<=depo.size()-2; i++) {
			double dX = Math.pow(meX - depo.get(i).getX(), 2);
			double dY = Math.pow(meY - depo.get(i).getY(), 2);
			graph.get(0).add(new Node(i,Math.sqrt(dX + dY)));
		}
		
		for(int i=0; i<graph.get(0).size(); i++) {
			System.out.print(graph.get(0).get(i) + " ");
		}
		
		System.out.println();
		
		//�׷����� ���� �߽����� �� ���������� �Ÿ� �Ӹ� �ƴ϶�, ������ ���������� ���� ���� �־���� �׷��� ������ �ϼ���.
		/*for(int i=0; i<depo.size(); i++) {
			double dX = Math.pow(depo.get(i).getX(), i);
		}*/
		
		int count = 0;
		while(true) {
			count++;
			if(count == 2) {
				break;
			}
			Node node = pq.poll(); 
			int nodeIndex = node.getIndex(); //0
			double nodeDistance = node.getDistance();//0
			
			for(int i=0; i<graph.get(nodeIndex).size(); i++) {
				if(table[graph.get(nodeIndex).get(i).getIndex()] > graph.get(nodeIndex).get(i).getDistance()) {
					table[graph.get(nodeIndex).get(i).getIndex()] = graph.get(nodeIndex).get(i).getDistance();
					double addWeight = nodeDistance + graph.get(nodeIndex).get(i).getDistance();
					pq.offer(new Node(graph.get(nodeIndex).get(i).getIndex(), addWeight));
					currentidx = pq.peek().getIndex();
				}
			}
		}
		
		
		
		System.out.println(pq);
		
		for(int i=0; i<8; i++) {
			System.out.println(table[i]);
		}
	}

}


class Depo {
	private double x;
	private double y;
	
	public Depo(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

class Node implements Comparable<Node>{
	private int index;
	private double distance;
	
	public Node(int index, double distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public int compareTo(Node node) {
		return (int) (this.distance - node.distance);
	}
	
	public String toString() {
		return "(index : " + index + ", distance: " + distance + ")";
	}
}
