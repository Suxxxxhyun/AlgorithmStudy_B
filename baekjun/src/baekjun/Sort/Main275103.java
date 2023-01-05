package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//Collections.sort() 메서드는 합병정렬과 삽입정렬 모두를 섞어 만든 메서드로,
//최악의 경우에도 O(nlogn)을 보장한다.

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
