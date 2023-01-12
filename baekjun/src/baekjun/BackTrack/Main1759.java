package baekjun.src.baekjun.BackTrack;

//https://kwoncorin.tistory.com/103참조, 처음 문자 받을 때 블로그와 다른데, 블로그 방식도 익혀보기 --> 진행해야함! (Main175902)
//[a,c,i,s,t,w]
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1759 {
	
	public static int L,C;
	public static String[] str1;
	public static String str2;
	public static char[] arr, code;
	public static int j = 0;
	
	public static void backTrackFunc(int x, int idx) {
		if(idx == L) {
			return;
		}
		
		for (int i = x; i < C; i++) {
            code[idx] = arr[i];
            backTrackFunc(i+1, idx + 1);
            //어떻게 dfs가 실행되고 있는지 출력해보기 위한 반복문
            for(int j=0; j<code.length; j++) {
            	System.out.print(code[j] + " ");
            }
            System.out.println();
        }
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine().split(" ");
		L = Integer.parseInt(str1[0]);
		C = Integer.parseInt(str1[1]);
		arr = new char[C];
		code = new char[L];
		
		str2 = br.readLine();
		
		for(int i=0; i<str2.length(); i++) {
			if((str2.charAt(i)) == ' ') {
				continue;
			}
			arr[j] = str2.charAt(i);
			j++;
		}
		
		//미리 정렬해줌으로 나중에 굳이 정렬할 필요가 없게됨.
		Arrays.sort(arr);
		
		backTrackFunc(0,0);
	}

}
