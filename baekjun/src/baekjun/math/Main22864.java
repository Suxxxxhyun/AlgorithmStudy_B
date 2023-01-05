package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**************실패 -> https://coding-factory.tistory.com/266블로그 참조 ****************/
/**************실패 원인 -> 누적되는 피로도의 변수와 누적되는 일의 변수를 설정하지 않아서 --> 무한루프에 빠짐**************/
public class Main22864 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int i=0;
		int p=0; //누적되는 피로도
		int b=0; //누적되는 일의양
		
		while(i < 24) {
			if(i == 24) {
				break;
			}
			
			if(p + A <= M) {
				b += B;
				p += A;
			} else {
				p = p - C  < 0 ? 0 : p - C; // ?앞에가 조건, ( ) ? (참) : (거짓)
			}
			i++;
		}
		System.out.println(b);
		
	}

}
