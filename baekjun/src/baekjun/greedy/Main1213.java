package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//팰린드롬의 조건
//1. 전체 알파벳의 개수가 짝수라면, 짝수가 되려면, 짝+짝, 홀+홀, -> 홀+홀은 팰린드롬으로 만들수가 없음(즉, 홀수의 개수로 이루어진 문자는 팰린드롬을 만들 수가 없음)
//짝+짝일경우, 전체 문자의 길이/2 한만큼만 문자열을 만들고 이에 대해서 뒤집어주면 됨.
//2. 전체 알파벳의 개수가 홀수라면, 홀수가 되려면, 짝+홀 -> 홀수로 이루어진 문자를 가운데에 먼저 정렬한뒤
//가운데를 기준으로 왼쪽 만들어주고 만들어준 문자를 뒤집으면 팰림드롬이 만들어짐.

//대문자 A부터 Z까지의 아스키코드 값 -> 65 ~ 90 / 알파벳의 개수는 총 26개
public class Main1213 {
	
	public static String str = "";
	public static String result = "";
	public static int[] alpha = new int[26];
	public static char find; //주어진 문자가 홀수일 경우, 홀수문자에 대한 문자를 담는 변수

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		counting();
		if(confirm()){
			make();
			System.out.println(result);
		} else {
			System.out.println("I'm Sorry Hansoo");
		}
	}
	
	//주어진 문자에 대해서 각각의 문자가 몇번 등장했는지에 대한 횟수를 alpha배열에 담아줌. 
	public static void counting() {
		
		//시간복잡도가 최대 50 -> 주어진 문자는 최대 50글자로 이루어지기 떄문
		for(int i=0; i<str.length(); i++) {
			int idx = (int)str.charAt(i) % 65;
			alpha[idx]++;
		}
	}
	
	//주어진 문자에 대해서 팰린드롬을 만들 수 있는지 없는지를 판별하는 함수
	public static boolean confirm() {
		//주어진 문자에서, 홀수로 이루어진 문자가 한개가 아닌 경우-> 팰린드롬을 만들 수 없음.
		int count = 0;
		for(int i=0; i<26; i++) {
			int val = alpha[i] % 2;
			if(val == 1) {
				count++;
			}
		}
		
		if(count == 0 || count == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void make() {
		int len = str.length() % 2;
		String front;
		//주어진 문자가 짝수라면
		if(len == 0) {
			front = combine();
			reverse(front);
		} //주어진 문자가 홀수라면 
		else {
			front = combine();
			result += find;
			reverse(front);
		}
	}
	
	//중간의 문자를 제외하고 앞문자 만들기
	public static String combine() {
		for(int i=0; i<26; i++) {
			int val = alpha[i];
			if(val != 0) {
				for(int j=0; j<val/2; j++) {
					result += (char)(i + 65);
				}
			}
			if(val % 2 == 1) {
				find = (char)(i + 65);
			}
		}
		return result;
	}
	
	//만든 앞문자에 대해서 뒤집기(이미 만들어진 result에 뒤집을 문자를 합침)
	public static String reverse(String front) {
		String reversed = new StringBuffer(front).reverse().toString();
		result += reversed;
		return result;
	}
	
	

}
