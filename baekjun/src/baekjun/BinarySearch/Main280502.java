package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2805는 Math.max로 가장 큰 값을 접근했다면,
//280502는 정렬을 통해서 가장 큰 값의 인덱스를 접근하기 위한 방법
public class Main280502 {

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


        //오름차순정렬을 하고 heights.length -1로 접근하하여 높이의 가장 큰 값을 담아볼 것.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            int height = Integer.parseInt(st.nextToken());
            heights[i] = height;
        }

        Arrays.sort(heights);
        int hmax = heights[heights.length - 1];

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