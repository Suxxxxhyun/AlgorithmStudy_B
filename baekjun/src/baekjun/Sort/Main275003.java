package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/****************카운팅 정렬 이용****************/

public class Main275003 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		/* range : -1000 ~ 1000 */
		boolean[] arr = new boolean[2001];
		
		for(int i=0; i<N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000] = true;
		}
		/*5 2 3 4 1을 입력했다면 arr[1005] = true, arr[1002] = true ... arr[1001] = true*/
		
		for(int i=0; i<2001; i++) {
			if(arr[i]) {
				sb.append(i - 1000).append('\n');
			}
		}
		
		System.out.println(sb);
	}

}
