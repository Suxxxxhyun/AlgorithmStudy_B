package baekjun.MinimumSpanningTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PracticeIterator {

	public static void main(String[] args) {
		
		Set<String> hset = new HashSet<String>();
		hset.add("가");
		hset.add("가");
		hset.add("나");
		hset.add("다");
		//hset.toString()으로 굳이 하지않아도 되는이유는, 
		//29라인으로 생각해보면, 보통 레퍼런스변수(obj)를 출력한다라고 했을때 
		//주소가 나와야하는데, 그 주소가 정의되어있는 메서드가 toString()
		//AbstrationCollection 클래스에 의해 toString()메서드가 재정의되어있음. 
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
