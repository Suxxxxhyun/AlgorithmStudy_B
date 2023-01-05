package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//퀵정렬 이용 --> 시간초과 
//페켐의 퀵정렬에 대한 최악의 시간복잡도는 O(n제곱)

public class Main2751 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			array.add(Integer.parseInt(br.readLine()));
		}
		
		for(int value : sort(array)) {
			sb.append(value);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	 static ArrayList<Integer> sort(ArrayList<Integer> dataList){
		if(dataList.size() <= 1) {
			return dataList;
		} else {
			int pivot = dataList.get(0);
			
			ArrayList<Integer> leftarr = new ArrayList<Integer>();
			ArrayList<Integer> rightarr = new ArrayList<Integer>();
			
			for(int index=1; index<dataList.size(); index++) {
				if(pivot > dataList.get(index)) {
					leftarr.add(dataList.get(index));
				} else {
					rightarr.add(dataList.get(index));
				}
			}
			
			ArrayList<Integer> mergedarr = new ArrayList<Integer>();
			mergedarr.addAll(sort(leftarr));
			mergedarr.addAll(Arrays.asList(pivot));
			mergedarr.addAll(sort(rightarr));
			
			return mergedarr;
		}
		
	}

}
