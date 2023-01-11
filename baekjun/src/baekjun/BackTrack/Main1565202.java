package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1565202 {
	
	public static int N, M;
	public static String[] str;
	public static int[] selected;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		selected = new int[M+1];
		
		recFunc(1);
		System.out.println(sb);

	}
	
	public static void recFunc(int x) {
		if(x == M+1) {
			
			for(int i=1; i<=M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		int start = selected[x-1];
		if(start == 0) {
			start = 1;
		} //자연수 1부터 생각해주니까 start=0인것을 1로 바꿔줌
		
		//숫자의 시작값이 바뀜
		for(int i=start; i<=N; i++) {
			selected[x] = i;
			recFunc(x+1);
			selected[x] = 0;
		}
	}

}
