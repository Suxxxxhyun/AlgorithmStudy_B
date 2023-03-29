package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
//시간초과 코드

//n의 최댓값이 10만이므로, arraylist에 담아도될듯 -> n과 m의 최댓값이 모두 10만이므로,
// 10만개의 데이터가 주어질때, 임의의 인덱스에 위치하는 데이터를 찾는 것이 10만번 이루어진다고 하면
//10만 * 10만이므로 = 백억(시간초과가 남)
//Integer.parseInt와 Integer.valueOf모두 말도안되는 문자열(ex:"Raichu")을 숫자로 변환하려한다면
//numberformatException발생시킴
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
