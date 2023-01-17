package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//right�� �ʸ����� ����� ���(180ms)
//��� ��û�� ������ �� ���� ���,
//Ư���� ���� ���Ѿ��� ���� ������ �� �������� ������ �� �ֳ�?, ����?
public class Main2512 {

    static int n,m,num,sum = 0,ans = 0; //������ ��(n)�� �ִ��� ���̹Ƿ� int����, �� ����(m)�� �ʾ��̹Ƿ� int����
    //num�� ������ ��û�� ������ ��� ����, �ִ� �ʸ��̹Ƿ� int����
    //�̷��� num�� ��� �迭 a���� int[]����
    //�־��� ������ ��û�ϴ� �� ������ ��(sum)��
    // ������ �� �����̰�, ���� ��� ������ �ʸ����� ��û�ߴٸ� -> ��*�ʸ� -> �ʾ��̹Ƿ� int����
    //�� ����(m)�� �ʾ��� �����ϹǷ�, ������ �̷���� ���� ��� �ʸ����� ������ �� �� ����
    //������ ��Ÿ���� ans�� �ִ�ġ�� �ʸ��̹Ƿ� int����
    static int[] a;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        a = new int[n];
        for(int i=0; i<n; i++){
            num = Integer.parseInt(st.nextToken());
            a[i] = num;
            sum += num;
        }
        m = Integer.parseInt(br.readLine());
        pro();
    }

    static void pro(){
        Arrays.sort(a);
        int left = 1;
        int right = 100000;

        if(sum <= m){
            ans = a[n-1];
        } else {
            while(left <= right){
                int mid = (left + right) / 2;
                if(determination(mid)){
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(ans);
    }

    static boolean determination(int x){

        //Ư�����Ѿ��� �� ���꺸�� ������ �۾ƾ���.
        //Ư�����Ѿ��� �� ���꺸�� ũ�� ������ ������ �ȵǱ� ������.
        if(m < x){
            return false;
        } else {
            int s = 0;

            for(int i=0; i<n; i++){
                if(a[i] < x) {
                    s += a[i];
                } else {
                    s += x;
                }
            }

            return s <= m;
        }
    }
}
