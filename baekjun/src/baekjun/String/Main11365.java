package baekjun.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11365 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str;
		while((str = br.readLine()) != null) {
			if(str == "END" || str.equals("END")) {
				break;
			}
			for(int i=str.length()-1; i>=0; i--) {
				sb.append(str.charAt(i));
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
