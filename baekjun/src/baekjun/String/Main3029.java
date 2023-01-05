package baekjun.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3029 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), ":");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), ":");
		
		int h1 = Integer.parseInt(st1.nextToken());
		int m1 = Integer.parseInt(st1.nextToken());
		int s1 = Integer.parseInt(st1.nextToken());
				
		int h2 = Integer.parseInt(st2.nextToken());
		int m2 = Integer.parseInt(st2.nextToken());
		int s2 = Integer.parseInt(st2.nextToken());
		
		int hh, mm, ss;
		
		hh = h2 - h1;
		mm = m2 - m1;
		ss = s2 - s1;
		
		if(ss < 0) {
			mm--;
			ss += 60;
		}
		
		if(mm < 0) {
			hh--;
			mm += 60;
		}
		
		if(hh < 0) {
			hh += 24;
		}
		
		if(hh == 0 && mm == 0 && ss == 0) {
			System.out.println("24:00:00");
		} else {
			System.out.printf("%02d:%02d:%02d", hh, mm, ss);
		}
	}

}
