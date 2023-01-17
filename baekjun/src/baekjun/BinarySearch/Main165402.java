package baekjun.src.baekjun.BinarySearch;
//right�� Integer.MAX_VALUE�� ���ִ� ��� -> 204ms, Main1654�� 204ms
//������ ���δٰ� �ؼ� �ð��� �ٿ����� �ʾҴ�!

//����N���� ���� �� �ִ� ������ �ִ����(cm)�� ����϶�
//-> ������ ���̸� Ư�� ����(cm)��ŭ �ڸ���, n���� ���� �� �ֳ�, ����?

//1. ������ �ִ�ġ
//k�� n�� �ִ��� ���� ��, �鸸�̹Ƿ� int����
//������ ��� �迭�� -> ������ ���̰� int�����̹Ƿ� int[]����
//cnt(Ư�������Ǳ��̷� �߶����� ���� ������ ����)��,
//�������� ������ �ִ� ������ ������� �Ͽ�����, ������ ���� ��� ���̰� 2^31-1�̰�,
//�ִ� ������ ���̸� 1�� �ϰڴٶ�� �Ѵٸ�, ���� �ϳ��� ���� �� �ִ� ������ 21��, �� 21���� �� ������� �Ѵٸ�
//21�� * �� �̹Ƿ� -> int�� ����� �Ǽ� long���� ������.
//��, ans�� long�� �ɼ��ۿ� ����������, ����, ������ 21������� �����̱⶧���� mid�� 21�� ���� �������� �����̰�����,
//left�� 5��, right�� 21���̸�, mid���� ���ϱ� ����, left + right / 2�� �����ٵ�, left + right�� �̹� int������ �ʰ��ϰ� �ǹǷ�,
//long���� �����Ѵ�.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2. �ð����⵵
//������ �������ִµ� �ð����⵵ : ��log��
//�̺�Ž���ϴµ� �ð����⵵ : log��
//�ѹ� mid���� ���Ҷ�����, n���� ����� �ִ��� ������ Ȯ�����ϹǷ� -> O(�鸸) * O(log��)
//���� �� �ð����⵵ : ��log�� + �鸸log�� => ���ϸ�log��
public class Main165402 {
    static int k,n;
    static long cnt,ans;
    static int[] lan;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        lan = new int[k];
        for(int i=0; i<k; i++){
            lan[i] = Integer.parseInt(br.readLine());
        }

        //left�� 1�� ������ �� �ۿ� ���� ������,
        //���� ���, left = 0, right = 1�̾��� ��, mid���� 0
        //determination�޼��忡�� 0���� ������ �Ǵ� ��Ȳ�� �߻��ǹǷ�, left���� 1�� �����Ѵ�.
        Arrays.sort(lan);
        pro(1, Integer.MAX_VALUE);
    }

    //L + R�� �Ҷ�, L�� 5�� R�� 21���̸�, => 26��..
    //�׷��Ƿ� �����ϰ� left,right,mid�� ��� long���� �ٲ�����Ѵ�.
    static void pro(long left, long right){

        long mid = (left + right) / 2;

        if(left > right){
            System.out.println(ans);
            return;
        }

        if(determination(mid)){
            ans = mid;
            pro(mid + 1, right);
        } else {
            pro(left, mid-1);
        }

    }

    static boolean determination(long length){
        cnt = 0;

        for(int i=0; i<k; i++){
            if(length > lan[i]){
                continue;
            }
            cnt += (lan[i] / length);
        }

        return cnt >= n;
    }
}
