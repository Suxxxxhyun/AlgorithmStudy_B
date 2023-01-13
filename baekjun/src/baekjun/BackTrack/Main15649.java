package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//실패 --> 1564902에서 확인가능
public class Main15649 {
	
	public static String str[];
	public static int N, M;
	public static int[] selected;
	public static StringBuilder sb = new StringBuilder();
	
	public static void recFunc(int n, int idx) {
		if(idx == M + 1) {
			for(int i=1; i<=M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append('\n');
		} else {
			for(int cand = n; cand <= N; cand++) {
				selected[idx] = cand;
				recFunc(n+1,idx+1);
				selected[idx] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		selected = new int[M+1];
		
		recFunc(1,1);
		System.out.println(sb);
	}

}
