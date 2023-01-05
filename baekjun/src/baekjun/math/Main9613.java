package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//완탐으로 두개의 쌍을 구해볼까? -> 가능한 수가 최대 100개
//100개중에서 2개를 뽑는 경우의 수는 100C2 = 100*99/2 = 55*99 -> 테스트의 개수가 총 100개이므로
//100개모두 100개로 이루어진 수라고 하면 -> 55*99*100 = 약50만이므로 1초안에 충분히 풀 수 있음
//t, n의 최대값 모두 100이므로 int형변수
//n개의 수로 이루어지는 각각의 수의 범위 -> 최대 백만 -> int타입의 일차원배열가능
//합을 담는 sum변수는, 수의 개수가 100개이고 이 100개 모두 백만이라고 한다면, 이때의 최대공약수는
//50만 * 백만 -> 5천억 -> long변수에 담아야함
public class Main9613 {

    static int t, n;
    static long sum;
    static StringTokenizer st;
    static int[] arr; //isUsed;
    static nums[] selected;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> A = new ArrayList<Integer>(); //첫번째 수에 대해서 약수 넣는 공간
    static ArrayList<Integer> B = new ArrayList<Integer>(); //두번째 수에 대해서 약수 넣는 공간

    static class nums implements Comparable<nums>{
        public int idx, num;

        public int compareTo(nums n) {
            return this.idx - n.idx;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            sum = 0;
            //isUsed = new int[n];
            selected = new nums[2];
            for(int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            backtrack(0);
            sb.append(sum).append('\n');

        }

        System.out.println(sb);
    }

    static void backtrack(int idx) {
        if(idx == 2) {
			/*for(int i=0; i<2; i++) {
				System.out.print(selected[i].num + " ");
			}
			System.out.println();*/
            int A = Math.max(selected[0].num, selected[1].num);
            int B = Math.min(selected[0].num, selected[1].num);
            solution(A, B);
            return;
        }

        int start;

        if(idx == 0) {
            start = 0;
        } else {
            start = selected[idx - 1].idx + 1;
        }

        for(int i=start; i<n; i++) {
			/*if(isUsed[i] == 0) {
				selected[idx] = new nums();
				selected[idx].num = arr[i];
				selected[idx].idx = i;
				//isUsed[i]++;
				backtrack(idx + 1);
				//isUsed[i]--;
			}*/
            selected[idx] = new nums();
            selected[idx].num = arr[i];
            selected[idx].idx = i;
            //isUsed[i]++;
            backtrack(idx + 1);
            //isUsed[i]--;
        }
    }

    //최대공약수를 구하는 함수 - 유클리드호제법사용
    //유클리드 호제법은 A>B일때, A와 B의 최대공약수는, A를 B로 나눈 나머지가 R이라고 할때, B와 R의 최대공약수와 같다.
    static void solution(int a, int b) {

        if(b == 0){
            sum += a;
            return;
        }

        solution(b, a%b);

    }

}

