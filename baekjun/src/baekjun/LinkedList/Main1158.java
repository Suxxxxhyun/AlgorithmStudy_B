package baekjun.LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1158 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		//�̰� ��ü��, (br.readLine, "������") �����ڸ� �����ʾҴٸ�, �׳� ���⸦ �������� ��ū�� ó����.
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(q.size() != 1) {
			for(int i=0; i < K-1; i++) {
				q.offer(q.poll());
			}
			
			sb.append(q.poll() + ", ");
		}
		
		sb.append(q.poll() + ">");
		
		bw.write(sb.toString() + "\n"); //toString�޼ҵ�� ��ü�� ���� ���� ���ڿ��� �������
		//bw.write�� Ÿ���� StringŸ������ �Ķ���͸� ����. �ٵ� stringBuilder�� char������ ����.
		//sb�� �ִ� ���� ���ڿ��� ����� ���� toString()�޼ҵ� �����.
		bw.flush(); //�����ִ� �����͸� ��� ��½�Ŵ
		bw.close(); //��Ʈ���� ����
		br.close();

	}

}
