package baekjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0의 아스키코드값 - 48
public class Main1080 {
	
	static int n,m,result;
	static StringTokenizer st;
	static boolean[][] A,B;
	static String str;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new boolean[n][m];
		B = new boolean[n][m];
		result = 0;
		
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<m; j++) {
				if((int)(str.charAt(j)) == 48) {
					A[i][j] = true;
				} else {
					A[i][j] = false;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<m; j++) {
				if((int)(str.charAt(j)) == 48) {
					B[i][j] = true;
				} else {
					B[i][j] = false;
				}
			}
		}
		
		if(confirm() == false) {
			reverse();
			System.out.println(sb);
		} else {
			sb.append(0);
			System.out.println(sb);
		}
	}
	
	//행렬 A와 행렬B가 다르다면 뒤집어주는 함수
	static void reverse() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(A[i][j] != B[i][j] && i+2<n && j+2<m) {
					for(int k=i; k<i+3; k++) {
						for(int l=j; l<j+3; l++) {
							A[k][l] = !A[k][l];
						}
					}
					result++;
				} 
			}
		}
		
		if(confirm()) {
			sb.append(result);
		} else {
			sb.append(-1);
		}
	}
	
	//행렬 A와 행렬B가 같은지 판별하는 함수
	static boolean confirm() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(A[i][j] != B[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
