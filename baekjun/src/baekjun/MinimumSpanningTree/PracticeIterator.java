package baekjun.MinimumSpanningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PracticeIterator {

	public static void main(String[] args) {
		
		Set<String> hset = new HashSet<String>();
		hset.add("��");
		hset.add("��");
		hset.add("��");
		hset.add("��");
		//hset.toString()���� ���� �����ʾƵ� �Ǵ�������, 
		//29�������� �����غ���, ���� ���۷�������(obj)�� ����Ѵٶ�� ������ 
		//�ּҰ� ���;��ϴµ�, �� �ּҰ� ���ǵǾ��ִ� �޼��尡 toString()
		//AbstrationCollection Ŭ������ ���� toString()�޼��尡 �����ǵǾ�����. 
		System.out.println(hset);
		
		ArrayList<String> key = new ArrayList<String>();
		Iterator<String> itr = hset.iterator();
		while(itr.hasNext()) {
			key.add(itr.next());
		}
		
		System.out.println(key);
		
		Object obj = new Object();
		System.out.println(obj);
		
		
	}

}
