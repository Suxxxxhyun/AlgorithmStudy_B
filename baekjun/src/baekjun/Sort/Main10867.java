package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

//Arrays.sort - �迭�� ������ ��쿡 ���, �ð����⵵ -> �־��� ��� n�� ����
//Collections.sort - �÷����� ������ ��쿡 ���, �ð����⵵ -> �־��� ��� nlogn
public class Main10867 {
	
	public static int N;
	public static StringTokenizer st;
	public static Set<Integer> nums = new HashSet<Integer>();
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		Iterator<Integer> iterator = nums.iterator();
		while(iterator.hasNext()) {
			list.add(iterator.next());
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
	}

}
