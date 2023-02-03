package baekjun.src.baekjun.DynamicProgramming;

import java.util.Scanner;

//codeTree - �賶ä���
//�ڵ�Ʈ�������� �賶�� ����n�� 100, ���� �� �ִ� ������ �ִ��� 10000���� ������ ������.
public class Main12865CodeTree_fill_backpack {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_M = 10000;
    public static final int MAX_N = 100;

    // dp[i][j] : ���ݱ��� i��° �������� ����غð�,
    //            ���ݱ��� �� ���� ������ ���� j���� ��
    //            ���� �� �ִ� �ִ� ��ġ
    public static int[][] dp = new int[MAX_N + 1][MAX_M + 1];

    public static int n, m;

    public static int[] weight = new int[MAX_N + 1];
    public static int[] value = new int[MAX_N + 1];

    public static void initialize() {
        // �ִ븦 ���ϴ� �����̹Ƿ�,
        // �ʱ⿡�� ���� INT_MIN�� �־��ݴϴ�.
        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= m; j++)
                dp[i][j] = INT_MIN;

        // �ʱ� ��������
        // ���� �ƹ��� ������ ����غ��� ���� ���¸� �����մϴ�.
        // ���� ���ݱ��� 0��° �������� ����غð�,
        // ���ݱ��� �� ���� ������ ���� 0�̾��� ��
        // ��ġ�� 0��ŭ ������Ƿ�
        // dp[0][0] = 0�� �ʱ� �������� �����մϴ�.
        dp[0][0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        initialize();

        //dp[i][j]�� ���� ������!
        // ���ݱ��� i��° �������� ����غð�,
        // ���ݱ��� �� ���� ������ ���� j���� ��
        // ���� �� �ִ� �ִ� ��ġ�� ����մϴ�.
        for(int i = 1; i <= n; i++){
            // �̷� ��Ȳ�� ����� ���� �������� ũ�� 2�� �Դϴ�.

            // Case 1
            // i�� ������ �賶�� ���� �־� ������ ���� j�� �� ����Դϴ�.
            // �� ��쿡�� i�� ������ �����Ͽ� ������ ���� j�� �Ǿ�� �ϹǷ�
            // i - 1��°���� ����Ͽ� �� ���� ������ ���� j - weight[i]����� �մϴ�.
            // ���� �� ��Ȳ������ �ִ� ��ġ�� �ǹ��ϴ� dp[i - 1][j - weight[i]]��
            // ���� ��� �Ǵ� i�� ������ ��ġ value[i]�� ���� ���� ���ο� �������� �˴ϴ�.
            // ��, j < weight[i]�� ��쿡�� i��° ������ �߰��Ͽ� ���԰� j�� �� �� �����Ƿ�
            // j >= weight[i]�� ��쿡�� �����մϴ�.

            // Case 2
            // i�� ������ �������� �ʰ� ������ ���� j�� �� ����Դϴ�.
            // �� ��쿡�� i�� ������ �����ϰ� ������ ���� j�� �Ǿ�� �ϹǷ�
            // i - 1��°���� ����Ͽ� �� ���� ������ ���� j����߸� �մϴ�.
            // ���� �� ��Ȳ������ �ִ� ��ġ�� �ǹ��ϴ� dp[i - 1][j] ���� �ϳ��� �������� �˴ϴ�.

            for(int j = 0; j <= m; j++) {
                // j >= weight[i]�� ��쿡�� Case 1, Case 2 �� �� ���� ���� �����մϴ�.
                if(j >= weight[i])
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);

                    // j < weight[i]�� ��쿡��, Case 2�� �����մϴ�.
                else
                    dp[i][j] = dp[i - 1][j];

                //j < weight[i]���, j-weight[i] < 0�̰� �ǰ�,
                //75��, Math.max���� j - weight[i]�� �� �����ε����� �ǹǷ�, �� ��쿡�� �׳�, dp[i][j] = dp[i - 1][j];�̷��� ���ڴ� ��.
                //�������δ�, �� ���԰� j�� ��Ȳ�� �����ִµ� �̰ź��� ���ſ� ������ ������, ���ſ� ������ �翬�� ���� �� ������ dp[i][j] = dp[i - 1][j];�̷��� �ϰ� �ִ� ��Ȳ��!
            }
        }

        // n���� �������� ���� ����غ��� ��
        // ������ ���� m�� ���� �ʴ� ��츦 ���� �����Ͽ�
        // �� �� �ִ��� �����մϴ�.

        int ans = 0;

        for(int j = 0; j <= m; j++)
            ans = Math.max(ans, dp[n][j]);

        System.out.print(ans);

        //113~115������ �ݵ�� ������ϴ� ������, m�� 10kg�̶���Ѵٸ�
        //���� ��� ����A(8kg,��ġ8), ����B(7kg,��ġ6), ����C(6kg,��ġ9)
        //�̶�, ���԰� 6kg�϶��� ��ġ�� ���� ���� �����̴�.
    }
}
