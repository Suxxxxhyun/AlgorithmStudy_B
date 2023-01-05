package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main23970 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		ArrayList<Integer> list2 = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			list2.add(Integer.parseInt(st.nextToken()));
		}
		
		int count = 0;
		boolean swap = false;
		
		if(check(list, list2)) {
			count = 1;
			System.out.println(count);
			return;
		} else {
			for(int i=0; i<list.size()-1; i++) {
				for(int j=0; j<list.size()-1-i; j++) {
						
					if(list.get(j) > list.get(j+1)) {
						//Collections.swap(list, j, j+1);
						int temp = list.get(j+1);
						list.set(j+1, list.get(j));
						list.set(j, temp);
						swap = true;
						if((list.get(j).equals(list2.get(j))) && (list.get(j+1).equals(list2.get(j+1))) ) {
							if(check(list, list2)) {
								count = 1;
								break;
							}
						}
					}
				}
			}
				
			System.out.print(count);
		}
		
	}

	
	public static boolean check(ArrayList<Integer> dataList1, ArrayList<Integer> dataList2) {
		return dataList1.equals(dataList2);
	}

}
