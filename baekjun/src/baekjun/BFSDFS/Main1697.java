package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//구현 실패
//https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%801697-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88블로그 참고
public class Main1697 {

    static int n, k; //n,k의 최댓값 10만이므로 int가능
    static StringTokenizer st;
    static int[] check = new int[100001]; //0부터 10만까지 이동할 수 있음. 이미 방문했던 숫자를 체크하기 위해 check배열생성
    //최소시간을 기록하기 위해 이전위치에서의 시간 + 1을 배열에 넣어줬다?
    //큐에 해당 위치를 넣어주고 check[현재위치]의 값을 1로 변경한다.
    //큐가 비어있지 않을동안 while문을 돌면서 다음에 갈 위치(next)를 변경한다.
    //next가 범위안에 있고 이전에 방문한 이력이 없으면 큐에 넣어준다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //주어진 값이, 수빈이와 수빈이동생의 위치가 같다면 수빈이는 이동해줄 필요가 없음
        if(n == k){
            System.out.println(0);
        } else {
            bfs(n);
        }
    }

    static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;

        while(!q.isEmpty()){
            int x = q.poll();

            for(int i=0; i<3; i++){
                int next;

                if(i == 0){
                    next = x + 1;
                } else if(i == 1){
                    next = x - 1;
                } else {
                    next = x * 2;
                }

                //수빈이가 동생의 위치에 왔다면, 이때까지 이동횟수를 출력한다.
                if(next == k){
                    System.out.println(check[x]);
                    return;
                }

                //내가 이동할 수 있는 범위는 0이상 10만이하이고, 한번도 방문한적이 없을 경우에만 방문할 수 있게끔함.
                if(next >= 0 && next < check.length && check[next] == 0){
                    q.add(next);
                    //이동횟수를 더해준다.
                    check[next] = check[x] + 1;
                }
            }
        }
    }
}
