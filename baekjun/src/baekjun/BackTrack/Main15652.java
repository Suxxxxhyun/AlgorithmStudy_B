package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//류호석 강의 듣기전 코드 (구현 성공)
public class Main15652 {
	
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
		
		for(int i=1; i<=N; i++) {
			if(pruning(selected[x-1],i)) {
				selected[x] = i;
				recFunc(x+1);
				selected[x] = 0;
			}
		}
	}
	
	//pruning메서드의 value = 이미 넣어진 값, i = 내가 selected에 넣으려고 하는 값
	public static boolean pruning(int value, int i) {

		if(i >= value) {
			return true;
		}
		
		return false;
	}

}
