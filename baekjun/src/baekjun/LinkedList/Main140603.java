package baekjun.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

/***************************** Iterator ��� ************************************************/

public class Main140603 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int M = Integer.parseInt(br.readLine());
		
		LinkedList<Character> list = new LinkedList<>();
		
		for(int i=0; i<str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		//�ݺ����� iterator, listiterator --> Ŀ���� ����� �����ִ�. 
		//�迭�� 3�����, ������ ��ü�� �ε����� 0,1,2 --> Ŀ���� 0,1,2,3���� ����
		//�� n���� �迭���� Ŀ���� 0���� n���� ����
		ListIterator<Character> iter = list.listIterator();
		
		//hasNext�޼����, ����Ʈ �ݺ��ڰ� �ش� ����Ʈ�� ���������� ��ȸ�Ҷ� ������Ұ� ������ true
		while(iter.hasNext()) {
			iter.next();
		}
		//next()�޼ҵ��, ���� ���(������)�� ��ȯ�ϰ�, Ŀ���� ���������� ��ġ��Ŵ.
		//�׷��Ƿ�, �� while������ abcd�� �Է��ߴٸ�, Ŀ���� d�ڿ� ��ġ�ϰԵ�.
		
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
				case "L" : 
					if(iter.hasPrevious()) {
						iter.previous();
					}
					//hasPrevious : ����Ʈ�� ���������� ��ȸ�Ҷ� ������Ұ� ������ true, �� Ŀ���� ����Ǿտ� ��ġ�ϰ� �ȴٸ�, ������Ұ� ������ ���� �ȵ�.
				break;
				case "D" :
					if(iter.hasNext()) {
						iter.next();
					}
				break;
				case "B" :
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				break;
				case "P" :
					iter.add(st.nextToken().charAt(0));
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();

		
		for(char c : list) {
			sb.append(c);
		}
		
		System.out.println(sb);
	}

}
