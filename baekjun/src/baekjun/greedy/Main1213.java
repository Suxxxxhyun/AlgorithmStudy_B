package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�Ӹ������ ����
//1. ��ü ���ĺ��� ������ ¦�����, ¦���� �Ƿ���, ¦+¦, Ȧ+Ȧ, -> Ȧ+Ȧ�� �Ӹ�������� ������� ����(��, Ȧ���� ������ �̷���� ���ڴ� �Ӹ������ ���� ���� ����)
//¦+¦�ϰ��, ��ü ������ ����/2 �Ѹ�ŭ�� ���ڿ��� ����� �̿� ���ؼ� �������ָ� ��.
//2. ��ü ���ĺ��� ������ Ȧ�����, Ȧ���� �Ƿ���, ¦+Ȧ -> Ȧ���� �̷���� ���ڸ� ����� ���� �����ѵ�
//����� �������� ���� ������ְ� ������� ���ڸ� �������� �Ӹ������ �������.

//�빮�� A���� Z������ �ƽ�Ű�ڵ� �� -> 65 ~ 90 / ���ĺ��� ������ �� 26��
public class Main1213 {
	
	public static String str = "";
	public static String result = "";
	public static int[] alpha = new int[26];
	public static char find; //�־��� ���ڰ� Ȧ���� ���, Ȧ�����ڿ� ���� ���ڸ� ��� ����

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
	
	//�־��� ���ڿ� ���ؼ� ������ ���ڰ� ��� �����ߴ����� ���� Ƚ���� alpha�迭�� �����. 
	public static void counting() {
		
		//�ð����⵵�� �ִ� 50 -> �־��� ���ڴ� �ִ� 50���ڷ� �̷������ ����
		for(int i=0; i<str.length(); i++) {
			int idx = (int)str.charAt(i) % 65;
			alpha[idx]++;
		}
	}
	
	//�־��� ���ڿ� ���ؼ� �Ӹ������ ���� �� �ִ��� �������� �Ǻ��ϴ� �Լ�
	public static boolean confirm() {
		//�־��� ���ڿ���, Ȧ���� �̷���� ���ڰ� �Ѱ��� �ƴ� ���-> �Ӹ������ ���� �� ����.
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
		//�־��� ���ڰ� ¦�����
		if(len == 0) {
			front = combine();
			reverse(front);
		} //�־��� ���ڰ� Ȧ����� 
		else {
			front = combine();
			result += find;
			reverse(front);
		}
	}
	
	//�߰��� ���ڸ� �����ϰ� �չ��� �����
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
	
	//���� �չ��ڿ� ���ؼ� ������(�̹� ������� result�� ������ ���ڸ� ��ħ)
	public static String reverse(String front) {
		String reversed = new StringBuffer(front).reverse().toString();
		result += reversed;
		return result;
	}
	
	

}
