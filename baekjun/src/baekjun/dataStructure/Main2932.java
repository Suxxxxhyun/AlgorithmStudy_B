package baekjun.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//ǥ�� ũ���� N�� �ִ� �����̰�, �̵���Ű�����ϴ� ������ K�� �ִ� õ���� �־���
//���� ���������� 2�����迭�� Ǭ�ٶ�� ����������, ���ڸ� 1���� 1����� N�� ���� ǥ�� �־�ߵɻӴ���, �̵���Ű���ϴ� ���ڰ� õ�̶�� 1���� ���� �ʰ��ϰ� �ǹǷ�
//2�����迭�δ� �ð����⵵�� �Ѱ谡 �ְԵ�.
//�׷��� �켱����ť�� �ѹ� �����غ��� ����� ������ ��.
public class Main2932 {
	
	public static int N, K, X, R, C, count;
	public static StringTokenizer st;
	public static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	
	public static void move() {
		
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			X = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken()); 
			C = Integer.parseInt(st.nextToken());
			count = 0;
			
			
			move();
		}
	}

}
