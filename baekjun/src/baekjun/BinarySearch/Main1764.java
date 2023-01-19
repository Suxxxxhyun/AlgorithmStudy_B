package baekjun.src.baekjun.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1764 {

    static int n,m;
    static StringTokenizer st;
    static Set<String> h = new HashSet<String>();
    static ArrayList<String> ans = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //5�ʸ� �Է¹���
        for(int i=0; i<n; i++){
            h.add(br.readLine());
        }

        int cnt = 0;
        String human = "";

        //5�ʸ�������, ���� ���� ����� ����ִ� h�� ������ ���� ����� �ִ��� Ȯ��
        for(int i=0; i<m; i++){
            human = br.readLine();
            if(h.contains(human)){
                cnt++;
                ans.add(human);
            }
        }

        //5�ʸ�log5�ʸ�
        Collections.sort(ans);

        sb.append(cnt).append('\n');
        
        //5�ʸ�
        for(int i=0; i<ans.size(); i++){
            sb.append(ans.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}
