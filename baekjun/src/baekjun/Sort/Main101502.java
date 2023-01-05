package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main101502 {
	
	public static int n;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int[] P;
	public static Elem[] B;
	
	static class Elem implements Comparable<Elem>{
		public int num, idx;
		
		public int compareTo(Elem elem) {
			/*if(this.num != elem.num)
				return  this.num - elem.num;
			return this.idx - elem.idx; num�� ������ idx�� �������� �������� �ʿ䰡 ���� ������
			�ڹ��� ObjectŸ���� ������ tim sort�̰� tim sort - stable��
			��, �񱳺Ұ����� ��� ���ؼ� �Է¼����� ���� ���İ���� ���� ���� stable�� ���ε�,
			������ �Է��� ������ �ε����� ���� ������ �ޱ� ������ ���� ���� ��Ȳ���� �ε����� ���� ������ ���� �Ǿ�����*/
			return  this.num - elem.num;
		}

		@Override
		public String toString() {
			return "Elem [num=" + num + ", idx=" + idx + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		B = new Elem[n];
		P = new int[n];
		
		for(int i=0; i<n; i++) {
			B[i] = new Elem();
			int a = Integer.parseInt(st.nextToken());
			B[i].num = a;
			B[i].idx = i;
		}
		
		pro();
	}
	
	static void pro() {
		Arrays.sort(B);
		
		for(int i=0; i<n; i++) {
			P[B[i].idx] = i;
		}
		
		for(int i=0; i<n; i++) {
			sb.append(P[i]).append(' ');
		}
		
		System.out.println(sb);
	}

}
