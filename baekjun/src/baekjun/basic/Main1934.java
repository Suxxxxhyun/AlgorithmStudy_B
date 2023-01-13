package baekjun.src.baekjun.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//arraylist패키지 이용
import java.util.ArrayList;

public class Main1934 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			int common = 0;
			int a = 0;
			int b = 0;
			int list11 = 0;
			int list22 = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			ArrayList<Integer> list1 = new ArrayList<Integer>();
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			ArrayList<Integer> commonfactor = new ArrayList<Integer>();
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<=A; j++) {
				if(A % j == 0) {
					list1.add(j);
				}
			}
			
			for(int l=1; l<=B; l++) {
				if(B % l == 0) {
					list2.add(l);
				}
			}
			
			list11 = list1.size();
			list22 = list2.size();
			
			if(list11 <= list22) {
				for(int k=0; k<list11; k++) {
					for(int m = 0; m<list22; m++) {
						if(list2.get(m).equals(list1.get(k))) {
							commonfactor.add(list1.get(k));
						}
					}
				}
			} else {
				for(int k=0; k<list22; k++) {
					for(int m = 0; m<list11; m++) {
						if(list2.get(k).equals(list1.get(m))) {
							commonfactor.add(list1.get(m));
						}
					}
				}
			}
			
			if(commonfactor.size() <= 1) {
				common = 1;
			} else {
				common = commonfactor.get(commonfactor.size() - 1); // 최대공약수
			}
			
			a = A / common;
			b = B / common;
			sb.append(common * a * b);
			sb.append('\n');
			
		}
		System.out.println(sb);
		
	}

}
