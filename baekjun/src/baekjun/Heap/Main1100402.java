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
		
		//Collections패키지의 sort메서드는 오름차순 정렬,
		//Collections패키지의 reverse메서드 내림차순 정렬
		Collections.sort(list);
		//Arrays.sort도 오름차순 정렬인데, Arrays.sort는 일차원배열에서만 쓸 수 있음
		
		for(int i=0; i<K; i++) {
			if(i == K-1) {
				System.out.println(list.get(i));	
			}
			list.get(i);
		}

	}

}
