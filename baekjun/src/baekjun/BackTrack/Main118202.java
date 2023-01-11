package baekjun.src.baekjun.BackTrack;

import java.util.Scanner;

public class Main118202 {
	
	public static int N, S, count = 0; // N: N���� ��, S: ���Ѱ�, count: �κм����� ����
    public static int[] num; //������ ���� �ִ� �迭

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N �Է¹ޱ�
        S = sc.nextInt(); // S �Է¹ޱ�
        num = new int[N]; // ���� �ִ� �迭 �����

        //���� �� �ֱ�
        for(int i=0;i<N;i++){
            num[i] = sc.nextInt();
        }

        dfs(0,0);

        if(S==0){ // count ���� 0�� ���, �����յ� ���ԵǹǷ� �� ���� �ϳ� ���ְ� ����Ѵ�.
            count--;
            System.out.println(count);
        }else{
            System.out.println(count);
        }
	}
	
    private static void dfs(int depth, int sum){ // depth: ��ġ�� ��Ÿ����. sum: �κм����� ��
        if(depth==N){ // ������ ��ġ�� ���,
            if(sum == S){ // ���� ���� ���� ���,
                count++; //�κм��� ���� +1
            }
            return;
        }
        dfs(depth+1, sum+num[depth]); // ���� ��ġ�� ���Ҹ� �����Ѵ�.
        dfs(depth+1, sum); // �������� �ʴ´�.
    }


}
