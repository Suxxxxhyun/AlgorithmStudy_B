package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main21919 {
	
	static Set<Integer> A = new HashSet<Integer>(); //����A�� 7�� 7�� �ִٸ�, �ΰ��� ���ҿ� ���� �ּҰ������ �׳� 7�̶� SET�� ��Ƶ� ��
	static Integer[] Alist; //����A�� ����Ʈ��
	static int N;
	static StringTokenizer st;
	static long result;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		result = 1;
		
		//�ð����⵵ : 10000
		for(int i=0; i<N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		Alist = A.toArray(new Integer[0]);
		
		confirm();
	}
	
	//�ð����⵵(������ �̷���� ����A�� ��� �鸸�̶��) : 10000 * 3�鸸(check������) => 3���
	//�׷��� set�� �������(������ ���ڿ� ���ؼ� �Ҽ����� �ƴ��� �Ǻ������� ��������,ó���� ����A�� �������迭�� ����)
	public static void confirm() {
		boolean isSosu = false;
		for(int i=0; i<Alist.length; i++) {
			if(check(Alist[i])) {
				result *= Alist[i];
				isSosu = true;
			} 
		}
		
		//�Ҽ��� �ϳ��� ���� ���
		if(isSosu == false) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
	
	//�Ҽ����� �ƴ��� �Ǻ��ϴ� �Լ� (count�� 2�̻� �Ѿ�� �ٷ� break�� �ɾ��־����Ƿ�, �ð����⵵�� 3��������)
	//true�� �Ҽ�
	public static boolean check(int num) {
		int count = 0;
		for(int i=1; i<=num; i++) {
			if(num % i == 0) {
				count++;
			}
			
			if(count > 2 ) {
				break;
			}
		}
		
		if(count > 2) {
			return false;
		} else {
			return true;
		}
	}

}
