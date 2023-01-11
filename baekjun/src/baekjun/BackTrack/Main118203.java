package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N�� �ִ�ġ�� 20, S�� �ִ�ġ�� �鸸, �κм������� ������ �ִ��� �鸸
//�κм����� �ִ� ������ 2�� 20 <= 1048576
//���� ������ int�� ������ ���� �ȴ�.
//�κм����� ���� �ִ� �鸸*20 �̹Ƿ�, 2õ���̶� 
//���� ����ϴ� �������� int�������� ���� ��
//1�����Ҹ� �������� ������ 0�� 1, 2�� ���� ���� �������� ������ 0�� 1�� ��Ÿ����.. �̰��� N�����ұ��� �����Ͽ�����
//0�� 1�� �ߺ��Ͽ� 20���� �����ϴ� �Ͱ� ���� -> �� �ð����⵵�� 2�� 20�� ����.(nm������ 1�������� �ش�� -> �ð����⵵�� n�� m����)
public class Main118203 {
	
	static StringTokenizer st;
	static int[] nums;
	static int n, s, ans;
	
	//k-> k��° ���Ҹ� �������� ���ϴ� �Լ�
	//value -> k-1��° ���ұ��� ����� ���ҵ��� ��?? -> k��° ���ұ��� ����� ���ҵ��̶�� �ؾ����� �ʳ� ������
	static void rec_func(int k, int value) {
		//�κ� ������ �ϳ� �ϼ���Ų ����
		if(k == n+1) {
			if(value == s) {
				ans++;
			}
		} else {
			//k��° ���Ҹ� ���Խ�ų�� �����ϰ� ���ȣ�����ֱ�
			//include
			rec_func(k+1, value+nums[k]);
			//not include
			rec_func(k+1, value);
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		ans = 0;
		nums = new int[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		rec_func(1,0);
		//ans�� ���� �� �κ����ո� �ٷ���� Ȯ���ϱ�
		if(s == 0) {
			ans--;
		}
		System.out.println(ans);
	}

}
