package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//T와 S, N의 최댓값이 각각 천과 만,천이기 떄문에 int변수에 쓸 수 있음
//일수도 적어야하고, 보상금도 적어야 함
//실패 -> 처음엔 단순히 보상금이 최대를 기준으로 생각하면 되는 줄 알았음.
public class Main14908 {
	
	static int n, max, idx, day;
	static int[] T, S;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		T = new int[n+1];
		S = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		//가장 큰 보상금을 찾기 위해 max변수 선언 -> 최대 천만큼의 시간복잡도가 소요됨.
		max = 0;
		for(int i=1; i<=n; i++) {
			if(max < S[i]) {
				max = S[i];
				idx = i;
			}
		}
		
		min_money();
		
	}
	
	public static void min_money() {
		
		day = T[idx];
		
		
	}

}
