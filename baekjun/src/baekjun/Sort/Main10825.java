package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//���1. �л��� ���� �ִ� �ʸ�, ��������� ����Ѵٸ�, 
//����, ����, ������ ��Ÿ���� �迭�� �ε��� ������ 1���� 100���� -> ��������� ����ϸ� �ð����⵵ O(100 + 100)
//�̸����� ��쿡��, �迭�� �ε��� ������ 1���� �ʸ����� -> �ð��� ������ ���� �������⵵�� �ʹ� ũ�ϱ�
//�̸����� ��쿡�� Ŭ������ ����� comparable�� �������. -> ��� ������ ���� ���, �������� �̸��� ���ؼ� ������ �ϴµ�, �̸� ��ü�� ���� �� ������ �ǹ����ϱ�
//�ð����⵵�� ������ �Ͱ��Ƽ� �׳� ���2�� ������ ����.
//���2. ��ü�� �ʵ带 ����,����,����,�̸� ���� Comparable�������̽� ��ӹ޾� �����ϴ� Ŭ�����ϳ���������������?
//-> ����

//��� ������ 1�̻� 100�����̱⶧���� int������ ����ص���
//n�� �ִ�ġ�� 10�� -> 10*log10�� �̹Ƿ� -> �뷫160��
//1�ʾȿ� ����� ��������
public class Main10825 {
	
	public static int N;
	public static StringTokenizer st;
	public static PriorityQueue<student01> pq = new PriorityQueue<student01>();
	//ArrayListŸ������ ���� Collections.sort�ϴ� �͵� �ϳ��� ����ϵ�!
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		while(N > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new student01(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			N--;
		}
		
		while(!pq.isEmpty()) {
			student01 stu = pq.poll();
			sb.append(stu.getName()).append('\n');
		}
		
		System.out.println(sb);
		
		
		
	}

}

class student01 implements Comparable<student01>{
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public student01(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int compareTo(student01 stu) {
		
		if(stu.kor == this.kor) {
			if(stu.eng == this.eng) {
				if(stu.math == this.math) {
					return this.name.compareTo(stu.name);
				}
				return stu.math - this.math;
			}
			return this.eng - stu.eng;
		}
		return stu.kor - this.kor;
	}
}
