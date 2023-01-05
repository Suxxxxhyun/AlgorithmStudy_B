package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//병합정렬이용 --> 통과 

public class Main275104 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			array.add(Integer.parseInt(br.readLine()));
		}
		
		for(int value : split(array)) {
			sb.append(value).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static ArrayList<Integer> split(ArrayList<Integer> dataList) {
		if(dataList.size() <= 1) {
			return dataList;
		}
		
		int medium = dataList.size() / 2;
		
		ArrayList<Integer> leftarr = split(new ArrayList<Integer>(dataList.subList(0, medium)));
		ArrayList<Integer> rightarr = split(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));
		
		return merge(leftarr, rightarr);
		
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> leftarr, ArrayList<Integer> rightarr){
		ArrayList<Integer> mergearr = new ArrayList<Integer>();
		
		int leftPoint = 0;
		int rightPoint = 0;
		
		while(leftarr.size() > leftPoint && rightarr.size() > rightPoint) {
			if(leftarr.get(leftPoint) < rightarr.get(rightPoint)) {
				mergearr.add(leftarr.get(leftPoint));
				leftPoint += 1;
			} else {
				mergearr.add(rightarr.get(rightPoint));
				rightPoint += 1;
			}
		}
		
		while(leftarr.size() > leftPoint) {
			mergearr.add(leftarr.get(leftPoint));
			leftPoint += 1;
		}
		
		while(rightarr.size() > rightPoint) {
			mergearr.add(rightarr.get(rightPoint));
			rightPoint += 1;
		}
		
		return mergearr;
	}

}
