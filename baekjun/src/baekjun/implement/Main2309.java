package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
//�ߺ��� ������� �ʰ� ������ ������� �ʴ�
public class Main2309 {

    static int[] a, selected;
    static boolean[] visited;
    static int sum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = new int[9];
        selected = new int[2];
        visited = new boolean[9];
        for(int i=0; i<9; i++){
            int num = Integer.parseInt(br.readLine());
            sum += num;
            a[i] = num;
        }
        Arrays.sort(a);

        pro(0,0);
    }

    //selected�� idx��°�� ���� �� ����� Ű�� �־��ٰǵ�, ���� �� �� �ִ� ����� �� 2���̴�.
    static void pro(int idx, int cnt){

        if(cnt == 2){
            int s = 0;
            for(int i=0; i<selected.length; i++){
                s += selected[i];
            }
            if(sum - s == 100){
                for(int i=0; i<a.length; i++){
                    if(selected[0] == a[i] || selected[1] == a[i]){
                        continue;
                    }
                    sb.append(a[i]).append('\n');
                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        for(int i=0; i<a.length; i++){
            if(!visited[i]){
                selected[idx] = a[i];
                visited[i] = true;
                pro(idx + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
