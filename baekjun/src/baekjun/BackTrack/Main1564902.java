package baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1564902에서 달라진것은 for문이 내부에 또 생겼기 때문에 시간복잡도가 오래걸려
//시간복잡도를 낮추기 위해 코드를 수정함 -> 1564903
public class Main1564902 {

	public static String str[];
	public static int N, M;
	public static int[] selected;
	public static StringBuilder sb = new StringBuilder();
	
	public static void recFunc(int k) {
		if(k == M + 1) {
			for(int i=1; i<=M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append('\n');
		} else {
			for(int cand = 1; cand <= N; cand++) {
				boolean isUsed = false;
				for(int i=1; i<k; i++) {
					if(cand == selected[i]) {
						isUsed = true;
						//사용된 적이 있다.
					}
				}
				
				if(!isUsed) {
					selected[k] = cand;
					recFunc(k+1);
					selected[k] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		selected = new int[M+1];
		
		recFunc(1);
		System.out.println(sb);
	}

}
