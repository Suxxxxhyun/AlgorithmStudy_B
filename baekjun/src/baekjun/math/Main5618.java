package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/****************굉장히 의미있는 문제임!! *******************/

public class Main5618 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=1; i<=arr[0]; i++) {
			
			int count = 0;
			
			for(int j=0; j<n; j++) {
				if((arr[j] % i) == 0){
					count++;
				}
			}
			
			//예를 들어 입력을 75와 125로 해주었다면,
			//75도, 125도 i를 가지고 나누었을때 둘다 나누어떨어진다면 --> 공약수의 의미를 가짐.
			if(count == n)
			System.out.println(i);
		}
		
		
	}

}
