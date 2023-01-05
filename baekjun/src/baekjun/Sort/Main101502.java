package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main101502 {
	
	public static int n;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int[] P;
	public static Elem[] B;
	
	static class Elem implements Comparable<Elem>{
		public int num, idx;
		
		public int compareTo(Elem elem) {
			/*if(this.num != elem.num)
				return  this.num - elem.num;
			return this.idx - elem.idx; num이 같으면 idx를 오름차순 정렬해줄 필요가 없는 이유는
			자바의 Object타입의 정렬은 tim sort이고 tim sort - stable함
			즉, 비교불가능한 대상에 대해서 입력순서에 따라 정렬결과도 같은 것이 stable한 것인데,
			어차피 입력을 받을때 인덱스가 낮은 순부터 받기 때문에 값이 같은 상황에서 인덱스가 낮은 순으로 들어가게 되어있음*/
			return  this.num - elem.num;
		}

		@Override
		public String toString() {
			return "Elem [num=" + num + ", idx=" + idx + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		B = new Elem[n];
		P = new int[n];
		
		for(int i=0; i<n; i++) {
			B[i] = new Elem();
			int a = Integer.parseInt(st.nextToken());
			B[i].num = a;
			B[i].idx = i;
		}
		
		pro();
	}
	
	static void pro() {
		Arrays.sort(B);
		
		for(int i=0; i<n; i++) {
			P[B[i].idx] = i;
		}
		
		for(int i=0; i<n; i++) {
			sb.append(P[i]).append(' ');
		}
		
		System.out.println(sb);
	}

}
