package baekjun.src.baekjun.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//������ ����������
// ��α�(https://st-lab.tistory.com/69)�� Ǯ�̿� ��
// ���� Ǯ�̿� �ٸ�����,
// ��α� : ������ ���ڿ� ������ ���ڸ� ��
// ������ ���ڿ� ������ ���ڰ� �ٸ���쿡 ���ؼ�, ������ ���ڰ� ���ε��� ���ڶ�� �湮üũ.
// ������ ���ڰ� ���ε��� ���ڰ� �ƴ�, �̹� �湮�� ���� �ִ� ���ڶ�� false�� ��ȯ�ϵ��� ����
// �� : ������ ���ڿ� ������ ���ڸ� ��
// ������ ���ڿ� ������ ���ڸ� ���ؼ�
// ���� ���, ������ ���ڸ� �湮üũ. ----------->> ��α� Ǯ�̿� ���غ���, �ᱹ ���� ���� ���� ���� ���� ������ ���ٴ� ���� �˰Ե�.
// �ٸ� ���, ������ ���ڰ� ���ο� ���ڶ�� �湮üũ.
// �ٸ� ���, ������ ���ڰ� ���ο� ���ڰ� �ƴ϶��, false�� ��ȯ�ϵ��� ����
public class Main131602 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int count = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (check()) {
                count++;
            }
        }
        System.out.print(count);
    }

    public static boolean check() throws IOException {
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);


            if (prev != now) {
                if (!check[now - 'a']) {
                    check[now - 'a'] = true;
                    prev = now;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
