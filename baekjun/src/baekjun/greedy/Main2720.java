package baekjun.src.baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

//�Ҽ����� ����� ����� ���� �ʴ´ٸ� �׳� int�� �ٲپ��־ ��������
public class Main2720 {
	
	static int t,c;
	static int[] kinds = {25,10,5,1};
	static StringBuilder sb = new StringBuilder();
	static BigDecimal val;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			c = Integer.parseInt(br.readLine());
			save();
		}
		
		System.out.println(sb);
		
		
	}
	
	public static void save() {
		
		for(int i=0; i<kinds.length; i++) {
			int count = c/kinds[i];
			sb.append(count).append(" ");
			c -= count * kinds[i];
		}
		sb.append('\n');
	}

}
