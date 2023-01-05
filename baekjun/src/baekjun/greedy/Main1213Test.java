package baekjun.greedy;

public class Main1213Test {
	
	public static String result1 = "";

	public static void main(String[] args) {
		
		result1 += "AABB";
		StringBuffer sbf = new StringBuffer(result1);
		String reverse = sbf.reverse().toString();
		System.out.println(reverse);
		
		String str = new String("¾È³ç");
		str = new String();
		System.out.println(str);
		
		char a = '0';
		System.out.println((int)a);
		
		char b = 'A';
		System.out.println((int)b);
		
		char c = '1';
		System.out.println((int)c);
	}

}
