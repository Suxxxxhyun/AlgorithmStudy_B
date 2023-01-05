package baekjun.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*************************************** 실패 --> 블로그 통해서 수정함 ***************************************/

public class Main2941 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		System.out.println(count(str));

	}
	
	static int count(String s) {
		
		int cout = 0;
		
		for(int i=0; i<s.length(); i++) {
			
			switch(s.charAt(i)) {
			
				case 'c' :
					if(i < s.length() - 1) {
						if(s.charAt(i+1) == '=' || s.charAt(i+1) == '-') {
							i++;
						} 
						break;
					}
			
				case 'd' :
					if(i < s.length() - 1) {
						if(s.charAt(i+1) == '-') {
							i++;
						} else if(s.charAt(i+1) == 'z') {
							if(i < s.length() - 2) {
								if(s.charAt(i+2) == '=') {
									i += 2;
								}
							}
						}
						break;
					} 
					
					if(i < s.length() - 2) {
						if(s.charAt(i+1) == 'z' && s.charAt(i+2) == '=') {
							i += 2;
						}
						break;
					}
				case 'l' :
					if(i < s.length() -1) {
						if(s.charAt(i+1) == 'j'){
							i++;
						} 
						break;
					}
				case 'n' :
					if(i < s.length() -1) {
						if(s.charAt(i+1) == 'j') {
							i++;
						} 
						break;
					}
				case 's' :
					if(i < s.length() -1) {
						if(s.charAt(i+1) == '=') {
							i++;
						} 
						break;
					}
				case 'z' :
					if(i < s.length() -1) {
						if(s.charAt(i+1) == '=') {
							i++;
						} 
						break;
					}
				default :
					break;
				
			}
			
			cout++;
			
			
		}
		
		return cout;
		
		
	}

}
