package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ù��° Ǯ���� ������
//Ž���� �Ϸ�ɶ����� ��ü ���� ���� �� ����ؾߵǱ⶧����
//Ž���� �Ϸ�Ǵ� �������� for���� ���� calculator�Լ��� �����ϰ� ��
//�̶����� �������� �����, k-1��° �����ڱ��� ����� �����value�� ������ �ٴϰ� ���ڴ� ���� -> Main14888
public class Main1488802 {
	
	public static int N, max, min;
	public static int[] nums, operators, order;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	
	// �ϼ��� �Ŀ� �°� �Ի��� �ؼ� ������ �����ϴ� �۾�
    static int calculator(){
        //nums, order
    	int value = nums[1];
    	for(int i=1; i<=N-1; i++) {
    		//value, order[i], nums[i+1]
    		if(order[i] == 1) { //+
    			value = value + nums[i+1];
    		}
    		if(order[i] == 2) { //-
    			value = value - nums[i+1];
    		}
    		if(order[i] == 3) { //*
    			value = value * nums[i+1];
    		}
    		if(order[i] == 4) { // /
    			value = value / nums[i+1];
    		}
    	}
    	return value;
    }
	
	// order[1...N-1] �� �����ڵ��� ������� ����� ���̴�.
    static void rec_func(int k) {
        if (k == N) {
            // ���� ������ ������� �Ի��ؼ� ������ �����ϱ�
        	// �ϼ��� �Ŀ� �°� �Ի��� �ؼ� ������ �����ϱ�
        	int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        } else {
            // k ��° �����ڴ� ������ ������ ���ΰ�?
            for (int cand = 1; cand <= 4; cand++){
                if (operators[cand] >= 1){
                    operators[cand]--;
                    order[k] = cand;
                    // 4������ �����ڵ� �߿� �� �������� �����ϰ� ���ȣ���ϱ�
                    rec_func(k + 1);
                    operators[cand]++;
                    order[k] = 0;
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
		order = new int[N];
		
		for(int i=1; i<=N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
	}

}
