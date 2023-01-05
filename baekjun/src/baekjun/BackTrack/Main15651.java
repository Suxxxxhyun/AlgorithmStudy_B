package baekjun.BackTrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
////실패 -> 1565102에서 답 확인 가능
public class Main15651 {
	
	public static String[] st;
	public static ArrayList<ArrayList<Integer>> code = new ArrayList<ArrayList<Integer>>();
	public static int N, M;
	
	//[1,2,3,4]
	public static void dfs(int idx, int start) {
		
		if(code.get(idx).size() == M || idx == N || start == 5) {
			return;
		}
		
		code.get(idx).add(start);
		dfs(idx+1,start);
		code.get(idx+1+1).add(idx+start+1+1);
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		
		for(int i=0; i<Math.pow(N, M); i++) {
			code.add(new ArrayList<Integer>());
		}
		
		
		
		dfs(0,1);
	}

}
