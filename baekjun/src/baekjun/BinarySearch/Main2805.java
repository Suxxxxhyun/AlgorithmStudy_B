package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//n의 최댓값 백만, m의 최댓값 2십억이므로 int가능
//높이의 최댓값 십억이므로 int[] 배열에 담을 수 있음
//합을 담는 변수 sum은 나무들이 백만개이고, 백만개의 나무들 모두 높이가 최대 십억이라고 하면, 내가 예를 들어 절단기를 높이 1로 설정했다면
//(십억-1)*백만 으로 합이 계산될테니 int범위에 들어갈 수없어서 long형으로 대체함
public class Main2805 {

    static int n,m;
    static long sum;
    static int[] heights;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        heights = new int[n];

        //높이의 가장 큰 값을 담는 변수,
        //오름차순정렬을 하고 heights.length -1로 접근할 수도있지만, 정렬하는데 시간복잡도는 십만log십만이므로
        //O(1)시간이 되는지 확인해보기위해 hmax에 값을 Math.max로 갱신해볼것임.
        int hmax = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            int height = Integer.parseInt(st.nextToken());
            heights[i] = height;
            hmax = Math.max(hmax, height);

        }

        binarySearch(0, hmax);

    }

    //상근이는 집에 필요한 나무를 항상 가져갈 수 있다는 조건이 있기때문에 예제1처럼 나무의 높이들이 주어진 상황에서,
    //상근이가 요구한것이 21이 될 수는 없음.
    static void binarySearch(int left, int right) {
        int mid = (left + right)/2;
        sum = 0;
        int res = 0;

        if(left > right) {
            System.out.println(mid);
            return;
        }

        for(int i=0; i<n; i++) {
            if(heights[i] > mid) {
                sum += heights[i] - mid;
            }
        }

        if(sum >= m) {
            res = mid;
            binarySearch(mid + 1, right);
        } else {
            binarySearch(left, mid - 1);
        }
    }

}
