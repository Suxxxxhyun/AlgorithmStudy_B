package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**************���� -> https://coding-factory.tistory.com/266��α� ���� ****************/
/**************���� ���� -> �����Ǵ� �Ƿε��� ������ �����Ǵ� ���� ������ �������� �ʾƼ� --> ���ѷ����� ����**************/
public class Main22864 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int i=0;
		int p=0; //�����Ǵ� �Ƿε�
		int b=0; //�����Ǵ� ���Ǿ�
		
		while(i < 24) {
			if(i == 24) {
				break;
			}
			
			if(p + A <= M) {
				b += B;
				p += A;
			} else {
				p = p - C  < 0 ? 0 : p - C; // ?�տ��� ����, ( ) ? (��) : (����)
			}
			i++;
		}
		System.out.println(b);
		
	}

}
