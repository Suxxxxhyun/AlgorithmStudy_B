package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//T�� S, N�� �ִ��� ���� õ�� ��,õ�̱� ������ int������ �� �� ����
//�ϼ��� ������ϰ�, ����ݵ� ����� ��
//���� -> ó���� �ܼ��� ������� �ִ븦 �������� �����ϸ� �Ǵ� �� �˾���.
public class Main14908 {
	
	static int n, max, idx, day;
	static int[] T, S;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		T = new int[n+1];
		S = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		//���� ū ������� ã�� ���� max���� ���� -> �ִ� õ��ŭ�� �ð����⵵�� �ҿ��.
		max = 0;
		for(int i=1; i<=n; i++) {
			if(max < S[i]) {
				max = S[i];
				idx = i;
			}
		}
		
		min_money();
		
	}
	
	public static void min_money() {
		
		day = T[idx];
		
		
	}

}
