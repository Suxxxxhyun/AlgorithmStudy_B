package bakjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//이코테 구현 방식 활용 -> 애초에 그래프 31라인 -> 인덱스 4에 대한 정보가 안들어감
//이코테 dfs 스택 -> 직접 구현해보기
//패캠으로도 접근 방법 알아보기

public class Main1260 {
	
	public static int[][] arr;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		/*for(int i=0; i<M; i++) {
			graph.add(new ArrayList<Integer>());
		}*/
		
		arr = new int[N+1][N+1];
		
		/*for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		} */ // 백준문제 첫번째 예시대로 라고한다면, 4번째의 1,2,3의 정보는 들어갈 수가없음!
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		
		
		DFSFunc(V);
		BFSFunc(V);
		System.out.println(sb);
		
		//System.out.println(graph);

	}
	
	public static boolean[] visited = new boolean[10001];; //원래는 정점의 개수만큼 할당해놓으면 되지만, 정점의 개수인 n이 main안에 있기때문에 n개의 개수만큼 배열을 할당못함
	
	public static StringBuilder sb = new StringBuilder();
	public static void DFSFunc(Integer startNode){
		visited[startNode] = true;
		sb.append(startNode + " ");
		
		
		for(int i=1; i<=arr[startNode].length; i++) {
			if(arr[startNode][i-1] == 1) {
				int x = i-1;
				if(!visited[x]) {
					DFSFunc(x);
				}
			}
		}

	}
	
	public static void BFSFunc(Integer startNode) {
		sb.append('\n');
		visited = new boolean[10001];
		Queue<Integer> q = new LinkedList<>();
		q.offer(startNode);
		visited[startNode] = true;
		
		while(!q.isEmpty()) {
			int y = q.poll();
			sb.append(y + " ");
			for(int i=1; i<=arr[y].length; i++) {
				if(arr[y][i-1] == 1) {
					int x = i-1;
					if(!visited[x]) {
						visited[x] = true;
						q.offer(x);
					}
				}
			}
		}
	}

}
