package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/****************������ �ǹ��ִ� ������!! *******************/

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
			
			//���� ��� �Է��� 75�� 125�� ���־��ٸ�,
			//75��, 125�� i�� ������ ���������� �Ѵ� ����������ٸ� --> ������� �ǹ̸� ����.
			if(count == n)
			System.out.println(i);
		}
		
		
	}

}
