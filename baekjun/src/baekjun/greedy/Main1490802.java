package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://velog.io/@pppp0722/%EB%B0%B1%EC%A4%80-%EA%B3%A8%EB%93%9C1-14908-%EA%B5%AC%EB%91%90-%EC%88%98%EC%84%A0%EA%B3%B5-Java
//�� �����ϴ�, t/s�� �����̰� �� ���� ���� ������ �۾��� �����ϰ�
//���� t/s�� ���ٸ�, ��ȣ�� ���� ��ȣ�� ������ ���� �۾��� �����ϸ� �ȴٰ� ��.
//-> �̿� ���� �������� �ٽ� ������ ��
public class Main1490802 {
	
	//n, t, s�� �ִ��� ���� 1000, 1000, 10000�̹Ƿ� int�� ������ ��Ƶ� ��.
	static int n;
	static work[] works;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		works = new work[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			works[i] = new work(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(works);
		for(int i=0; i<works.length; i++) {
			sb.append(works[i].getIdx()).append(" ");
		}
		
		System.out.println(sb);
	}

}

class work implements Comparable<work>{
	private int idx; //�۾���ȣ(�۾��� �ִ� 1000�̹Ƿ� int�������� ��Ƶ� ��.)
	private int t; //�۾���ȣ�� ���� �ϼ�
	private int s; //�۾���ȣ�� ���� �����
	
	public work(int idx, int t, int s) {
		this.idx = idx;
		this.t = t;
		this.s = s;
	}
	
	public int getIdx() {
		return this.idx;
	}
	
	public int getT() {
		return this.t;
	}
	
	public int getS() {
		return this.s;
	}
	
	@Override
	public int compareTo(work w) {
		double div1 = (double)this.t / (double)this.s;
		double div2 = (double)w.t / (double)w.s;
		
		if(div1 == div2) {
			return this.idx - w.idx;
		}
		//baekjun.Sort > Main1082502 > string�� �ʵ���ϴ� ��ü��� compareTo�� ��(�Ķ���� �Ѱ�)
		//double > compare��(�Ķ���͸� 2���� ����)
		return Double.compare(div1, div2);
	}
}
