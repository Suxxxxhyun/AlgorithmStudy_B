package baekjun.src.baekjun.basic;

import java.util.Scanner;

//스캐너 이용

public class Main10872 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println(factorial(N));

	}
	
	static int factorial(int n) {
		
		if(n > 0) {
			return n * factorial(n-1);
		} else {
			return 1;
		}
	}

}
