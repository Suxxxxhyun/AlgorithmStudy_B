package baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main192002 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		Collections.sort(arr);
		
		for(int i=0; i<M; i++) {
			
		}

	}
	
	/*public static int BinarySearch(ArrayList<Integer> list) {
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		
		int index = list.size() / 2;
		
	}*/

}
