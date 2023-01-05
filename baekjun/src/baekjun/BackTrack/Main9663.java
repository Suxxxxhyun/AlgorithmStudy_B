package baekjun.BackTrack;
//���� ����
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//2���� �迭�� ������� �ʰ� �ϱ�, �ֳ�? �� ������ ������ row,col�� ������ for���� ���ؼ��� �� �� �ֱ� ������ �ð����⵵�� �ɸ��Ͱ���
//2���� �迭 ���� �������� ������ ���� �� �ִ� ArrayList�� Ȱ���غ���
public class Main9663 {
	
	public static int N, count;
	public static ArrayList<Integer> nq = new ArrayList<Integer>();
	
	//�Ķ���Ϳ� ��� n -> ��
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
	
	//���� 0,0�϶� ������ pruning�޼����� ��ȯ���� true�� �������
	public static boolean pruning(int col) {
		
		int candRow = nq.size();
		
		//��������, �밢������
		//���������� ������ ������ ���°�, ������ ���翡 �ִ°Ͱ� ������ ���� �������� �����ϱ� ������
		//�̶�, for���� �ǹ̴�, ���� ���, (0,0), (1,3)�� �����ߴٸ�, �׸��� �� �������� (3,0)�� �Ǵ��� �ȵǴ����� �Ǻ��Ҷ� ������ (0,0)�� (1,3) ��θ� �������� (3,0)�� �ȵǴ����� �Ǻ��ؾ���.
		//�׷��� ���� for����
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
