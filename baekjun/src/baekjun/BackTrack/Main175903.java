package baekjun.src.baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main175903 {

    static int l,c;
    static StringTokenizer st;
    static char[] a;
    static A[] selected;
    static StringBuilder sb = new StringBuilder();

    static class A {
        char alpha;
        int idx;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        a = new char[c];
        selected = new A[l];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<c; i++) {
            a[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(a);
        pro(0);
        System.out.println(sb);
    }

    static void pro(int idx) {
        if(idx == l) {
            if(confirm()) {
                for(int i=0; i<l; i++) {
                    sb.append(selected[i].alpha);
                }
                sb.append('\n');
            }
            return;
        }

        int start = 0;
        if(idx != 0) {
            start = selected[idx - 1].idx + 1;
        }

        for(int i=start; i<c; i++) {
            selected[idx] = new A();
            selected[idx].alpha = a[i];
            selected[idx].idx = i;
            pro(idx + 1);
        }
    }

    static boolean confirm() {
        int mocount = 0, zacount = 0;

        for(int i=0; i<l; i++) {
            if(selected[i].alpha == 'a' || selected[i].alpha == 'e' || selected[i].alpha == 'i' || selected[i].alpha == 'o' || selected[i].alpha == 'u') {
                mocount += 1;
            } else {
                zacount += 1;
            }
        }

        if(mocount >= 1 && zacount >= 2) {
            return true;
        } else {
            return false;
        }
    }

}

