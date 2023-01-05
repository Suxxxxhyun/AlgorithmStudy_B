package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//������ S�� �ּڰ��� ����ϸ� �Ǵϱ�
//B�� �迭���°� ������ ���� ���� �ʾƵ� �������
//-> B�� ������������ �� ���̰�, A�� ������������ �����Ѵٸ�
//0��°���� B�� ����ū���� A�� ���� ���� ���� ���� �� ����
//�ð����⵵�� �����Ҷ��� ǥ�����Ķ��̺귯���� nlogn�� �ð����⵵�� ���߹Ƿ�
//n�� �ִ��� 50�̱⶧���� 50log50*2 + 50(�ִ� 50���� ���ؼ� A�� B�� ���� ��������ϳ���)
//2�� �ȿ� Ǯ �������Ƿ� ������ ��ġ������
public class Main1026 {
	
	public static int n, S;
	public static Integer[] A,B;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new Integer[n];
		B = new Integer[n];
		S = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Sort();
		result();
	}
	
	//A�� ������������ B�� ������������ �����ϴ� �޼ҵ�
	public static void Sort() {
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
	}
	
	//S�� ���ϱ�
	public static void result() {
		for(int i=0; i<n; i++) {
			S += A[i] * B[i];
		}
		
		System.out.println(S);
	}

}
