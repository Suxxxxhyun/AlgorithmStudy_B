package baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1920 {
	
	static int [] arr = new int[100000]; //--> ���ϴ�ó�� �������迭�� static���� �Ҵ��ϴ� ������ε� �غ���, arraylist�ε� Ǯ���

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		Arrays.sort(arr); //collections.sort�ε� �����غ���
		
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
		
		//case1 : �߾Ӱ��� �������� �� �߾Ӱ� ��ü�� ���� ã�������ϴ� �����ΰ��
		//case2 : �߾Ӱ��� �������� �� �߾Ӱ� ��ü�� ���� ã�������ϴ� ���ں��� �������
	}


