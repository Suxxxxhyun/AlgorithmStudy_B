package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
//�ð��ʰ� �ڵ�

//n�� �ִ��� 10���̹Ƿ�, arraylist�� ��Ƶ��ɵ� -> n�� m�� �ִ��� ��� 10���̹Ƿ�,
// 10������ �����Ͱ� �־�����, ������ �ε����� ��ġ�ϴ� �����͸� ã�� ���� 10���� �̷�����ٰ� �ϸ�
//10�� * 10���̹Ƿ� = ���(�ð��ʰ��� ��)
//Integer.parseInt�� Integer.valueOf��� �����ȵǴ� ���ڿ�(ex:"Raichu")�� ���ڷ� ��ȯ�Ϸ��Ѵٸ�
//numberformatException�߻���Ŵ
public class Main1620 {

    static int n,m;
    static StringTokenizer st;
    static ArrayList<String> pokcetmon = new ArrayList<String>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            pokcetmon.add(br.readLine());
        }
        for(int i=0; i<m; i++){
            String str = br.readLine();
            int a = 0;
            if(str.charAt(0) >= '1' && str.charAt(0) <= '9'){
                a = Integer.parseInt(str);
            }
            if(a == 0 && str != null){
                sb.append(pokcetmon.indexOf(str) + 1).append('\n');
            } else {
                sb.append(pokcetmon.get(a - 1)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
