package baekjun.src.baekjun.Sort;

import java.io.*;
import java.util.*;
public class Main11651 {

    static int n;
    static StringTokenizer st;
    static dot[] d;
    static StringBuilder sb = new StringBuilder();
    static class dot{
        int x, y;

        public dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new dot[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            d[i] = new dot(x,y);
        }
        Arrays.sort(d, new Comparator<dot>(){
           public int compare(dot o1, dot o2){
               if(o1.y == o2.y){
                   return o1.x - o2.x;
               }
               return o1.y - o2.y;
           }
        });

        for(int i=0; i<n; i++){
            sb.append(d[i].x + " " + d[i].y).append('\n');
        }
        System.out.println(sb);


    }
}
