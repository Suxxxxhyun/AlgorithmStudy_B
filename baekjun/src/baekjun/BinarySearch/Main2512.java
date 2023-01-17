package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//right를 십만으로 잡아준 경우(180ms)
//모든 요청이 배정될 수 없는 경우,
//특정한 정수 상한액을 통해 국가의 총 예산으로 배정할 수 있냐?, 없냐?
public class Main2512 {

    static int n,m,num,sum = 0,ans = 0; //지방의 수(n)의 최댓값은 만이므로 int가능, 총 예산(m)은 십억이므로 int가능
    //num은 지방이 요청한 예산을 담는 변수, 최대 십만이므로 int가능
    //이러한 num을 담는 배열 a역시 int[]가능
    //주어진 지방이 요청하는 총 예산의 합(sum)은
    // 지방이 총 만개이고, 만개 모두 예산을 십만으로 요청했다면 -> 만*십만 -> 십억이므로 int가능
    //총 예산(m)이 십억이 가능하므로, 만개로 이루어진 지방 모두 십만으로 예산을 줄 수 있음
    //정답을 나타내는 ans는 최대치가 십만이므로 int가능
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

        //특정상한액이 총 예산보다 무조건 작아야함.
        //특정상한액이 총 예산보다 크면 어차피 배정이 안되기 때문임.
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
