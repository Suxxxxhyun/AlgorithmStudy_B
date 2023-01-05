package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//방법1. 학생의 수가 최대 십만, 계수정렬을 사용한다면, 
//국어, 영어, 수학을 나타내는 배열의 인덱스 범위가 1부터 100까지 -> 계수정렬을 사용하면 시간복잡도 O(100 + 100)
//이름같은 경우에는, 배열의 인덱스 범위가 1부터 십만까지 -> 시간은 빠를지 몰라도 공간복잡도가 너무 크니까
//이름같은 경우에는 클래스를 만들어 comparable을 사용하자. -> 모든 점수가 같은 경우, 그제서야 이름에 대해서 정렬을 하는데, 미리 객체를 받을 때 정렬이 되버리니까
//시간복잡도가 많아질 것같아서 그냥 방법2로 구현할 것임.
//방법2. 객체의 필드를 국어,수학,영어,이름 만들어서 Comparable인터페이스 상속받아 구현하는 클래스하나만들면되지않을까?
//-> 성공

//모든 점수가 1이상 100이하이기때문에 int변수를 사용해도됨
//n의 최대치가 10만 -> 10*log10만 이므로 -> 대략160만
//1초안에 충분히 구현가능
public class Main10825 {
	
	public static int N;
	public static StringTokenizer st;
	public static PriorityQueue<student01> pq = new PriorityQueue<student01>();
	//ArrayList타입으로 만들어서 Collections.sort하는 것도 하나의 방법일듯!
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		while(N > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new student01(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			N--;
		}
		
		while(!pq.isEmpty()) {
			student01 stu = pq.poll();
			sb.append(stu.getName()).append('\n');
		}
		
		System.out.println(sb);
		
		
		
	}

}

class student01 implements Comparable<student01>{
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public student01(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int compareTo(student01 stu) {
		
		if(stu.kor == this.kor) {
			if(stu.eng == this.eng) {
				if(stu.math == this.math) {
					return this.name.compareTo(stu.name);
				}
				return stu.math - this.math;
			}
			return this.eng - stu.eng;
		}
		return stu.kor - this.kor;
	}
}
