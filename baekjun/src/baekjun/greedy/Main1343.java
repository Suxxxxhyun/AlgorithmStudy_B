package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1343 {
	
	static int xCount = 0;
	static String board;
	static String result = "";
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = br.readLine();
		count();
	}
	
	//x의 개수를 세어주는 함수
	public static void count() {
		int Completed = 0;
		boolean able = true; //안되는 것에 대해 굳이 만든 문자를 출력할 이유가 없음
		for(int i=0; i<board.length(); i++) {
			if(board.charAt(i) == '.') {
				if(confirm()) {
					make();
					result += board.charAt(i);
					xCount = 0;
				} else {
					//중간에 홀수인경우, 빠져나가는데, 이때 불필요하게 마지막xx를 판단해주기 위한 41라인 함수가 다시 실행되므로, 
					//변수 하나 생성
					System.out.println(-1);
					able = false;
					Completed = 1;
					break;
				}
			} else {
				xCount++;
			}
		}
		
		//예제 3과 같다면, XX에 대해서는 판단여부를 거치지 않으므로,
		//XX에 대해서 판단할 수 있어야함
		if(Completed == 0) {
			if(confirm()) {
				make(); 
			} else {
				System.out.println(-1);
				able = false;
			}
		}
		
		if(able) {
			System.out.println(result);
		}
	}
	
	//x의 개수가 홀수인지 짝수인지 판단하는 함수
	public static boolean confirm() {
		if(xCount % 2 == 1) {
			return false;
		}
		return true;
	}
	
	//AAAA,BB를 이용해 문자 만들기
	public static void make() {
		int mod = xCount % 4; //2
		int mok = xCount / 4; //0
		if(mod == 0) {
			for(int i=0; i<mok; i++) {
				result += "AAAA";
			} 
		} else {
			for(int i=0; i<mok; i++) {
				result += "AAAA";
			}
			for(int i=0; i<mod; i++) {
				result += "B";
			}
		}
		
	}

}
