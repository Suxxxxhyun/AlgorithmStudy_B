package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//��������
/*
n�� �ִ� 10^5, k�� �ִ� 10^9,
n�� 10^5�϶�, ������ �� ������ 10^5^2, �� ��� ���Ҹ� �������迭B�� �ְԵǸ�, 10^10�̹Ƿ�, �̹� �ð��ʰ��� ��.
*/

//��α�(https://st-lab.tistory.com/281)Ǯ��
/*
B[11] = 8�� �ǹ̴� 8�̶�� ������ �۰ų� ���� ������ ������ 11����� ���ؼ��� �� ����. (B�� ������ �������� �����̱⶧����)

�����ϸ�, B[k] = x��� �ǹ̴� x���� �۰ų� ���� ������ ������ �ּ� k����� �ǹ��̴�.
�̶�, B[k] = x���� k�ε����� ���� �� x�� ã�� ���ε�, x�� ���� �����ذ��鼭 x���� �۰ų� ���� ������ ������ k���̶� ��ġ�ϸ� �ȴٴ� ��!
��, x�� mid�� ���ڴ� ��!

��, ���A���� �� �ึ��, 1��, 2��, 3��.. �̷������� ���Ұ� �̷������ �ȴٴ� ���� �� �� �ִ�.
�̶�, ������ x�� ���ؼ� x���� �۰ų� ���� ������ ������
������ ����� ���� �ƴ϶�, (1�ܿ� �ִ� ���� / x + 2�ܿ� �ִ� ���� / x ... + n�ܿ� �ִ� ���� / x)�� �ϰԵǸ�,
x���� �۰ų� ���� ������ ������ ������ ���� �� �ִ�.

��, ������ x�� ���ؼ� x�� ������ 1���� n^2�����ε�, ���� ���, n=4��� �Ѵٸ�, x�� �ʱ������ 1���� 16������� ���� �� �� ����.
�̶�, ������ ���ϼ� ������?

��α׿��� Ȯ���غ��� �˰�����, �ᱹ x<=k��� ����� �� �� ����.
�����ϸ� x�� ������ 1���� k������ ���� �� �ִ�.

�׸���, �� ��α׿� �ٸ��� �׳�, �̺�Ž������ �����Ͽ���, lowerbound�� ������� ����. (�� �κ���, https://steady-coding.tistory.com/20��α� ����)
 */

public class Main130002 {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        pro();
    }

    static void pro(){
        int L = 1, R = k, ans = 0;

        while(L <= R){
            int mid = (L + R) / 2;
            int count = 0;

            for(int i=1; i<=n; i++){
                count += Math.min(mid / i, n);
            }

            if(count < k){
                L = mid + 1;
            } else {
                ans = mid;
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
