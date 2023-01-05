package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2460 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int Sub = 0;
		int [] result = new int[10];
		
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int getOff = Integer.parseInt(st.nextToken());
			int getIn = Integer.parseInt(st.nextToken());
			
			Sub += getIn;
			Sub -= getOff;
			result[i] = Sub;
		}
		
		int max = result[0];
		
		for(int i=0; i<10; i++) {
			if(max < result[i]) {
				max = result[i];
			}
		}
		System.out.println(max);
		
	}

}
