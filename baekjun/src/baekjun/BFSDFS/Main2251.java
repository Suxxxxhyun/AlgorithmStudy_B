package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

//���� ����(ȣ�����ڵ�)
public class Main2251 {

    static int[] Limit = new int[3];

    //possible : ���信 ������ ������ ����ϱ� ���� �迭
    static boolean[]  possible = new boolean[205];
    static boolean[][][] visit = new boolean[205][205][205];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // ������ ���� ���¿� ���� �״� ������ �����ϴ� ����ü
    static class State{
        int[] X;
        State(int[] _X){
            X = new int[3];
            for (int i=0;i<3;i++) {
                X[i] = _X[i];
            }
        }

        State move(int from,int to,int[] Limit){
            // from ���뿡�� to �������� ���� �ű��. -> from -> to�� �״ٰ�, from�� ���� ��� ���� to�� ���� ���� ���� ����.
            int[] nX = new int[]{X[0], X[1], X[2]};
            if (X[from] + X[to] <= Limit[to]){  // ���� from �� ���� ���� �� �ִٸ� (from�� ���� ��� ���)
                nX[to] = nX[from] + nX[to];
                nX[from] = 0;
            }else{  // from �� �Ϻθ� �ű� �� �ִ� ��� (to�� ���� ���� ���)
                nX[from] -= Limit[to] - nX[to];
                nX[to] = Limit[to];
            }
            return new State(nX);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<3; i++){
            Limit[i] = Integer.parseInt(st.nextToken());
        }

        pro();
    }

    static void pro(){
        bfs(0,0,Limit[2]);
        for(int i=0; i<=200; i++){
            if(possible[i]){
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    // ���� Ž�� ����~
    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true; //
        Q.add(new State(new int[]{x1, x2, x3}));

        // BFS ���� ����
        while (!Q.isEmpty()) {
            State st = Q.poll();
            if (st.X[0] == 0) { //A�� ������ ����ִٸ�, �̰��� �� ����.
                possible[st.X[2]] = true;
            }
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) {
                        continue; //���� ���볢���� ���� ���� �ʿ䰡 ����.
                    }
                    // i �� ���뿡�� j �� �������� ���� �ű��.
                    State nxt = st.move(from, to, Limit);

                    // ���� �ٲ� ���¸� Ž���� ���� ���ٸ�
                    if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
    }


}
