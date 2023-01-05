package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2501 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(N % i == 0) {
				arr.add(i);
			}
		}
		
		//���� ���̽����� ���� �� ��������! // 1 5 25�ΰ��!
		if(arr.size() >= K) {
			System.out.println(arr.get(K-1));
		} else {
			System.out.println(0);
		}
		
	}

}
