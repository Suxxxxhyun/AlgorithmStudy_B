package bakjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main217802 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st = new StringTokenizer(bf.readLine());
	      
	      int N = Integer.parseInt(st.nextToken());
	      int M = Integer.parseInt(st.nextToken());
	      char[][] miro = new char[N][M];  // �̷θ� ������ �迭
	      int[][] dist = new int[N][M];    // �Ÿ��� ����� dist �迭
	      int[] dx = {1, 0 , -1, 0};       // �����¿� ����� x��ǥ
	      int[] dy = {0, 1, 0, -1};        // �����¿� ����� y��ǥ
	      Queue<Pair> qu = new LinkedList<>();
	      
	      for(int i=0; i<N; i++){
	          String line = bf.readLine();
	          for(int j=0; j<M; j++){
	              miro[i][j] = line.charAt(j);
	              dist[i][j] = -1;    // �Ÿ��� -1�� �����ϸ�, �湮���θ� Ȯ�ΰ���.
	          }
	      }
	      
	      qu.offer(new Pair(0,0));  // ������
	      dist[0][0] = 0;   // ù �����̴ϱ� �Ÿ��� 0�̴�.
	      
	      while(!qu.isEmpty()){
	          Pair p = qu.poll();
	          
	          // ��, ��, ��, �츦 ������ش�.
	          for(int i=0; i<4; i++){
	            int nX = p.x + dx[i]; //-1
	            int nY = p.y + dy[i]; //0
	            
	            // ���� �ε����ų�, ������ �Ѿ�� PASS
	            if(nX < 0 || nX >= N || nY < 0 || nY >= M){
	                continue;
	            }
	            // ���� �ƴϰų�, �湮�� �ߴٸ� PASS
	            if(miro[nX][nY] == '0' || dist[nX][nY] != -1){
	                continue;
	            }
	            
	            // ť�� �̵��� ��ǥ�� �־��ش�.
	            qu.offer(new Pair(nX, nY));
	            // ��ĭ �̵��Ͽ��� ������, ���� ��������� �Ÿ� +1�� ���ش�.
	            dist[nX][nY] = dist[p.x][p.y] + 1;
	          }
	      }
	      
	      // ������ ������ (�Ÿ� + 1)�� ������ָ� �ȴ�.
	      System.out.print(dist[N-1][M-1] + 1);

	}
	
	
	public static class Pair{
        int x, y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
    }

}
