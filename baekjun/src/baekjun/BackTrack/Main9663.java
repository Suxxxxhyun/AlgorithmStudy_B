package baekjun.src.baekjun.BackTrack;
//구현 성공
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//2차원 배열을 사용하지 않고 하기, 왜냐? 그 이전의 정보인 row,col의 정보를 for문을 통해서만 알 수 있기 때문에 시간복잡도가 걸릴것같아
//2차원 배열 말고 동적으로 정보를 담을 수 있는 ArrayList를 활용해보자
public class Main9663 {
	
	public static int N, count;
	public static ArrayList<Integer> nq = new ArrayList<Integer>();
	
	//파라미터에 담긴 n -> 행
	public static void recf(int n) {
		if(n == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(pruning(i)) {
				nq.add(i);
				recf(n+1);
				nq.remove(nq.size()-1);
			}
		}
	}
	
	//현재 0,0일때 무조건 pruning메서드의 반환값을 true로 해줘야함
	public static boolean pruning(int col) {
		
		int candRow = nq.size();
		
		//수직조건, 대각선조건
		//수평조건은 생각할 이유가 없는게, 어차피 현재에 있는것과 다음의 행을 기준으로 생각하기 때문에
		//이때, for문의 의미는, 예를 들어, (0,0), (1,3)을 선택했다면, 그리고 그 다음행의 (3,0)가 되는지 안되는지를 판별할때 선택한 (0,0)과 (1,3) 모두를 기준으로 (3,0)이 안되는지를 판별해야함.
		//그러기 위한 for문임
		for(int i=0; i<candRow; i++) {
			if((nq.get(i) - col) == 0 || (candRow - i == Math.abs(col - nq.get(i)))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;
		
		recf(0);
		System.out.println(count);
		System.out.println(nq);
	}

}
