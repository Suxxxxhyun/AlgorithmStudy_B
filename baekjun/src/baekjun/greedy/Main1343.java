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
	
	//x�� ������ �����ִ� �Լ�
	public static void count() {
		int Completed = 0;
		boolean able = true; //�ȵǴ� �Ϳ� ���� ���� ���� ���ڸ� ����� ������ ����
		for(int i=0; i<board.length(); i++) {
			if(board.charAt(i) == '.') {
				if(confirm()) {
					make();
					result += board.charAt(i);
					xCount = 0;
				} else {
					//�߰��� Ȧ���ΰ��, ���������µ�, �̶� ���ʿ��ϰ� ������xx�� �Ǵ����ֱ� ���� 41���� �Լ��� �ٽ� ����ǹǷ�, 
					//���� �ϳ� ����
					System.out.println(-1);
					able = false;
					Completed = 1;
					break;
				}
			} else {
				xCount++;
			}
		}
		
		//���� 3�� ���ٸ�, XX�� ���ؼ��� �Ǵܿ��θ� ��ġ�� �����Ƿ�,
		//XX�� ���ؼ� �Ǵ��� �� �־����
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
	
	//x�� ������ Ȧ������ ¦������ �Ǵ��ϴ� �Լ�
	public static boolean confirm() {
		if(xCount % 2 == 1) {
			return false;
		}
		return true;
	}
	
	//AAAA,BB�� �̿��� ���� �����
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
