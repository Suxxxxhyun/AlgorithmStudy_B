package baekjun.src.baekjun.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//연종이는 같은 숫자를 여러번 볼 수 있어, 수첩 1에 같은 숫자가 여러번 들어갈 수도 있지만,
//동규는 물어보는 입장으로, 같은 숫자를 여러번 물어볼 이유가 없음. 따라서 수첩2는 중복을 허용하지 않게끔 해주면 됨.
//처음엔 연종이와 동규를 모두 배열공간에 집어넣고 위를 생각하지 않고 품. 그래서 시간초과가 남.

//근데 사실 연종이도 애초에 이미 본 숫자를 굳이 수첩1에 또 적을 이유가 없음.

public class Main2776 {
	
	public static int T, N, M;
	public static Set<Integer> arr = new HashSet<Integer>();
	public static StringTokenizer st1, st2;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			//테스트 케이스의 개수가 2이상일 경우 - set clear
			arr.clear();
			N = Integer.parseInt(br.readLine());
			st1 = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<N; j++) {
				arr.add(Integer.parseInt(st1.nextToken()));
			}
			
			M = Integer.parseInt(br.readLine());
			st2 = new StringTokenizer(br.readLine(), " ");
			
			for(int k=0; k<M; k++) {
				if(arr.contains(Integer.parseInt(st2.nextToken()))) {
					sb.append('1').append('\n');
				} else {
					sb.append('0').append('\n');
				}
			}
		}
		
		System.out.println(sb);
		
		/*Iterator<Integer> iterator = arr2.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}*/
		
	}

}
