package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//���� ������ �ִ� 10���̱⶧����, ���Ľð� 10��log10�� -> �뷫 160���� �ð����⵵ �ҿ�
//���۽ð��� ����ð��� 0�̻� 10�������̱⶧���� int������ ���� �� ����
public class Main1374 {
	
	static int n, count;
	static lecture[] lec; //�־��� ����
	static PriorityQueue<lecture> pq = new PriorityQueue<>((l1, l2) -> {
		return l1.getEnd() - l2.getEnd();
	}); //������������ ���� -> ����ð��� �������� ����
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class lecture implements Comparable<lecture>{
		private int no; //���ǹ�ȣ
		private int start; //���۽ð�
		private int end; //����ð�
		
		public lecture(int no, int start, int end) {
			this.no = no;
			this.start = start;
			this.end = end;
		}
		
		public int getNo() {
			return this.no;
		}
		
		public int getStart() {
			return this.start;
		}
		
		public int getEnd() {
			return this.end;
		}
		
		public int compareTo(lecture lec) {
			if(this.start == lec.start) {
				if(this.end == lec.end) {
					return this.no - lec.no;
				}
				return this.end - lec.end;
			}
			return this.start - lec.start;
		}

	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		count = 0; //�ʿ��� ���ǽ��� ����
		lec = new lecture[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int no = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lec[i] = new lecture(no, start, end);
		}
		
		Arrays.sort(lec);
		
		lec_count();
		System.out.println(count);
	}
	
	public static void lec_count() {
		
		pq.offer(lec[0]);
		count++;
		
		if(lec.length == 1) {
			sb.append(count);
		} else {
			for(int i=1; i<lec.length; i++) {
				
				if(!pq.isEmpty()) {
					
					lecture ing = pq.peek(); //���� �������� ����
					
					if(ing.getEnd() <= lec[i].getStart()) {
						pq.remove();
						pq.offer(lec[i]);
					} else {
						pq.offer(lec[i]);
						count++;
					}
				} 
			}
			sb.append(count);
		}
	}
	

}
