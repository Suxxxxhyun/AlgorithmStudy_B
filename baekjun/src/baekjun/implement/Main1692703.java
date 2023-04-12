package baekjun.src.baekjun.implement;

import java.util.*;
import java.io.*;

//10:47 ~ 11:15
//https://velog.io/@yoonuk/%EB%B0%B1%EC%A4%80-16927-%EB%B0%B0%EC%97%B4-%EB%8F%8C%EB%A6%AC%EA%B8%B0-2-Java%EC%9E%90%EB%B0%94

public class Main1692703 {

    static int N, M, R;
    static int[][] map;

    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ȸ�����Ѿ��ϴ� ��� �� ��ŭ �ݺ�
        int nN = N; //5
        int nM = M; //4
        for(int i=0; i<Math.min(M, N)/2; i++) {
            /*
             * i : ȸ���� ������ ��ǥ
             * 2*N + 2*M - 4 : ó���� ���� �� �׵θ��� ����, �� ������ �� �� ���̰� 2�� �ٵ��� �ؼ� �־���
             */

            //start - �ش� �׷쿡�� ȸ���� �����ϴ� ��ǥ
            //len - �ش� �׷쿡 �ִ� �� ����
            rotate(i, 2*nN + 2*nM - 4);
            nN -= 2;
            nM -= 2;
        }

        print();
    }

    static void rotate(int start, int len) {

        // ������ ������ ����Ͽ� �ݺ��Ǵ� �ݺ��� �ּ�ȭ ���ش�.
        int cir = R % len;

        // ���Ӱ� ���س� ȸ�� Ƚ�� ��ŭ ȸ����Ŵ
        for(int t=0; t<cir; t++) {

            int temp = map[start][start]; // �������� ���� �� �̸� ������

            int idx = 0; // ���� �� Ž���� �ε���

            int x = start;
            int y = start;

            while(idx < 4) {

                int nx = x + dir[idx][0];
                int ny = y + dir[idx][1];

                if(nx >= start && ny >= start && nx < N-start && ny < M-start) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    idx++;
                }
            }
            map[start+1][start] = temp;	// �������� �̸� ������ �� �־���
        }

    }

    static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}
