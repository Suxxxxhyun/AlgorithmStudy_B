package baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main192004 {
	
	public static int [] arr; //-> arr배열 static으로 할당하지 않으면 시간초과가 안나는지 확인해볼것!

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			if(BinarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append('1').append('\n');
			} else {
				sb.append('0').append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static int BinarySearch(int key) {
		int leftidx = 0;
		int rightidx = arr.length - 1;
		
		while(leftidx <= rightidx) {
			int mid = (leftidx + rightidx) / 2;
			
			if(arr[mid] == key) {
				return mid;
			} else if(arr[mid] > key){
				rightidx = mid - 1;
			} else if(arr[mid] < key) {
				leftidx = mid + 1;
			}
		}
		
		return -1;
		
	}

}
