package baekjun.src.baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//������ ������ ������ ������ �ƴ� ����̱� ������
//����� �������� �ߺ�����
//����1���� ������ �հ�, ����1��� ������ �հ��� ����
//������ �ε��� ��ȣ�� ��ȣ�� ����, �׿� ���� ���� ���������� �Ҷ� -> int[] ����
//int[2] ���� �񱳸� �ϰ� ��. -> �ֳĸ� int[1] -> ����1���̹Ƿ� ������ �հ��̶� 2��°���� �񱳸� �ϸ� �Ǵµ�
//�񱳸� �Ҷ�, int[1] �� ���� ���������ε� �� ������������ ����� ���ƾ� -> ù��° �л����� ������ �ߺ��� �ǹǷ�,
//int[1]�� ������ ���� ���� ã�ư�����. -> ����Ž���� �̷������ �ɰ��̹Ƿ� N�� �ִ�ġ�� �ʸ� -> �̋��� for�� ���� �ʸ�-1�� Ȯ��. �׽�Ʈ�� �ִ�ġ�� 20�̹Ƿ�,
//2�鸸�� �ð����⵵�� ���� ���̰� 2�� �ȿ� ����� ������ �� �ִ�.
public class Main1946 {
	
	public static int t, n, count;
	public static StringTokenizer st;
	public static int[] arr, pivot;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			count = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			pivot = new int[n+1];
			
			for(int j=1; j<=n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
			get();
			
		}
		
		System.out.println(sb);
	}
	
	public static void get() {
		//���� 1������ �л�
		count++;
		int pivot = arr[1]; //���ߵ� ����� ���������� ������ �ٲٱ� ���� ����
		for(int i=2; i<=n; i++) {
			if(arr[i] < pivot) {
				//���ߵ� ����� ���������� ������ �ٲ۴�. -> (hint**) 
				pivot = arr[i];
				count++;
			}
		}
		sb.append(count).append('\n');
	}

}
