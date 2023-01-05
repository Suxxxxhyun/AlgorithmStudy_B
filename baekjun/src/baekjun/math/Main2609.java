package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2609 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> n1arr = new ArrayList<Integer>();
		ArrayList<Integer> n2arr = new ArrayList<Integer>();
		
		for(int i=1; i<=n1; i++) {
			if(n1 % i == 0) {
				n1arr.add(i);
			}
		}
		
		for(int i=1; i<=n2; i++) {
			if(n2 % i ==0) {
				n2arr.add(i);
			}
		}
		
		int size = 0;
		
		if(n1arr.size() < n2arr.size()) {
			size = n2arr.size();
		} else if(n1arr.size() == n2arr.size()) {
			size = n1arr.size();
		} else {
			size = n2arr.size();
		}
		
		ArrayList<Integer> measure = new ArrayList<Integer>(); //공약수를 담을 공간
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<n1arr.size(); j++) {
				if((n1arr.get(j)).equals(n2arr.get(i))) { // ***여기서 == 등가연산자 하면 틀림 --> 이거 정리할것!
					measure.add(n2arr.get(i));
				}
			}
		}
		
		int max = 1;
		
		for(int i=0; i<measure.size(); i++) {
			if(max < measure.get(i)) {
				max = measure.get(i);
			}
		}
		System.out.println(max);
		
		int n11 = n1 / max;
		int n22 = n2 / max;
		
		System.out.println(max * n11 * n22);
	}

}
