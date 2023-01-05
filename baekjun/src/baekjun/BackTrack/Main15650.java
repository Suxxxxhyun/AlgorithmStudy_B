package baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//강의보기전 구현 성공
public class Main15650 {
	
	public static int N,M;
	public static String[] str;
	public static int[] selected, used;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		selected = new int[M+1];
		used = new int[N+1];
		
		recFunc(1);
		System.out.println(sb);
	}
	
	public static void recFunc(int x) {
		if(x == M + 1) {
			for(int i=1; i<=M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		int start = selected[x-1];
		if(start == 0) {
			start = 1;
		}
		
		for(int i = start; i<=N; i++) {
			if(used[i] == 0) {
				selected[x] = i;
				used[i] = 1;
				recFunc(x+1);
				used[i] = 0;
			}
		}
	}

}
