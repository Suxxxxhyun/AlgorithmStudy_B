package baekjun.src.baekjun.basic;

import java.util.Scanner;

public class Main2588 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		String B = in.next();
		
		in.close();
		
		System.out.println(A * (B.charAt(2) - '0')); 
		// charAt(index) : string으로 저장된 문자열 중에서 한글자만 선택하여 char타입으로 변환해줌 
		// -'0'을 해주는 이유 : charAt(2)를 해주게 되면 (예를 들어 473이라고 가정할때, charAt(2) 결과는 문자 3임. 
		// 문자 3을 int형으로 형변환을 하면 아스키코드값이 나옴. 문자3을 int형으로 형변환하면 51이 출력됨.
		// 근데 우리는 숫자 3이 나오게 하고 싶은거잖아. 그럼 51에서 48을 빼줘야하지?
		// 0에 대한 아스키코드값이 48이라서 빼기 '0'를 해주는거임
		System.out.println(A * (B.charAt(1) - '0'));
		System.out.println(A * (B.charAt(0) - '0'));
		System.out.println(A * Integer.parseInt(B)); //integer.parseInt는 문자를 숫자로 바꿔줌

	}

}
