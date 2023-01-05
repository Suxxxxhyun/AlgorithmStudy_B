package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
점의 개수(n)는 최대 5천, 위치(x)는 최대 십만, 점의 개수(n)가 5천이면 색깔(y)은 최대 5천가지 -> 모두 int가능
모든 점에 대해서 같은 색깔을 가진 다른 점이 항상 존재한다.라고 하였으므로
점의 개수(n)가 5천이라고 한다면, 색깔(y)은 2500가지가 나옴
같은 색의 서로 다른 두 점이 가장 멀리 떨어져있는 경우는 (0,10^5) 이때의 거리는 십만. -> 화살표의 길이는 이십만.
2500가지 모두 최대 거리가 십만이라고 한다면 이때의 화살표의 길이는 2500*2*10^5 => 약 5억이므로, 화살표의 총 길이를 담는 변수는 int형 변수에 넣어도 됨
o(n^2) -> 시간복잡도 스터디때 확인 ===========================================
색깔을 인덱스로 하여 위치정보를 담는 배열a가 있다면 이 배열a는 색이 같은 점끼리 위치를 비교하게 됨
1. 배열a에 색깔을 인덱스로 하여 위치정보를 담는 시간복잡도 O(N)
2. 색마다 위치를 정렬 => nlongn
3. 좌우마다 길이를 확인하는 것은 상수시간에 가까움
4. 근데 3번은 모든 점에 대해서 좌우를 확인해줘야하므로 O(N)
-> 총 시간복잡도는 nlogn이라고 할 수 있음
 */
public class Main15970 {

    static int n;
    static ArrayList<Integer>[] a;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int color=1; color<=n; color++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a[y].add(x);
        }

        solution();
    }

    static void solution(){
        for(int i=1; i<=n; i++){
            Collections.sort(a[i]);
        }

        int ans = 0;

        for(int color=1; color<=n; color++){
            for(int i=0; i<a[color].size(); i++) {
                int left_distance = left(color,i);
                int right_distance = right(color,i);
                ans += Math.min(left_distance,right_distance);
            }
        }

        System.out.println(ans);
    }

    static int left(int color, int idx){
        if(idx == 0){ // 왼쪽에 더 이상 점이 없는 상태
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx) - a[color].get(idx-1);
    }

    static int right(int color, int idx){
        if(idx + 1 == a[color].size()){ // 오른쪽에 더 이상 점이 없는 상태
            return Integer.MAX_VALUE;
        }
        return a[color].get(idx+1) - a[color].get(idx);
    }
}
