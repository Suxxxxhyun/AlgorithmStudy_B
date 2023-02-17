package baekjun.src.baekjun.String;

import java.io.*;
import java.util.*;
public class Main6550 {

    static String s,t;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str == null){
                break;
            }
            st = new StringTokenizer(str, " ");
            s = st.nextToken();
            t = st.nextToken();
            pro();
        }
    }

    static void pro(){
        int L = 0;
        for(int R=0; R<t.length(); R++){
            if(s.charAt(L) == t.charAt(R)){
                L++;
            }

            //����3ó�� s�� ���̰� �� ª����, �κй��ڿ��� �����Ѱ��, L�� �̹� 5�� ��.
            //�̹� L�� 5�� �Ȼ�Ȳ����, 23����ó�� �񱳸� �Ϸ��� �ϸ� ������ ���״�,
            //�׳� ����������.
            if(L == s.length()){
                System.out.println("Yes");
                return;
            }
        }
        if(L == s.length()){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
