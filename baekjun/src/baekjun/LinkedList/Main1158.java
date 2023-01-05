package baekjun.LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1158 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		//이거 자체는, (br.readLine, "구분자") 구분자를 넣지않았다면, 그냥 띄어쓰기를 기준으로 토큰이 처리됨.
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while(q.size() != 1) {
			for(int i=0; i < K-1; i++) {
				q.offer(q.poll());
			}
			
			sb.append(q.poll() + ", ");
		}
		
		sb.append(q.poll() + ">");
		
		bw.write(sb.toString() + "\n"); //toString메소드는 객체가 지닌 값을 문자열로 만들어줌
		//bw.write의 타입은 String타입으로 파라미터를 받음. 근데 stringBuilder는 char형으로 받음.
		//sb에 있는 값을 문자열로 만들기 위해 toString()메소드 사용함.
		bw.flush(); //남아있는 데이터를 모두 출력시킴
		bw.close(); //스트림을 닫음
		br.close();

	}

}
