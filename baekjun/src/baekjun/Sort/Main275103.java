package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//Collections.sort() �޼���� �պ����İ� �������� ��θ� ���� ���� �޼����,
//�־��� ��쿡�� O(nlogn)�� �����Ѵ�.

public class Main275103 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			array.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(array);
		
		for(int value : array) {
			sb.append(value);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	

}
