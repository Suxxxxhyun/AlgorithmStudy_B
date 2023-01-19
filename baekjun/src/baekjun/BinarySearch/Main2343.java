package baekjun.src.baekjun.BinarySearch;

//���� ����
//������ ��緹�� ũ���� �ּҸ� ����Ѵ�.
//-> ��緹���� Ư���� ũ��(ans)�̶�� �Ҷ�, ans�� ũ��� �̷���� ��緹�� m���� ��� ���Ǹ� ���� �� �ֳ�, ����?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//������ �ִ�ġ
//������ ��(n)�� �ִ� �ʸ�, ��緹���� ����(m)�� n�� 10���̶�� �Ҷ�, �ִ� �ʸ��� ���� ���� -> �Ѵ� int����
//10������ �̷���� ���� ��� �����̰�,
//��緹���� ����(m)�� 1�� �־����ٸ�,
//�̶� ��緹���� ũ��(ans)�� �ִ� 10����*�� �̹Ƿ� 10�� * �� = 10^9 = �ʾ��̹Ƿ�, ans�� int����
//������ ����(sum)����, �ִ� 10����*�� �̹Ƿ� 10�� * �� = 10^9 = �ʾ��̹Ƿ�, sum�� int����
//���ǵ��� �ִ� ������ ���� ���ϹǷ� -> int[]����
public class Main2343 {

    static int n,m,ans,sum = 0;
    static int[] lecture;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lecture = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            int lec = Integer.parseInt(st.nextToken());
            lecture[i] = lec;
            sum += lec;
        }

        pro();
    }

    static void pro(){
        //left�� 0�� �ƴ� 1�� ������ ������, ������ ���� �ڿ����� �־����� ������,
        //������ ���� 1����� �Ѵٸ�, ���� �Ѱ��� ������ ��緹�̰����� �־���ϱ� ����,
        //��, ��緹���� ũ�� ��ü���� �ڿ����� �־�����, mid���� 0�� ������ ���ϱ� ����, left�� 1�� ��������.
        int left = 1;
        int right = 1000000000;
        
        while(left <= right){

            int mid = (left + right) / 2;

            if(determination(mid)){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean determination(int x){

        int lecs = 0; //������ ��
        int count = 1; //**count�� 0���� �δ� ����, �Է¿����� ������, x�� 15�϶�, count�� 3���� �������.
        //�׷��� �������� count�� 1�� �ʱⰪ����

        for(int i=1; i<=n; i++){
            if(x >= lecture[i]) {
                lecs += lecture[i];
                if(lecs > x){
                    i -= 1;
                    lecs = 0;
                    count++;
                }
            } else {
                return false;
            }
        }
        return count <= m;

    }
}
