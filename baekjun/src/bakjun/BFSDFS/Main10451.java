package bakjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//����׷��������� DFS�� ����Ŭ �Ǻ����θ� �����ϴµ�
//���������� �湮������ �������, �׶� ����Ŭ�� �߻��ߴٰ� �Ǻ��� �� �ִ�.

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
