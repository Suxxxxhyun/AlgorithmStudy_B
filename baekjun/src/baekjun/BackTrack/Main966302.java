package baekjun.BackTrack;

import java.util.Scanner;

//호석님 풀이 -> 시간초과 
//불필요한 탐색을 계속함, 퀸을 모든 행에 대해 놓았으면, 이미 공격가능한 상황인데도, 탐색을 하고 있는 상황이므로
//불필요한 탐색을 하게 됨.
public class Main966302 {
	
	public static int N, ans; //ans : 경우의 수를 담는 공간
	public static int[] col;
	//col[i] : i번 행의 퀸은 col[i]번 열에 놓았다는 기록
	public static StringBuilder sb = new StringBuilder();
	
	//row번 ~ N번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
	public static void rec_func(int row) {
		if(row == N+1) { // 각 행마다 하나씩 잘 놓았다.
			if(validity_check()) { //서로 공격하는 퀸들이 없는 경우, 이때까지 잘 놓은 퀸에 대해 서로 공격할 수 없는지를 체크하는 함수인 validity_check()
				ans++;
			}
		} else {
			for(int c=1; c<=N; c++) {
				col[row] = c; //row번째 행, c열에 놓았다는 기록
				rec_func(row+1);
				col[row] = 0;
			}
		}
	}
	
	public static boolean validity_check() {
		for(int i=1; i<=N; i++) {
			//i번쨰에 행에 놓인 퀸의 좌표는 -> (i, col[i]) 
			for(int j=1; j<i; j++) {
				//j번쨰에 행에 놓인 퀸의 좌표는 -> (j, col[j])
				if(attackable(i, col[i], j, col[j])) {
					//서로 공격할 수있어? -> ㅇㅇ
					return false;
				}
			}
		}
		return true;
	}
	
	//첫번째 퀸이 r1,c1에 있고
	//두번째 퀸이 r2,c2에 있다고 가정
	public static boolean attackable(int r1, int c1, int r2, int c2) {
		//같은 열에 있다면
		if(c1 == c2) {
			return true;
		}
		//행 - 열의 값이 똑같은 애들은 오른쪽 아래 대각선 -> 즉, 서로 공격할 수 있는 관계
		if(r1 - c1 == r2 - c2) {
			return true;
		}
		//행 + 열의 값이 똑같은 애들은 오른쪽 위 대각선 -> 즉, 서로 공격할 수 있는 관계
		if(r1 + c1 == r2 + c2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		rec_func(1);
		System.out.println(ans);
	}

}
