package bakjun.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//https://wonit.tistory.com/m/421블로그 참조

public class Main2178 {
	
	static int [][] graph;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		graph = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String[] line = br.readLine().split("");
			for(int j=1; j<=M; j++) {
				graph[i][j] = Integer.parseInt(line[j-1]);
				//System.out.print(graph[i][j]);
			}
			//System.out.println();
		}
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		Queue<MazePoint> queue = new LinkedList<>();
		queue.add(new MazePoint(1,1));
		visited[1][1] = true;
		while(!queue.isEmpty()) {
			MazePoint point = queue.remove();
			for(int i=0; i<dx.length; i++) {
				int xx = point.x + dx[i]; //2
				int yy = point.y + dy[i]; //1
				if(xx > 0 && yy > 0 && xx<=M && yy <=N) {
					if(graph[yy][xx] != 0 && !visited[yy][xx]) {
						visited[yy][xx] = true;
						graph[yy][xx] = graph[point.y][point.x] + 1;
						queue.add(new MazePoint(xx,yy));
					}
				}
			}
		}
		
		bw.write(String.valueOf(graph[N][M]));
		bw.flush();
		bw.close();
	}

}

class MazePoint{
	int x;
	int y;
	MazePoint(int x,int y){
		this.x = x;
		this.y = y;
	}
}
