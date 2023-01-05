package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//int�� ������ 2,147,483,647 -> 2�� 31�� -1�� ���� -> �Ʒ��� ���� �ϸ� ����.. ���ʿ� �������� ���� ���� -> �׷��� Long����Ŭ������, longŸ���� ������ ��� �ٲپ���
//-21����� 21������� �ε����� �ϴ� ī��Ʈ �迭�� ����ٰ� �Ѵٸ�,
//�̸� ī��Ʈ�� ���������ؼ� �����Ѵٰ� �Ͽ�����, 43��log43���� ������ ������,
//�ð��ʰ��� ���Ƿ�,
//�Է¹��� ���ڸ� Ű�������ϴ� ī��Ʈ���� ����� �ٰ��ε�,
//�ߺ��� �� �� �����Ƿ�, map�� Ű�� ���ڸ� ���� ����
//-> �̷��� �Ǹ� �ִ� 10������ ī�尡 ��� ���� �ٸ� ���ڶ��, ī��Ʈ �ʿ� ���� ���� �� �ִ� 10�������� �ð����⵵�� �ҿ�� ������.
//�̋��� value�� ����������ϴµ�, value�� list�� ��Ƽ�(�ִ� 10���� �ð��� �ҿ�) + ����(10��log10��) 
//-> �� 20�� + 10��log10�� => 180�� ������ �ð����⵵�� �ҿ��. -> ���� list�� value�� ��Ƽ� �������� ���� �켱����ť�� ����. -> ��. �켱����ť�� ������������ �ϸ鼭, values()�޼ҵ� �� �� ����?
public class Main11652 {
	
	//n�� �ִ� 10���̹Ƿ� int������ �ᵵ��.
	static int n, count;
	static long result;
	static Map<Long,Integer> nums = new HashMap<Long,Integer>();
	//static PriorityQueue<Integer> counting;
	static List<Integer> value; //Ƚ���� ��� �迭
	static List<Long> keys; //Ű(������ �ִ� ����)�� ��� �迭
	static long min = Long.MAX_VALUE; 
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			long num = Long.parseLong(br.readLine());
			if(!nums.containsKey(num)) {
				count = 0;
				nums.put(num, count);
			}
			nums.put(num,nums.get(num) + 1);
		}
		
		//�ʿ� �ִ� ��(Ƚ��)�� ��� ���� values()���
		value = new ArrayList<Integer>(nums.values());
		Collections.sort(value, Collections.reverseOrder());
		
		//���� ���� �ִ� ������ ����ϱ� ����
		//counting�� 0��°�� �����ؼ� ���� �������� -> �ٵ� ���, 10���� ���ڰ� ��� ���� �ٸ� ���ڶ��
		//count�� 1���ٵ�, 1�� �������ϴ� key�� �迭�� ���, ���� ���� ������ ����ϱ� ���� �ٽ� �����ؾ��ϹǷ�, -> �̶� �� 10��log10���� �ð����⵵�� �ҿ��.
		//340�� ������ �ð����⵵�� �ҿ��.

		for(Long key : nums.keySet()) {
			if(nums.get(key).equals(value.get(0))) {
				result = (long) Math.min(min, key);
				min = result;
			}
		}
		System.out.println(result);
	}

}
