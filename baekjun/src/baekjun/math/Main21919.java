package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main21919 {
	
	static Set<Integer> A = new HashSet<Integer>(); //수열A에 7과 7이 있다면, 두개의 원소에 대해 최소공배수는 그냥 7이라서 SET에 담아도 됨
	static Integer[] Alist; //집합A를 리스트로
	static int N;
	static StringTokenizer st;
	static long result;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		result = 1;
		
		//시간복잡도 : 10000
		for(int i=0; i<N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		Alist = A.toArray(new Integer[0]);
		
		confirm();
	}
	
	//시간복잡도(만개로 이루어진 수열A가 모두 백만이라면) : 10000 * 3백만(check때문에) => 3백억
	//그래서 set에 담아주자(동일한 숫자에 대해서 소수인지 아닌지 판별해주지 않으려고,처음엔 수열A를 일차원배열에 넣음)
	public static void confirm() {
		boolean isSosu = false;
		for(int i=0; i<Alist.length; i++) {
			if(check(Alist[i])) {
				result *= Alist[i];
				isSosu = true;
			} 
		}
		
		//소수가 하나도 없는 경우
		if(isSosu == false) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
	
	//소수인지 아닌지 판별하는 함수 (count가 2이상 넘어가면 바로 break를 걸어주었으므로, 시간복잡도가 3정도나옴)
	//true면 소수
	public static boolean check(int num) {
		int count = 0;
		for(int i=1; i<=num; i++) {
			if(num % i == 0) {
				count++;
			}
			
			if(count > 2 ) {
				break;
			}
		}
		
		if(count > 2) {
			return false;
		} else {
			return true;
		}
	}

}
