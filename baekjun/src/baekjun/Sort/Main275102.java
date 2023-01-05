package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//arrays.sort 사용 --> 시간초과
//arrays.sort()메서드는 퀵정렬 알고리즘을 사용한 방식으로, 평균 시간복잡도가 O(nlogn)이지만,
//최악의 시간복잡도는 O(n의 제곱)이기때문에, 문제에서 2초로 시간제한이 있어, 시간초과가 남. --> 이라고 https://st-lab.tistory.com/106 나와있지만,
//arrays.sort 사용 + stringbuilder를 하면 --> 시간초과 x

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
