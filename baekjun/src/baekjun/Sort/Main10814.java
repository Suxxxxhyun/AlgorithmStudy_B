package baekjun.src.baekjun.Sort;

import java.io.*;
import java.util.*;
public class Main10814 {

    static int n;
    static Person[] p;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static class Person{
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        public String toString(){
            return "age = " + age + ", name = " + name;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new Person[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            p[i] = new Person(age, name);
        }

        Arrays.sort(p, new Comparator<Person>(){
            public int compare(Person o1, Person o2){
                return o1.age - o2.age;
            }
        });

        for(int i=0; i<p.length; i++){
            sb.append(p[i].age + " " + p[i].name).append('\n');
        }
        System.out.println(sb);
    }
}
