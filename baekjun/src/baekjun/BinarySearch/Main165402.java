package baekjun.src.baekjun.BinarySearch;
//right를 Integer.MAX_VALUE로 해주는 경우 -> 204ms, Main1654도 204ms
//범위를 줄인다고 해서 시간이 줄여지진 않았다!

//랜선N개를 만들 수 있는 랜선의 최대길이(cm)를 출력하라
//-> 랜선의 길이를 특정 길이(cm)만큼 자를때, n개를 만들 수 있냐, 없냐?

//1. 정답의 최대치
//k와 n의 최댓값은 각각 만, 백만이므로 int가능
//랜선을 담는 배열은 -> 랜선의 길이가 int범위이므로 int[]가능
//cnt(특정랜선의길이로 잘랐을때 나온 랜선의 총합)는,
//오영식이 가지고 있는 랜선이 만개라고 하였을때, 만개의 랜선 모두 길이가 2^31-1이고,
//최대 랜선의 길이를 1로 하겠다라고 한다면, 랜선 하나당 만들 수 있는 개수는 21억, 이 21억이 총 만개라고 한다면
//21억 * 만 이므로 -> int를 벗어나게 되서 long으로 해주자.
//또, ans가 long이 될수밖에 없는이유는, 물론, 랜선은 21억까지의 범위이기때문에 mid가 21억 내의 범위에서 움직이겠지만,
//left가 5억, right가 21억이면, mid값을 구하기 위해, left + right / 2를 해줄텐데, left + right가 이미 int범위를 초과하게 되므로,
//long으로 설정한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2. 시간복잡도
//랜선을 정렬해주는데 시간복잡도 : 만log만
//이분탐색하는데 시간복잡도 : log만
//한번 mid값을 구할때마다, n개를 만들수 있는지 없는지 확인해하므로 -> O(백만) * O(log만)
//따라서 총 시간복잡도 : 만log만 + 백만log만 => 백일만log만
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

        //left를 1로 설정할 수 밖에 없는 이유는,
        //예를 들어, left = 0, right = 1이었을 때, mid값은 0
        //determination메서드에서 0으로 나누게 되는 상황이 발생되므로, left값을 1로 설정한다.
        Arrays.sort(lan);
        pro(1, Integer.MAX_VALUE);
    }

    //L + R을 할때, L이 5억 R이 21억이면, => 26억..
    //그러므로 안전하게 left,right,mid를 모두 long으로 바꿔줘야한다.
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
