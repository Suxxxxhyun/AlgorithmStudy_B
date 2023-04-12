package baekjun.src.baekjun.implement;

//8:26 ~ 9:16
//완탐인것같은데? - 승연이가 돌아서 가도 상관없음. 단순히 목적지까지 이동할 수 있는 경로의 개수를 구하는 것임.
//짝수번째 열의 칸은 홀수번째 열의 칸보다 반칸 아래에 위치해 있다.
//시간초과
import java.io.*;
import java.util.*;
public class Main23083 {

    static int n,m,k,ex,ey,cnt;
    static StringTokenizer st;
    //static boolean[][] visited; //(0,0)부터 (2,3)까지표현할 것임.
    static int[][] map;
    static int[][] dir_1 = {{0,1},{1,1},{1,0}};
    static int[][] dir_2 = {{0,1},{-1,1},{1,0}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
        map = new int[n+1][m];
        //visited = new boolean[n+1][m];
        map[ex-1][ey-1] = -1;

        pro();
    }

    static void pro(){
        for(int i=0; i<m; i++){
            if(i % 2 == 1){
                map[0][i] = -1;
            } else {
                map[n][i] = -1;
            }
        }

        /*for(int i=0; i<n+1; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============");*/

        move(0,0,n,m-1, 0);
        System.out.println(cnt % (1000000000 + 7));
    }

    static void move(int startX, int startY, int endX, int endY, int depth){
        if(startX == endX && startY == endY){
            cnt += 1;
            //System.out.println("depth = " + depth);
            return;
        }
        for(int i=0; i<3; i++){
            //오른쪽, 오른쪽대각선아래, 아래
            int nx, ny;
            if(startY % 2 == 0){
                nx = startX + dir_1[i][0];
                ny = startY + dir_1[i][1];
            } else {
                nx = startX + dir_2[i][0];
                ny = startY + dir_2[i][1];
            }

            if(nx < 0 || ny < 0 || nx >= n + 1 || ny >= m){
                continue;
            }

            if(map[nx][ny] == -1){
                continue;
            }

            if(map[nx][ny] == 0){
                //map[nx][ny] = depth;
                move(nx, ny, endX, endY, depth+1);
            }
        }
    }
}
