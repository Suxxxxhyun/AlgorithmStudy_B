package baekjun.BackTrack;

import java.util.Scanner;

public class Main966303 {
	
	public static int N, ans; //ans : ����� ���� ��� ����
	public static int[] col;
	//col[i] : i�� ���� ���� col[i]�� ���� ���Ҵٴ� ���
	public static StringBuilder sb = new StringBuilder();
	
	//row�� ~ N�� �࿡ ���ؼ� ������ ���� ���� ����� �� ���ϱ�
	public static void rec_func(int row) {
		if(row == N+1) { // 1~N�� �࿡ ���ؼ� ���������� ���� ��쿡�� ����� ���� ����.
			ans++;
		} else {
			for(int c=1; c<=N; c++) {
				boolean possible = true;
				//row���� c���� ���� �� ������
				//vaild check(row,c)�� ���ؼ� valid check�� �����ϸ� ��
				for(int i=1; i<=row-1; i++) {
					//(i,col[i])
					//���� ������ �ϴ� row,c�� i,col[i]�� ���ݰ����� ��ġ���
					if(attackable(row, c, i, col[i])) {
						//�Ұ�����
						possible = false;
						break;
					}
				}
				
				if(possible) {
					col[row] = c; //row��° ��, c���� ���Ҵٴ� ���
					rec_func(row+1);
					col[row] = 0;
				}
			}
		}
	}
	
	/*public static boolean validity_check() {
		for(int i=1; i<=N; i++) {
			//i������ �࿡ ���� ���� ��ǥ�� -> (i, col[i]) 
			for(int j=1; j<i; j++) {
				//j������ �࿡ ���� ���� ��ǥ�� -> (j, col[j])
				if(attackable(i, col[i], j, col[j])) {
					//���� ������ ���־�? -> ����
					return false;
				}
			}
		}
		return true;
	}*/
	
	//ù��° ���� r1,c1�� �ְ�
	//�ι�° ���� r2,c2�� �ִٰ� ����
	public static boolean attackable(int r1, int c1, int r2, int c2) {
		//���� ���� �ִٸ�
		if(c1 == c2) {
			return true;
		}
		//�� - ���� ���� �Ȱ��� �ֵ��� ������ �Ʒ� �밢�� -> ��, ���� ������ �� �ִ� ����
		if(r1 - c1 == r2 - c2) {
			return true;
		}
		//�� + ���� ���� �Ȱ��� �ֵ��� ������ �� �밢�� -> ��, ���� ������ �� �ִ� ����
		if(r1 + c1 == r2 + c2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		rec_func(1);
		System.out.println(ans);
	}

}

