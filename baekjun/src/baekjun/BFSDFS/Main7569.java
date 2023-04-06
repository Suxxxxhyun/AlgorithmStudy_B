package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
//��,�Ʒ�,����,������,��,�ڶ�� �ϴµ� ��,��..?
//�ּ��ϼ���� �ϴ� bfs�� Ǯ����ҰͰ���.
//�;�; ����? ���� ��� �׷����� ��Ÿ����;; ���� �� ��� �����Ѵ�;; �湮ó���� ��� �Ѵ�;;
//������������.. 3�����迭�� �̿��غ���...... -> �� �� ������!
//14����ó�� �������迭�� Ÿ������ �ϴ� map�� �������ٱ�?
//multisourceBFS��! ������� ���������� �ؼ� �����ϴ� �����ҿ� �����.
//�׷��ٸ� ���� �丶���� ��ǥ�� �̸� ť�� �־�����.
//~3:07���� ������ ����ϱ�(�亸�����!)

//������ �̵��� multisourceBFS�� ������� ť�� �־������ ����Ʈ�� �־��־����� Ȯ���ϱ�.
public class Main7569 {

    static StringTokenizer st;
    static int n,m,h;
    static int[][] dir = {{0,-1,0},{0,1,0},{0,0,-1},{0,0,1},{1,0,0},{-1,0,0}};
    static int[][][] map;
    //visited�� �ʿ���� ������ ���� �丶�並 �������� �丶�並 �Ͱ� ������ٰ��ε�,
    //�丶�䰡 �;����� map�� 1�� ���Ž��� ǥ���Ѵ�.
    //static boolean[][][] visited;
    //q = ���� �丶�並 �־��ִ� ����
    static Queue<Node> q = new LinkedList<Node>();
    static class Node{
        int h, x, y;

        public Node(int h, int x, int y){
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        boolean not_riped = false;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<m; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 0){
                        not_riped = true;
                    } else if(map[i][j][k] == 1){
                        q.offer(new Node(i,j,k));
                    }
                }
            }
        }

        //�־��� �丶�䰡 ��� ���� ��Ȳ�̶��,
        if(!not_riped){
            System.out.println(0);
        } else {
            bfs();
            boolean not_every_riped = false;
            int result = Integer.MIN_VALUE;
            for(int i=0; i<h; i++){
                for(int j=0; j<n; j++){
                    for(int k=0; k<m; k++){
                        if(map[i][j][k] == 0){
                            not_every_riped = true;
                            break;
                        }
                        if(map[i][j][k] > result){
                            result = map[i][j][k];
                        }
                    }
                }
            }
            if(not_every_riped){
                System.out.println(-1);
            } else {
                System.out.println(result - 1);
            }
        }
    }

    static void bfs(){
        while(!q.isEmpty()){
            Node node = q.poll(); //(1,1,2)�� �ִ� ���� �丶�䰡 ������ ����.
            int nh = 0, nx = 0, ny = 0;

            for(int i=0; i<dir.length; i++){
                nh = node.h + dir[i][0];
                nx = node.x + dir[i][1];
                ny = node.y + dir[i][2];

                if(nh < 0 || nx < 0 || ny < 0 || nh >= h || nx >= n || ny >= m){
                    continue;
                }

                if(map[nh][nx][ny] != 0){
                    continue;
                }

                if(map[nh][nx][ny] == 0){
                    map[nh][nx][ny] = map[node.h][node.x][node.y] + 1;
                    q.offer(new Node(nh,nx,ny));
                }
            }

            /*System.out.println("�����Ϸ��� �丶�� : " + node.h + "," + node.x + "," + node.y);
            for(int i=0; i<h; i++){
                System.out.println(i + "��");
                for(int j=0; j<n; j++){
                    for(int k=0; k<m; k++){
                        System.out.print(map[i][j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }*/
        }
    }
}
