package baekjun.src.baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�ð��ʰ�
public class Main4134 {

    static int t; //t(�׽�Ʈ�� ����) -> ������ �������� �����Ƿ� pass
    static double n; //n�� �ִ��� 4�ʾ��̹Ƿ�, int�Ұ���(2^30 = �ʾ�)
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            n = Double.parseDouble(br.readLine());
            solution(n);
        }

        System.out.println(sb);
    }

    static void solution(double num){

        while (true){
            if(confirm(num)){
                sb.append(Math.round(num)).append('\n');
                return;
            }
            num++;
        }
    }

    //�Ҽ����� �Ǻ��ϴ� �Լ�(�Ҽ��� �ڱ��ڽŰ� 1�� ����� ���� ��)
    static boolean confirm(double num){
        int count = 0;
        //��Ʈ num������ �����Ͽ� ������������ ���� �ִ��� �Ǻ��ϱ�(https://st-lab.tistory.com/81��α�����)
        for(int i=2; i<=Math.round(Math.sqrt(num)); i++){
            if(num % i == 0){
                count++;
            }

            if(count > 1){
                break;
            }
        }

        return count < 1;
    }
}
