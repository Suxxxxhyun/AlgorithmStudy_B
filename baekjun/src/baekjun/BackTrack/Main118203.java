package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N의 최대치가 20, S의 최대치가 백만, 부분수열에서 원소의 최댓값은 백만
//부분수열의 최대 개수는 2의 20 <= 1048576
//정답 변수는 int형 변수를 쓰면 된다.
//부분수열의 합은 최대 백만*20 이므로, 2천만이라 
//합을 기록하는 변수역시 int형변수를 쓰면 됨
//1번원소를 포함할지 말지를 0과 1, 2번 원소 역시 포함할지 말지를 0과 1로 나타내면.. 이것을 N번원소까지 생각하였을때
//0과 1을 중복하여 20개를 나열하는 것과 같음 -> 즉 시간복잡도는 2의 20과 같음.(nm문제에 1번유형에 해당됨 -> 시간복잡도는 n의 m제곱)
public class Main118203 {
	
	static StringTokenizer st;
	static int[] nums;
	static int n, s, ans;
	
	//k-> k번째 원소를 포함할지 정하는 함수
	//value -> k-1번째 원소까지 골라진 원소들의 합?? -> k번째 원소까지 골라진 원소들이라고 해야하지 않나 ㅇㅅㅇ
	static void rec_func(int k, int value) {
		//부분 수열을 하나 완성시킨 상태
		if(k == n+1) {
			if(value == s) {
				ans++;
			}
		} else {
			//k번째 원소를 포함시킬지 결정하고 재귀호출해주기
			//include
			rec_func(k+1, value+nums[k]);
			//not include
			rec_func(k+1, value);
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		ans = 0;
		nums = new int[n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		rec_func(1,0);
		//ans가 정말 진 부분집합만 다루는지 확인하기
		if(s == 0) {
			ans--;
		}
		System.out.println(ans);
	}

}
