package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://velog.io/@pppp0722/%EB%B0%B1%EC%A4%80-%EA%B3%A8%EB%93%9C1-14908-%EA%B5%AC%EB%91%90-%EC%88%98%EC%84%A0%EA%B3%B5-Java
//를 참조하니, t/s가 기준이고 이 값이 작은 순으로 작업을 선택하고
//만약 t/s가 같다면, 번호가 작은 번호를 순으로 먼저 작업을 선택하면 된다고 함.
//-> 이에 따른 이유역시 다시 봐야할 듯
public class Main1490802 {
	
	//n, t, s의 최댓값이 각각 1000, 1000, 10000이므로 int형 변수에 담아도 됨.
	static int n;
	static work[] works;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		works = new work[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			works[i] = new work(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(works);
		for(int i=0; i<works.length; i++) {
			sb.append(works[i].getIdx()).append(" ");
		}
		
		System.out.println(sb);
	}

}

class work implements Comparable<work>{
	private int idx; //작업번호(작업이 최대 1000이므로 int형변수에 담아도 됨.)
	private int t; //작업번호에 따른 일수
	private int s; //작업번호에 따른 보상금
	
	public work(int idx, int t, int s) {
		this.idx = idx;
		this.t = t;
		this.s = s;
	}
	
	public int getIdx() {
		return this.idx;
	}
	
	public int getT() {
		return this.t;
	}
	
	public int getS() {
		return this.s;
	}
	
	@Override
	public int compareTo(work w) {
		double div1 = (double)this.t / (double)this.s;
		double div2 = (double)w.t / (double)w.s;
		
		if(div1 == div2) {
			return this.idx - w.idx;
		}
		//baekjun.Sort > Main1082502 > string을 필드로하는 객체라면 compareTo로 비교(파라미터 한개)
		//double > compare비교(파라미터를 2개로 받음)
		return Double.compare(div1, div2);
	}
}
