package baekjun.src.baekjun.implement;

//~ 2:10
//완탐인가?

import java.io.*;
import java.util.*;
public class Main1018 {

    static StringTokenizer st;
    static int n,m, min = Integer.MAX_VALUE;
    static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                min = Math.min(pro(i,j), min);
            }
        }
        System.out.println(min);
    }

    //시작점을 x,y로 잡고 8 * 8 크기의 체스판을 만든다. -> 한번 시행할때마다 start를 B로 잡는 경우와 W로 잡았을때의 경우를 모두 파악한다.
    static int pro(int x, int y){

        char start = map[x][y];
        char next;
        int count = Integer.MAX_VALUE;
        int change_count = 0;

        for(int k=0; k<2; k++){
            if(k == 0){
                start = 'B';
                next = 'W';
            } else {
                start = 'W';
                next = 'B';
            }

            change_count = 0;

            for(int i=x; i<x+8; i++){
                for(int j=y; j<y+8; j++){
                    if(y % 2 == 1){
                        if(j % 2 == 1){
                            if(start != map[i][j]){
                                change_count++;
                            }
                        } else {
                            if(next != map[i][j]){
                                change_count++;
                            }
                        }
                    } else {
                        if(j % 2 == 0){
                            if(start != map[i][j]){
                                change_count++;
                            }
                        } else {
                            if(next != map[i][j]){
                                change_count++;
                            }
                        }
                    }
                }
                char temp = start;
                start = next;
                next = temp;

                //System.out.println("start = " + start + "," + "next = " + next);
            }
            //System.out.println(change_count);
            count = Math.min(change_count, count);
        }
        return count;
    }
}
