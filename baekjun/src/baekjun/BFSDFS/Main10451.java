package bakjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//방향그래프에서는 DFS로 사이클 판별여부를 진행하는데
//시작정점과 방문정점이 같은경우, 그때 사이클이 발생했다고 판별할 수 있다.

public class Main10451 {
	
	public static int T, N;
	public static int[] graph;
	public static boolean[] visited;
	public static int cycle;
	
	public static void dfs(int x) {
		
		visited[x] = true;
		
		if(!visited[graph[x]]) {
			dfs(graph[x]);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int j=0; j<T; j++) {
			N = Integer.parseInt(br.readLine());
			graph = new int[1001];
			visited = new boolean[1001];
			cycle = 0;
			String[] str = br.readLine().split(" ");
			
			for(int i=1; i<=N; i++) {
				graph[i] = Integer.parseInt(str[i-1]);
			}
			
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {
					dfs(i);
					cycle++;
				}
			}
			sb.append(cycle).append('\n');
		}
		System.out.println(sb);
	}

}
