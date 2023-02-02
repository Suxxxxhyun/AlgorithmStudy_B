package baekjun.src.baekjun.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1181 {

    static int n;
    static String str;
    static StringBuilder sb = new StringBuilder();
    static Set<String> a = new HashSet<String>();
    static ArrayList<letter> list = new ArrayList<>();
    static class letter implements Comparable<letter>{
        int len;
        String str;

        public letter(int len, String str){
            this.len = len;
            this.str = str;
        }

        public int compareTo(letter other){
            if(this.len == other.len){
                return str.compareTo(other.str);
            }
            return this.len - other.len;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            str = br.readLine();
            a.add(str);
        }

        Iterator it = a.iterator();
        while (it.hasNext()){
            Object next = it.next();
            String str = String.valueOf(next);
            list.add(new letter(str.length(), str));
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i).str).append('\n');
        }
        System.out.println(sb);
    }
}
