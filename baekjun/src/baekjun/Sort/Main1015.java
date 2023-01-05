package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1015 {
	
	public static int n;
	public static int[] A, B, P;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		A = new int[n];
		B = new int[n];
		P = new int[n];
		
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			A[i] = a;
			B[i] = a;
		}
		
		Arrays.sort(B); //n�� �ִ�ġ�� 50�̱⶧����, ǥ�����Ķ��̺귯���� �ð����⵵ -> 50log50, �̹� �񳻸������� �迭B
		
		make();
		output();
	}
	
	//�迭p�� ���ҳֱ� -> 2500��ŭ�� �ð����⵵�� �ҿ��ϰԵ�
	public static void make() {
		for(int i=0; i<n; i++) { //n�� �ִ�ġ�� 50�̱⶧����, 50����ŭ for���� ���� �ɰ��̰�
			for(int j=0; j<n; j++) { 	//A�� 1��°�� �ִ� ���Ҹ� B���� ����Ž���� �Ͽ� ���� ���Ҹ� ã�ƾ���. -> �ִ� 50��ŭ �ð��� �ҿ��.
				if(A[i] == B[j]) {
					P[i] = j;
					B[j] = 0; //���� ���Ұ� 2�� �̻��ִ� ��쿡 ����ؼ� �ڵ� �ۼ�
					break;
				}
			}
		}
	}
	
	public static void output() {
		for(int i=0; i<n; i++) {
			sb.append(P[i] + " ");
		}
		System.out.println(sb);
	}

}
