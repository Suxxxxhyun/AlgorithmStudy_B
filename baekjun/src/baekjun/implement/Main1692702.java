package baekjun.src.baekjun.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//�ð��ʰ�
public class Main1692702 {
    static int n,m,r;
    static int[][] a;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
        output();
    }

    static void pro(){
        //�ǹ���1. count�� �� �Ʒ��� ���� ����� �ϰ� ������?
        int count = Math.min(n,m) / 2; //���ư��� ������ ��
        for(int i=0; i<r; i++){
            for(int j=0; j<count; j++){ //���ε� ���� ������
                int temp = a[j][j]; //�� �������� �ֱ� ���� ���� ����

                for(int k=j+1; k<m-j; k++){ //1 2 3 4 -> 2 3 4
                    a[j][k-1] = a[j][k];
                }

                for(int k=j+1; k<n-j; k++){ //8 12 16
                    a[k-1][m-1-j] = a[k][m-1-j];
                }

                for(int k=m-2-j; k>=j; k--) { //13 14 15
                    a[n-1-j][k+1] = a[n-1-j][k];
                }

                for(int k=n-2-j; k>=j; k--) {
                    a[k+1][j] = a[k][j]; //1 5 9
                }

                a[j+1][j] = temp;
            }
        }
    }

    static void output(){
        for(int j=0; j<n; j++) {
            for(int k=0; k<m; k++) {
                sb.append(a[j][k] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
