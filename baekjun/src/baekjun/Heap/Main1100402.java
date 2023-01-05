package baekjun.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1100402 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		//Collections��Ű���� sort�޼���� �������� ����,
		//Collections��Ű���� reverse�޼��� �������� ����
		Collections.sort(list);
		//Arrays.sort�� �������� �����ε�, Arrays.sort�� �������迭������ �� �� ����
		
		for(int i=0; i<K; i++) {
			if(i == K-1) {
				System.out.println(list.get(i));	
			}
			list.get(i);
		}

	}

}
