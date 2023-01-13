package baekjun.src.baekjun.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17608 {
	
	public static int N;
	public static int count = 0;
	public static int[] height;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		height = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		int standard = height[height.length - 1];
		
		for(int i=height.length-2; i>0; i--) {
			if(height[i] > standard) {
				count++;
				standard = height[i];
			}
		}
		
		System.out.println(count+1);
	}

}
