package baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//��Ž���� �ΰ��� ���� ���غ���? -> ������ ���� �ִ� 100��
//100���߿��� 2���� �̴� ����� ���� 100C2 = 100*99/2 = 55*99 -> �׽�Ʈ�� ������ �� 100���̹Ƿ�
//100����� 100���� �̷���� ����� �ϸ� -> 55*99*100 = ��50���̹Ƿ� 1�ʾȿ� ����� Ǯ �� ����
//t, n�� �ִ밪 ��� 100�̹Ƿ� int������
//n���� ���� �̷������ ������ ���� ���� -> �ִ� �鸸 -> intŸ���� �������迭����
//���� ��� sum������, ���� ������ 100���̰� �� 100�� ��� �鸸�̶�� �Ѵٸ�, �̶��� �ִ�������
//50�� * �鸸 -> 5õ�� -> long������ ��ƾ���
public class Main9613 {

    static int t, n;
    static long sum;
    static StringTokenizer st;
    static int[] arr; //isUsed;
    static nums[] selected;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> A = new ArrayList<Integer>(); //ù��° ���� ���ؼ� ��� �ִ� ����
    static ArrayList<Integer> B = new ArrayList<Integer>(); //�ι�° ���� ���ؼ� ��� �ִ� ����

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

    //�ִ������� ���ϴ� �Լ� - ��Ŭ����ȣ�������
    //��Ŭ���� ȣ������ A>B�϶�, A�� B�� �ִ�������, A�� B�� ���� �������� R�̶�� �Ҷ�, B�� R�� �ִ������� ����.
    static void solution(int a, int b) {

        if(b == 0){
            sum += a;
            return;
        }

        solution(b, a%b);

    }

}

