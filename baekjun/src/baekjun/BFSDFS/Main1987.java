package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987 {

    static int r,c,ans = 0;
    static char[][] a;
    static int[] visited = new int[26];
    static String str;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        a  = new char[r][c];
        for(int i=0; i<r; i++){
            str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                a[i][j] = str.charAt(j);
            }
        }
        pro(0,0,0);
        System.out.println(ans);

    }

    static void pro(int x, int y,int cnt){
        if(visited[a[x][y] - 65] == 1){
            ans = Math.max(ans, cnt);
            return;
        } else {
            visited[a[x][y] - 65] = 1;

            for(int i=0; i<4; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];

                /*if(xx >= r || xx < 0 || yy < 0 || yy >= c){
                    continue;
                }

                if(visited[a[xx][yy] - 65] == 0){
                    pro(xx,yy,cnt + 1);
                } -> 왜 이렇게 짜면 안될까? -> 구한 경우의수에서 더 큰 경우를 찾기위해 dfs탐색을 해야하는데, 그렇지 못함*/

                if(xx >= 0 && xx < r && yy < c && yy >= 0){
                    pro(xx,yy,cnt + 1);
                }
            }
            visited[a[x][y] - 65]--;
        }
    }


}
