package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//모든 점수가 1이상 100이하이기때문에 int변수를 사용해도됨
//n의 최대치가 10만 -> 10*log10만 이므로 -> 대략160만
//1초안에 충분히 구현가능
public class Main1082502 {
	
	static int N;
    static Elem[] a;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static class Elem implements Comparable<Elem> {

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            if (korean != other.korean) return other.korean - korean;
            if (english != other.english) return english - other.english;
            if (math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }
    
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new Elem[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Elem();
            st = new StringTokenizer(br.readLine(), " ");
            a[i].name = st.nextToken();
            a[i].korean = Integer.parseInt(st.nextToken());
            a[i].english = Integer.parseInt(st.nextToken());
            a[i].math = Integer.parseInt(st.nextToken());
        }
		
		pro();
	}
	
	static void pro() {
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            sb.append(a[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

}


