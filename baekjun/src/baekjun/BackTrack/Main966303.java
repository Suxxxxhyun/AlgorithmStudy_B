package baekjun.BackTrack;

import java.util.Scanner;

public class Main966303 {
	
	public static int N, ans; //ans : 경우의 수를 담는 공간
	public static int[] col;
	//col[i] : i번 행의 퀸은 col[i]번 열에 놓았다는 기록
	public static StringBuilder sb = new StringBuilder();
	
	//row번 ~ N번 행에 대해서 가능한 퀸을 놓는 경우의 수 구하기
	public static void rec_func(int row) {
		if(row == N+1) { // 1~N번 행에 대해서 성공적으로 놓은 경우에만 경우의 수를 세자.
			ans++;
		} else {
			for(int c=1; c<=N; c++) {
				boolean possible = true;
				//row행의 c열에 놓을 수 있으면
				//vaild check(row,c)에 대해서 valid check를 수행하면 됨
				for(int i=1; i<=row-1; i++) {
					//(i,col[i])
					//내가 놓고자 하는 row,c와 i,col[i]이 공격가능한 위치라면
					if(attackable(row, c, i, col[i])) {
						//불가능해
						possible = false;
						break;
					}
				}
				
				if(possible) {
					col[row] = c; //row번째 행, c열에 놓았다는 기록
					rec_func(row+1);
					col[row] = 0;
				}
			}
		}
	}
	
	/*public static boolean validity_check() {
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
	}*/
	
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

