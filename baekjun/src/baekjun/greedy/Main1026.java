package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//어차피 S의 최솟값만 출력하면 되니까
//B의 배열상태가 원래와 같던 같지 않아도 상관없음
//-> B를 내림차순으로 할 것이고, A를 오름차순으로 정렬한다면
//0번째부터 B의 가장큰값과 A의 가장 작은 값을 곱할 수 있음
//시간복잡도는 정렬할때의 표준정렬라이브러리는 nlogn의 시간복잡도를 갖추므로
//n의 최댓값이 50이기때문에 50log50*2 + 50(최대 50개에 대해서 A와 B를 서로 곱해줘야하나까)
//2초 안에 풀 수있으므로 구현할 가치가생김
public class Main1026 {
	
	public static int n, S;
	public static Integer[] A,B;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new Integer[n];
		B = new Integer[n];
		S = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Sort();
		result();
	}
	
	//A는 오름차순으로 B는 내림차순으로 정렬하는 메소드
	public static void Sort() {
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
	}
	
	//S값 구하기
	public static void result() {
		for(int i=0; i<n; i++) {
			S += A[i] * B[i];
		}
		
		System.out.println(S);
	}

}
