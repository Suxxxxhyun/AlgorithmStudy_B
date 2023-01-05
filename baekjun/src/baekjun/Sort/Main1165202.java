package baekjun.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1165202 {
	
	static int n;
	static long[] a;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new long[n+1];
		for(int i=1; i<=n; i++) {
			a[i] = Long.parseLong(br.readLine());
		}
		
		pro();
	}
	
	static void pro() {
		Arrays.sort(a, 1, n+1); //sort
		long mode = a[1]; 
		int modeCnt = 1, curCnt = 1; //mode : ÃÖºó°ª, modeCnt: ÃÖºó°ªÀÇ µîÀåÈ½¼ö, curCnt:ÇöÀç °ª(a[1])ÀÇ µîÀåÈ½¼ö
		
		for(int i=2; i<=n; i++) {
			if(a[i] == a[i-1]) {
				curCnt++;
			} else {
				curCnt = 1;
			}
			
			if(curCnt > modeCnt) {
				modeCnt = curCnt;
				mode = a[i];
			}
		}
		
		System.out.println(mode);
	}

}
