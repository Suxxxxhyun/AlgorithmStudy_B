package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구현 심화(1488802보다 시간복잡도를 낮춘버전)
//이떄까지의 연산자를 결정하면서, 연산결과도 같이 가지고 다닐 수 있게 함.

public class Main14888 {
	
	public static int N, max, min;
	public static int[] nums, operators, order;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();;
	
	// 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
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
	
    // value = k-1번째 연산자까지 게산한 결과를 의미함.
    static void rec_func(int k, int value) {
        //모든 연산자들을 전부 나열하는 방법을 찾은 상태
    	if (k == N) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
    		//int value = calculator(); 이것을 없애준 결과 이전, 1488802에서 다룬, calculator의 for문을 돌지 않게 되서,
    		//시간복잡도를 낮출 수 있음
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            for (int cand = 1; cand <= 4; cand++){
                if (operators[cand] >= 1){
                    operators[cand]--;
                    //4가지의 연산자들 중에 뭘 쓸것인지 선택하고 연산자와, 이때까지의 계산결과를 같이 담아 재귀호출
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
