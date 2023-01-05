package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1015 {
	
	public static int n;
	public static int[] A, B, P;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		A = new int[n];
		B = new int[n];
		P = new int[n];
		
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			A[i] = a;
			B[i] = a;
		}
		
		Arrays.sort(B); //n의 최대치가 50이기때문에, 표준정렬라이브러리의 시간복잡도 -> 50log50, 이미 비내림차순된 배열B
		
		make();
		output();
	}
	
	//배열p에 원소넣기 -> 2500만큼의 시간복잡도를 소요하게됨
	public static void make() {
		for(int i=0; i<n; i++) { //n의 최대치가 50이기때문에, 50개만큼 for문을 돌게 될것이고
			for(int j=0; j<n; j++) { 	//A의 1번째에 있는 원소를 B에서 선형탐색을 하여 같은 원소를 찾아야함. -> 최대 50만큼 시간이 소요됨.
				if(A[i] == B[j]) {
					P[i] = j;
					B[j] = 0; //같은 원소가 2개 이상있는 경우에 대비해서 코드 작성
					break;
				}
			}
		}
	}
	
	public static void output() {
		for(int i=0; i<n; i++) {
			sb.append(P[i] + " ");
		}
		System.out.println(sb);
	}

}
