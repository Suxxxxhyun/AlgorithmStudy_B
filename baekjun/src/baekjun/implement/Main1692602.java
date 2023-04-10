package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;

//https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-16926%EB%B2%88-%EB%B0%B0%EC%97%B4%EB%8F%8C%EB%A6%AC%EA%B8%B01-%EC%9E%90%EB%B0%94Java
//블로그 참조
public class Main1692602 {
    static int n,m,r;
    static StringTokenizer st;
    static int[][] map;
    //일단 블로그대로 우, 하, 좌, 상 -> 내 방식인 상,하,좌,우 가능한지 보기
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotate();
        output();
    }

    static void rotate() {
        //2*2행렬에서는 돌아가야하는 라인이 1개,
        //5*5행렬에서는 돌아가야하는 라인이 2개,
        //4*5행렬에서는 돌아가야하는 라인이 2개
        //따라서, 둘중의 최솟값을 선택하여 /2한 값이 돌아가야하는 라인임을 알 수 있다.
        int count = Math.min(n,m) / 2;

        for(int i=0; i<r; i++) {
            for(int j=0; j<count; j++) {
                //항상 첫 시작은 (0,0) / (1,1) .. 이렇게 시작이 됨.
                int x = j;
                int y = j;

                int value = map[x][y];
                int idx = 0;
                while(idx < 4) {
                    int nx = x + dir[idx][0];
                    int ny = y + dir[idx][1];

                    if(nx >= j && ny >= j && nx < n-j && ny < m-j) {
                        map[x][y] = map[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        idx++;
                    }

                    for(int k=0; k<n; k++){
                        for(int v=0; v<m; v++){
                            System.out.print(map[k][v] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("==================");
                }

                map[j+1][j] = value;
            }
        }
    }

    static void output() {
        System.out.println("출력결과-------------------");
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
