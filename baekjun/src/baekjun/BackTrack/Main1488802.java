package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//첫번째 풀이의 문제점
//탐색이 완료될때마다 전체 식을 전부 다 계산해야되기때문에
//탐색이 완료되는 순간마다 for문을 통해 calculator함수를 수행하게 됨
//이때까지 연산자의 결과와, k-1번째 연산자까지 계산한 결과인value를 가지고 다니게 하자는 것이 -> Main14888
public class Main1488802 {
	
	public static int N, max, min;
	public static int[] nums, operators, order;
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	
	// 완성된 식에 맞게 게산을 해서 정답을 갱신하는 작업
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
	
	// order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
    static void rec_func(int k) {
        if (k == N) {
            // 정한 연산자 순서대로 게산해서 정답을 갱신하기
        	// 완성된 식에 맞게 게산을 해서 정답을 갱신하기
        	int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            for (int cand = 1; cand <= 4; cand++){
                if (operators[cand] >= 1){
                    operators[cand]--;
                    order[k] = cand;
                    // 4가지의 연산자들 중에 뭘 쓸것인지 선택하고 재귀호출하기
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
