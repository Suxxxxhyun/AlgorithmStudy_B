package baekjun.src.baekjun.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//�����̴� ���� ���ڸ� ������ �� �� �־�, ��ø 1�� ���� ���ڰ� ������ �� ���� ������,
//���Դ� ����� ��������, ���� ���ڸ� ������ ��� ������ ����. ���� ��ø2�� �ߺ��� ������� �ʰԲ� ���ָ� ��.
//ó���� �����̿� ���Ը� ��� �迭������ ����ְ� ���� �������� �ʰ� ǰ. �׷��� �ð��ʰ��� ��.

//�ٵ� ��� �����̵� ���ʿ� �̹� �� ���ڸ� ���� ��ø1�� �� ���� ������ ����.

public class Main2776 {
	
	public static int T, N, M;
	public static Set<Integer> arr = new HashSet<Integer>();
	public static StringTokenizer st1, st2;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			//�׽�Ʈ ���̽��� ������ 2�̻��� ��� - set clear
			arr.clear();
			N = Integer.parseInt(br.readLine());
			st1 = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<N; j++) {
				arr.add(Integer.parseInt(st1.nextToken()));
			}
			
			M = Integer.parseInt(br.readLine());
			st2 = new StringTokenizer(br.readLine(), " ");
			
			for(int k=0; k<M; k++) {
				if(arr.contains(Integer.parseInt(st2.nextToken()))) {
					sb.append('1').append('\n');
				} else {
					sb.append('0').append('\n');
				}
			}
		}
		
		System.out.println(sb);
		
		/*Iterator<Integer> iterator = arr2.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}*/
		
	}

}
