package baekjun.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//표의 크기인 N이 최대 만개이고, 이동시키려고하는 숫자인 K가 최대 천으로 주어짐
//만일 직관적으로 2차원배열로 푼다라고 접근했을때, 숫자를 1부터 1억까지 N의 만인 표에 넣어야될뿐더러, 이동시키려하는 숫자가 천이라면 1억을 한참 초과하게 되므로
//2차원배열로는 시간복잡도의 한계가 있게됨.
//그래서 우선순위큐로 한번 접근해보면 어떨까라는 생각을 함.
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
