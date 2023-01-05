package baekjun.FloydWarshallAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11404 {
	
	public static int[][] graph = new int[101][101];
	public static final int INF = (int)1e9;

	public static void main(String[] args) throws IOException{
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<101; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) {
					graph[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			String[] st = br.readLine().split(" ");
			int a = Integer.parseInt(st[0]);
			int b = Integer.parseInt(st[1]);
			int c = Integer.parseInt(st[2]);
			if(graph[a][b] < c) {
				continue;
			} else {
				graph[a][b] = c;
			}
		}
		
		for(int k=1; k<=n; k++) {
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(graph[i][j] == INF) {
					sb.append(0).append(" ");
					//System.out.print(0 + " ");
				} else {
					sb.append(graph[i][j]).append(" ");
				}
				//System.out.print(graph[i][j] + " ");
			}
			sb.append('\n');
			//System.out.println();
		}
		
		System.out.println(sb);
	}

}
