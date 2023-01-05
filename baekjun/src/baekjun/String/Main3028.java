package baekjun.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main3028 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		ArrayList<Character> arr = new ArrayList<>();
		arr.add('G');
		arr.add(null);
		arr.add(null);
		
		for(int i=0; i<str.length(); i++) {
			
			char c = str.charAt(i);
			
			switch(c) {
				case 'A' :
					Collections.swap(arr, 0, 1);
					break;
				case 'B' :
					Collections.swap(arr, 1, 2);
					break;
				case 'C' :
					Collections.swap(arr, 0, 2);
					break;
				default :
					break;
			}
		}
		
		System.out.println(arr.indexOf('G') + 1);
	}

}
