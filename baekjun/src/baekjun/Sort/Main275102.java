package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//arrays.sort ��� --> �ð��ʰ�
//arrays.sort()�޼���� ������ �˰����� ����� �������, ��� �ð����⵵�� O(nlogn)������,
//�־��� �ð����⵵�� O(n�� ����)�̱⶧����, �������� 2�ʷ� �ð������� �־�, �ð��ʰ��� ��. --> �̶�� https://st-lab.tistory.com/106 ����������,
//arrays.sort ��� + stringbuilder�� �ϸ� --> �ð��ʰ� x

public class Main275102 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N];
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}

	}

}
