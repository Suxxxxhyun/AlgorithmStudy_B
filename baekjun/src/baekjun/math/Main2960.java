package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2960 {
	
	static int N,K;
	static StringTokenizer st;
	static ArrayList<Integer> nums = new ArrayList<Integer>();
	//2의 배수를 지우고 나서, 3의 배수를 지울때 6은 이미 지워졌기 때문에, 중복처리를 하기 위해서(또 6을 set에 넣을 필요가 없음) set객체 생성
	static Set<Integer> removednum = new HashSet<Integer>();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N-2+1; i++) {
			nums.add(i+2);
		}
		
		eratos();
	}
	
	static void eratos() {
		for(int i=0; i<nums.size(); i++) {
			int end = nums.get(nums.size()-1);
			int start = nums.get(i);
			int idx = end / start;
			for(int j=1; j<=idx; j++) {
				int num = nums.get(i) * j;
				removednum.add(num);
				if(removednum.size() == K) {
					System.out.println(num);
					return;
				}
			}
		}
	}

}
