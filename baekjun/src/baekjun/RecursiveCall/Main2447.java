package baekjun.RecursiveCall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2447 {
	
	public static void main(String[] args) throws IOException{
		
		String[][] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		
		/*for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] = "";
			}
		}*/
		
		star(arr, 0, 0, N);
	}
	
	public static void star(String[][] arr, int x, int y, int N) {
		
		if(N == 1) {
			
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(!(i == 1 && j == 1)) {
					star(arr, x + i * (N/3), y + j * (N/3), N/3);
				}
			}
		}
	}
	
}
