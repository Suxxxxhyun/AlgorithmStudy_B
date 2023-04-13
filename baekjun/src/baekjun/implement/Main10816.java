package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
public class Main10816 {

    static int n,m;
    static StringTokenizer st;
    static Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        //입력의 시간복잡도 - O(백만)
        for(int i=0; i<n; i++){
            int key = Integer.parseInt(st.nextToken());
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        //확인의 시간복잡도 - O(백만) - 왜냐면 containsKey메소드의 시간복잡도는 O(1)이기 때문
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                sb.append(map.get(num)).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }
        System.out.println(sb);
    }
}
