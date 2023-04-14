package baekjun.src.baekjun.Sort;

//9:30 ~ 9:50
import java.io.*;
import java.util.*;
//���ʿ� n���� �ִ� 50�̹Ƿ�, ����Ž������ 50*50�� �ð����⵵�� ���´�.
public class Main7568{

    static int n;
    static int[][] a;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            int rank = 1;
            for(int j=0; j<n; j++){
                //���� ����� ���� �ʿ䰡 ����.
                if(i == j){
                    continue;
                }
                if(a[i][0] < a[j][0] && a[i][1] < a[j][1]){
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}