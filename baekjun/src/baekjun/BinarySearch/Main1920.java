package baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1920 {
	
	static int [] arr = new int[100000]; //--> 지완님처럼 일차원배열을 static으로 할당하는 방식으로도 해보고, arraylist로도 풀어볼것

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		Arrays.sort(arr); //collections.sort로도 접근해볼것
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			//BinarySearch(arr, 0, arr.length-1, Integer.parseInt(st2.nextToken()));
		}
	}
	
	/*public static int BinarySearch(int[] arr, int left, int right, int st2Number) {
		int medium = arr.length / 2;
		
		if(arr[medium] == st2Number) {
			return 1;
		} else if(arr[medium] > st2Number) {
			BinarySearch(arr, )
		} else if(arr[medium] < st2Number) {
			return 
		}*/
		
		//case1 : 중앙값을 구했을때 그 중앙값 자체가 내가 찾으려고하는 숫자인경우
		//case2 : 중앙값을 구했을때 그 중앙값 자체가 내가 찾으려고하는 숫자보다 작은경우
	}


