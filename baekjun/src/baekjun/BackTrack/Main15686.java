package baekjun.src.baekjun.BackTrack;

import java.util.ArrayList;
import java.util.Scanner;

//https://moonsbeen.tistory.com/189��α� ����
//���� ����
public class Main15686 {

    static int n, m;
    static int[][] board;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Node> chickenList = new ArrayList<>(); //ġŲ�� ��ġ�� �����ϴ� ����Ʈ
    static ArrayList<Node> houseList = new ArrayList<>(); // ���� ��ġ�� �����ϴ� ����Ʈ
    static boolean[] chickenVisited; // ���� ġŲ�� üũ

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt();
                if(board[i][j] == 1) {
                    houseList.add(new Node(i, j));
                }
                else if(board[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }
            }
        }

        chickenVisited = new boolean[chickenList.size()];
        backtracking(0, 0); //m���� ġŲ���� �̴´�.
        System.out.println(min);
    }

    public static void backtracking(int count, int idx) {
        if(count == m) { //ġŲ �Ÿ��� �ּڰ��� ���Ѵ�.
            int total = 0; // ������ ġŲ�Ÿ�
            for(int i = 0; i < houseList.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j = 0; j < chickenList.size(); j++) {
                    if(chickenVisited[j] == true) { //i��° ���������� j��° ġŲ�� ������ �Ÿ� �� �ּҰ��� ���Ѵ�.
                        int dist = Math.abs(houseList.get(i).x - chickenList.get(j).x)
                                + Math.abs(houseList.get(i).y - chickenList.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            min = Math.min(total, min);
            return;
        }

        for(int i = idx; i < chickenList.size(); i++) {
            if(chickenVisited[i] == false) {
                chickenVisited[i] = true;
                backtracking(count + 1, i + 1);
                chickenVisited[i] = false;
            }
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}