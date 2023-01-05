package baekjun.RecursiveCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*********Àç±Í ÀÌ¿ë*********/

public class Main10870 {
	
	public static int Fibo(int x) {
		if(x == 0) {
			return 0;
		} else if(x == 1) {
			return 1;
		} else {
			return Fibo(x - 2) + Fibo(x - 1);
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        System.out.println(Fibo(x));

	}

}
