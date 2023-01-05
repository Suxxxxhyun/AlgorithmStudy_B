package bakjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//������ ���� ��� Ȱ�� -> ���ʿ� �׷��� 31���� -> �ε��� 4�� ���� ������ �ȵ�
//������ dfs ���� -> ���� �����غ���
//��ķ���ε� ���� ��� �˾ƺ���

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
		} */ // ���ع��� ù��° ���ô�� ����Ѵٸ�, 4��°�� 1,2,3�� ������ �� ��������!
		
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
	
	public static boolean[] visited = new boolean[10001];; //������ ������ ������ŭ �Ҵ��س����� ������, ������ ������ n�� main�ȿ� �ֱ⶧���� n���� ������ŭ �迭�� �Ҵ����
	
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
