package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*  1 <= cand = N
	cand = 1
	selected[1] = 1
	recf(2)
		1 <= cand = N
		cand = 1
		selected[2] = 1

		cand = 2
		selected[2] = 2
		
		cand = 3
		selected[2] = 3
		recf(3)
		selected[2] = 0
		
	selected[1] = 0

selected
1 3

sb
1 1
1 2
1 3 
 * @author qkrtn
 *
 */

public class Main1565102 {
	
	public static int N, M;
	public static int[] selected; //�̋������� ����� �ִ� �迭
	public static String[] str;
	public static StringBuilder sb = new StringBuilder();
	
	public static void recFunc(int k) {
		//�� �� ���
		if(k == M + 1) {
			for(int i=1; i<=M; i++) {
				//sb.append(selected[i] + " ");
				//sb.append('\n');
				System.out.print(selected[i] + " ");
			}
			System.out.println();
		} else { //���� �� ���� ���� ���
			for(int cand = 1; cand <= N; cand++) {
				selected[k] = cand;
				recFunc(k+1);
				selected[k] = 0;
				//�� ����Լ��� �� ���ƴٸ� k��° ���ҿ� ���� ����� ������ ������ ���⋚���� �Ƿʻ�
				//0���� ä����.
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		selected = new int[M+1];
		
		recFunc(1);
	}

}
