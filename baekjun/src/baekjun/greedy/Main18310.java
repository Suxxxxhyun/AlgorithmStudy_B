package baekjun.src.baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main18310 {

	static int n; //집의 개수
	static int[] houses; //집의 위치를 담는 배열
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		houses = new int[n];
		
		for(int i=0; i<n; i++) {
			houses[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(houses);
		
		int mod = houses.length % 2;
		int mid = houses.length / 2;
		if(mod == 0) {
			System.out.println(houses[mid-1]);
		} else {
			System.out.println(houses[mid]);
		}
	}

}
