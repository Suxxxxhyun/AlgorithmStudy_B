package baekjun.RecursiveCall;

import java.util.Scanner;

public class Main17478 {
	
	static String underBar = "";
	
	public static void RecursiveCall(int x) {
		
		String line = underBar;
		
		if(x == 0) {
			System.out.println(line + "\"����Լ��� ������?\"");
			System.out.println(line + "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.println(line + "��� �亯�Ͽ���.");
			return;
		} 
		
		System.out.println(line + "\"����Լ��� ������?\"");
		System.out.println(line + "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.println(line + "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		System.out.println(line + "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		underBar += "____";
		
		RecursiveCall(x - 1);
		
		System.out.println(line + "��� �亯�Ͽ���.");
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		RecursiveCall(N);

	}

}
