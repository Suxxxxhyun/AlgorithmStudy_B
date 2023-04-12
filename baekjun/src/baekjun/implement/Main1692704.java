package baekjun.src.baekjun.implement;

//~11:15
//1692703블로그를 통해 다시 풀어봄.
import java.io.*;
import java.util.*;

public class Main1692704 {

    static StringTokenizer st;
    static int n,m,r;
    static int[][] map;
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
        pro();

    }

    static void pro() {
        //line_cnt = 돌려야하는 라인의 개수
        int line_cnt = Math.min(n,m) / 2;
        int row = n;
        int col = m;
        for(int i=0; i<line_cnt; i++) {

            rotate(i, row * 2 + col * 2 - 4);
            row -= 2;
            col -= 2;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int start, int cnt) {
        int count = r % cnt;

        int x = start;
        int y = start;

        for(int i=0; i<count; i++) {

            int idx = 0;
            int value = map[start][start];

            while(idx < 4) {
                int nx = x + dir[idx][0];
                int ny = y + dir[idx][1];

                if(nx >= start && ny >= start && nx < n - start && ny < m - start) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    idx++;
                }
            }
            map[start + 1][start] = value;
            /*for(int k=0; k<n; k++) {
                for(int j=0; j<m; j++) {
                    System.out.print(map[k][j] + " ");
                }
                System.out.println();
            }
            System.out.println("=================");*/
        }
    }

}

