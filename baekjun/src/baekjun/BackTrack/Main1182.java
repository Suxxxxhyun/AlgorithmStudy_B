package baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://we1cometomeanings.tistory.com/266
//부분 수열 - 부분 집합

public class Main1182 {
	
	public static int N, S;
	public static int[] arr;
	public static int count = 0;
	
	public static void backTracDfs(int depth, int sum) {
		
		if(depth == N) {
			System.out.println("[" + depth + "," + sum + "]");
			return;
		} 
		
		System.out.println(depth + "," + sum);
		if((arr[depth] + sum) == S) {
			count++;
		}
		
		backTracDfs(depth+1, sum);
		backTracDfs(depth+1, sum + arr[depth]);
		
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str1 = br.readLine().split(" ");
		N = Integer.parseInt(str1[0]);
		S = Integer.parseInt(str1[1]);
		arr = new int[N];
		
		String[] str2 = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str2[i]);
		}
		
		backTracDfs(0,0);
		System.out.println(count);
	}

}
