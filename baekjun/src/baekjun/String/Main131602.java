package baekjun.src.baekjun.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//구현에 성공했지만
// 블로그(https://st-lab.tistory.com/69)에 풀이와 비교
// 나의 풀이와 다른점은,
// 블로그 : 이전의 문자와 지금의 문자를 비교
// 이전의 문자와 지금의 문자가 다른경우에 한해서, 지금의 문자가 새로들어온 문자라면 방문체크.
// 지금의 문자가 새로들어온 문자가 아닌, 이미 방문된 적이 있는 문자라면 false를 반환하도록 리턴
// 나 : 지금의 문자와 다음의 문자를 비교
// 지금의 문자와 다음의 문자를 비교해서
// 같은 경우, 지금의 문자를 방문체크. ----------->> 블로그 풀이와 비교해보니, 결국 나도 같은 경우는 굳이 비교할 이유가 없다는 것을 알게됨.
// 다른 경우, 다음의 문자가 새로운 문자라면 방문체크.
// 다른 경우, 다음의 문자가 새로운 문자가 아니라면, false를 반환하도록 리텅
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
