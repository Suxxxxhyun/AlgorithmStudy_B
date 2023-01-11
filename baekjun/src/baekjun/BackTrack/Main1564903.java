package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1564903 {

	public static String str[];
	public static int N, M;
	public static int[] selected, used;
	//used[5] = 1이라면 5는 사용된 적이 있다.
	//used[4] = 0이라면 4는 사용된 적이 없다.
	public static StringBuilder sb = new StringBuilder();
	
	public static void recFunc(int k) {
		if(k == M + 1) {
			for(int i=1; i<=M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append('\n');
		} else {
			for(int cand = 1; cand <= N; cand++) {
				if(used[cand] == 1) { //사용된 적이 있다.
					continue;
				}
				selected[k] = cand;
				used[cand] = 1;
				recFunc(k+1);
				selected[k] = 0;
				used[cand] = 0; //->이 부분이 실수 많이하는 부분이라고 했음
			}
		}
	}

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

}
