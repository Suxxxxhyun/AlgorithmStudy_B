package baekjun.src.baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//면접과 서류의 정보가 점수가 아닌 등수이기 때문에
//등수가 낮을수록 잘본것임
//서류1등은 무조건 합격, 면접1등역시 무조건 합격인 구조
//서류를 인덱스 번호로 번호로 보고, 그에 따른 값을 면접등수라고 할때 -> int[] 저장
//int[2] 부터 비교를 하게 됨. -> 왜냐면 int[1] -> 서류1등이므로 무조건 합격이라 2번째부터 비교를 하면 되는데
//비교를 할때, int[1] 의 값이 면접순위인데 그 면접순위보다 등수가 낮아야 -> 첫번째 학생보다 면접은 잘본게 되므로,
//int[1]의 값보다 작은 값을 찾아가야함. -> 선형탐색이 이루어지게 될것이므로 N의 최대치는 십만 -> 이떄의 for문 역시 십만-1번 확인. 테스트의 최대치는 20이므로,
//2백만의 시간복잡도가 나올 것이고 2초 안에 충분히 구현할 수 있다.
public class Main1946 {
	
	public static int t, n, count;
	public static StringTokenizer st;
	public static int[] arr, pivot;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			count = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			pivot = new int[n+1];
			
			for(int j=1; j<=n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
			get();
			
		}
		
		System.out.println(sb);
	}
	
	public static void get() {
		//서류 1순위의 학생
		count++;
		int pivot = arr[1]; //선발된 사람의 면접순위로 기준을 바꾸기 위한 변수
		for(int i=2; i<=n; i++) {
			if(arr[i] < pivot) {
				//선발된 사람의 면접순위로 기준을 바꾼다. -> (hint**) 
				pivot = arr[i];
				count++;
			}
		}
		sb.append(count).append('\n');
	}

}
