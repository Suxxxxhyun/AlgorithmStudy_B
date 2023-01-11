package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//��ȣ�� ���� ����� �ڵ� (���� ����)
public class Main15652 {
	
	public static int N, M;
	public static String[] str;
	public static int[] selected;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		selected = new int[M+1];
		
		recFunc(1);
		System.out.println(sb);
	}
	
	public static void recFunc(int x) {
		if(x == M+1) {
			
			for(int i=1; i<=M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(pruning(selected[x-1],i)) {
				selected[x] = i;
				recFunc(x+1);
				selected[x] = 0;
			}
		}
	}
	
	//pruning�޼����� value = �̹� �־��� ��, i = ���� selected�� �������� �ϴ� ��
	public static boolean pruning(int value, int i) {

		if(i >= value) {
			return true;
		}
		
		return false;
	}

}
