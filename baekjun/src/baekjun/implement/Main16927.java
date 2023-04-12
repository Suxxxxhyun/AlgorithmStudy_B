package baekjun.src.baekjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//�ð��ʰ�
public class Main16927 {
    static int n,m,r;
    static StringTokenizer st;
    static int[][] map;
    //�ϴ� ���α״�� ��, ��, ��, �� -> �� ����� ��,��,��,�� �������� ����
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

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
        //2*2��Ŀ����� ���ư����ϴ� ������ 1��,
        //5*5��Ŀ����� ���ư����ϴ� ������ 2��,
        //4*5��Ŀ����� ���ư����ϴ� ������ 2��
        //����, ������ �ּڰ��� �����Ͽ� /2�� ���� ���ư����ϴ� �������� �� �� �ִ�.
        int count = Math.min(n,m) / 2;

        for(int i=0; i<r; i++) {
            for(int j=0; j<count; j++) {
                //�׻� ù ������ (0,0) / (1,1) .. �̷��� ������ ��.
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

                    /*for(int k=0; k<n; k++){
                        for(int v=0; v<m; v++){
                            System.out.print(map[k][v] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("==================");*/
                }

                map[j+1][j] = value;
            }
        }
    }

    static void output() {
        //System.out.println("��°��-------------------");
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}