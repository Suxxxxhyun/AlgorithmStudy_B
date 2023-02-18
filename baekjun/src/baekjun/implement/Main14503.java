package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
//������ part02. ������ ���Ӱ��� ������ �Ȱ���.
public class Main14503 {

    static int n,m,r,c,direction;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        visited[r][c] = true;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    static void turn_left(){
        direction -= 1;
        if(direction == -1){
            direction = 3;
        }
    }

    static void pro(){
        //�κ�û�ұⰡ �ִ� ĭ�� ��ĭ�̶�� ������ ��õǾ��ִ�.
        //ó�� �κ�û�ұⰡ �ִ� ���� r,c�� �־����µ�, �̶����� ��ĭ�̶�� �ǹ̸� ���ϰ� �����Ƿ�,
        //ó�� �κ�û�ұⰡ ��ġ�� ���� û�����־��ٰ� �ϱ� ���� cnt�� 1�� �ʱ�ȭ�Ѵ�.
        int cnt = 1;
        int turn_time = 0;
        while(true){
            turn_left();
            int nx = r + dx[direction];
            int ny = c + dy[direction];

            if(!visited[nx][ny] && graph[nx][ny] == 0){
                visited[nx][ny] = true;
                r = nx;
                c = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }
            //ȸ���� ���Ŀ� ���鿡 �̹� �湮�� ĭ�̰ų� û���� ���
            else turn_time += 1;
            //�� ���� ��� �� �� ���� ���
            if(turn_time == 4){
                nx = r - dx[direction];
                ny = c - dy[direction];
                if(graph[nx][ny] == 0){
                    r = nx;
                    c = ny;
                    turn_time = 0;
                }
                //�ڰ� ������ �����ִ� ���
                else break;
            }
        }
        System.out.println(cnt);
    }
}
