package baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Main1759와 입력방법 다르게 해봄
public class Main175902 {

	public static String[] str1, str2;
	public static int L,C;
	public static char[] arr, code;
	public static StringBuilder sb = new StringBuilder();
	//arr이 정렬된 상태이기에 [a,c,i,s,t,w]
	
	public static void backTrackDFS(int cIdx, int aIdx) {
		
		if(cIdx == L) {
			if(pruning()) {
				for(int i=0; i<code.length; i++) {
					sb.append(code[i]);
				}
				sb.append('\n');
				return;
			}
			return;
		}
		
		//code = [a,c,i,s]
		for(int i=aIdx; i<C; i++) {
			code[cIdx] = arr[i];
			//System.out.print(cIdx + " " + i);
			//System.out.println();
			backTrackDFS(cIdx+1, i+1);
			/*for(int j=0; j<L; j++) {
				System.out.print(code[j] + " ");
			}
			System.out.println();*/
		}
	}
	
	public static boolean pruning() {
		
		int mocount = 0;
		int zacount = 0;
		
		/*for(int i=0; i<L; i++) {
			if(code[i] == 'a' || code[i] == 'e' || code[i] == 'i' || code[i] == 'o' || code[i] == 'u') {
				mocount++;
			} else {
				zacount++;
			}
		}foreach로도 할 수 있음 */
		for(char x : code) {
			if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
				mocount++;
			} else {
				zacount++;
			}
		}
		
		if(mocount >= 1 && zacount >= 2) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[]args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine().split(" ");
		L = Integer.parseInt(str1[0]);
		C = Integer.parseInt(str1[1]);
		arr = new char[C];
		code = new char[L];
		
		str2 = br.readLine().split(" ");
		for(int i=0; i<C; i++) {
			arr[i] = str2[i].charAt(0);
		}
		
		Arrays.sort(arr);
		
		backTrackDFS(0,0);
		System.out.println(sb);
	}

}
