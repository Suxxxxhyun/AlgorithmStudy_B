package baekjun.src.baekjun.basic;

import java.util.Scanner;

public class Main2588 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		String B = in.next();
		
		in.close();
		
		System.out.println(A * (B.charAt(2) - '0')); 
		// charAt(index) : string���� ����� ���ڿ� �߿��� �ѱ��ڸ� �����Ͽ� charŸ������ ��ȯ���� 
		// -'0'�� ���ִ� ���� : charAt(2)�� ���ְ� �Ǹ� (���� ��� 473�̶�� �����Ҷ�, charAt(2) ����� ���� 3��. 
		// ���� 3�� int������ ����ȯ�� �ϸ� �ƽ�Ű�ڵ尪�� ����. ����3�� int������ ����ȯ�ϸ� 51�� ��µ�.
		// �ٵ� �츮�� ���� 3�� ������ �ϰ� �������ݾ�. �׷� 51���� 48�� ���������?
		// 0�� ���� �ƽ�Ű�ڵ尪�� 48�̶� ���� '0'�� ���ִ°���
		System.out.println(A * (B.charAt(1) - '0'));
		System.out.println(A * (B.charAt(0) - '0'));
		System.out.println(A * Integer.parseInt(B)); //integer.parseInt�� ���ڸ� ���ڷ� �ٲ���

	}

}
