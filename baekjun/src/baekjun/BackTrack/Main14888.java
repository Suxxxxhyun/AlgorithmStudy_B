package baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//���� ��ȭ(1488802���� �ð����⵵�� �������)
//�̋������� �����ڸ� �����ϸ鼭, �������� ���� ������ �ٴ� �� �ְ� ��.

public class Main14888 {
	
	public static int N, max, min;
	public static int[] nums, operators, order;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();;
	
	// �ǿ����� 2���� �����ڰ� �־����� �� ������ִ� �Լ�
    static int calculator(int operand1, int operator, int operand2){
        // value, order[i], nums[i+1]
        if (operator == 1) // +
            return operand1 + operand2;
        else if (operator == 2) // -
            return operand1 - operand2;
        else if (operator == 3) // *
            return operand1 * operand2;
        else // /
            return operand1 / operand2;
    }
	
    // value = k-1��° �����ڱ��� �Ի��� ����� �ǹ���.
    static void rec_func(int k, int value) {
        //��� �����ڵ��� ���� �����ϴ� ����� ã�� ����
    	if (k == N) {
            // �ϼ��� �Ŀ� �°� ����� �ؼ� ���信 �����ϴ� �۾�
    		//int value = calculator(); �̰��� ������ ��� ����, 1488802���� �ٷ�, calculator�� for���� ���� �ʰ� �Ǽ�,
    		//�ð����⵵�� ���� �� ����
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // k ��° �����ڴ� ������ ������ ���ΰ�?
            for (int cand = 1; cand <= 4; cand++){
                if (operators[cand] >= 1){
                    operators[cand]--;
                    //4������ �����ڵ� �߿� �� �������� �����ϰ� �����ڿ�, �̶������� ������� ���� ��� ���ȣ��
                    rec_func(k + 1, calculator(value, cand, nums[k + 1]));
                    operators[cand]++;
                }
            }
        }
    }

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		nums = new int[N+1];
		operators = new int[5];
		
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
	}

}
