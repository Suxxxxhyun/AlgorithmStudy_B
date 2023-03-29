package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
public class Main162002 {
    static int n,m;
    static StringTokenizer st;
    static Map<String, Integer> pokectmon = new HashMap<String, Integer>();
    static String[] nameArr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nameArr = new String[n+1];
        //���ڿ��� �ش��ϴ� �ε������� value�� ��.
        for(int i=0; i<n; i++){
            String name = br.readLine();
            pokectmon.put(name, i+1);
            nameArr[i] = name;
        }

        while(m-- > 0){
            String str = br.readLine();
            int a = 0;
            if(str.charAt(0) >= '1' && str.charAt(0) <= '9'){
                a = Integer.parseInt(str);
            }
            //���ڷ� ���� ���
            if(a == 0 && str != null){
                sb.append(pokectmon.get(str)).append('\n');
            }
            //���ڷ� ���� ���
            else {
                sb.append(nameArr[a-1]).append('\n');
            }
        }

        System.out.println(sb);
    }
}
