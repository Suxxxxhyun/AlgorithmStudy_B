package baekjun.src.baekjun.BinarySearch;

//구현 성공
//가능한 블루레이 크기중 최소를 출력한다.
//-> 블루레이의 특정한 크기(ans)이라고 할때, ans의 크기로 이루어진 블루레이 m개에 모든 강의를 넣을 수 있냐, 없냐?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제의 최대치
//강의의 수(n)는 최대 십만, 블루레이의 개수(m)은 n이 10만이라고 할때, 최대 십만의 값을 가짐 -> 둘다 int가능
//10만개로 이루어진 강의 모두 만분이고,
//블루레이의 개수(m)이 1로 주어진다면,
//이때 블루레이의 크기(ans)는 최대 10만개*만 이므로 10만 * 만 = 10^9 = 십억이므로, ans는 int가능
//강의의 총합(sum)역시, 최대 10만개*만 이므로 10만 * 만 = 10^9 = 십억이므로, sum은 int가능
//강의들은 최대 만분을 넘지 못하므로 -> int[]가능
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
        //left를 0이 아닌 1로 설정한 이유는, 강의의 수는 자연수로 주어지기 때문에,
        //강의의 수가 1개라고 한다면, 강의 한개를 무조건 블루레이공간에 넣어야하기 때문,
        //또, 블루레이의 크기 자체역시 자연수로 주어지니, mid값이 0이 나오지 못하기 위해, left를 1로 설정하자.
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

        int lecs = 0; //강의의 합
        int count = 1; //**count를 0으로 두는 순간, 입력예제에 따르면, x가 15일때, count는 3으로 만들어짐.
        //그래서 막기위해 count를 1로 초기값설정

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
