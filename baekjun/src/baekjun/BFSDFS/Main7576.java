package baekjun.src.baekjun.BFSDFS;

//7:14 ~ 7:44
//visited�迭�� ���� ������ �ʰ� map�迭�� �ּ��ϼ��� �����Ѵ�.
//bfs�� ���� �丶����� ��ó�� Ȯ���Ѵ�.
import java.io.*;
import java.util.*;
public class Main7576 {

    static StringTokenizer st;
    static int m,n,min_day = 0;
    static int[][] map;
    static boolean process = false;
    static Queue<Node> ripedQ = new LinkedList<Node>();
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    process = true;
                } else if(map[i][j] == 1){
                    ripedQ.offer(new Node(i,j));
                }
            }
        }
        if(process){
            //�丶�䰡 ���� �� �ִٸ�, �׶��� �ּ��ϼ�
            if(pro()){
                System.out.println(min_day - 1);
            }
            //�丶�䰡 ���� ���ϴ� ��Ȳ
            else {
                System.out.println(-1);
            }

        } else {
            System.out.println(0);
        }
    }

    static boolean pro(){
        while(!ripedQ.isEmpty()){
            Node q = ripedQ.poll();

            for(int i=0; i<4; i++){
                int nx = q.x + dir[i][0];
                int ny = q.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }

                //�丶�䰡 ������� �ʴٸ� �Ѿ.
                if(map[nx][ny] == -1){
                    continue;
                }

                if(map[nx][ny] == 0){
                    map[nx][ny] = map[q.x][q.y] + 1;
                    ripedQ.offer(new Node(nx, ny));
                }
            }
        }

        boolean isNotCan = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    isNotCan = false;
                    break;
                }
                min_day = Math.max(map[i][j], min_day);
                //System.out.print(map[i][j] + " ");
            }
            //System.out.println();
        }
        return isNotCan;
    }
}
